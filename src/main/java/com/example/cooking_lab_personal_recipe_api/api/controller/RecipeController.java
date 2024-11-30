package com.example.cooking_lab_personal_recipe_api.api.controller;

import com.example.cooking_lab_personal_recipe_api.api.model.Recipe;
import com.example.cooking_lab_personal_recipe_api.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
@Tag(name = "Recipes", description = "Endpoints for managing recipes")
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://cooking-lab.netlify.app"})
    @Operation(
            summary = "Get recipes by owner or all recipes",
            description = "Retrieve recipes by specifying an owner or get all available recipes."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recipes retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No recipes found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/api/recipes/personal")
    public ResponseEntity<?> getRecipe(
            @Parameter(description = "The owner of the recipes to retrieve", example = "tm")
            @RequestParam(required = false) String owner) {
        try {
            if (owner != null && !owner.isEmpty()) {
                List<Recipe> recipes = recipeService.getRecipeByOwner(owner);

                if (recipes.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No recipes found for the given owner.");
                }

                return ResponseEntity.ok(recipes);
            } else {
                List<Recipe> allRecipes = recipeService.getAllRecipes();

                if (allRecipes.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No recipes available.");
                }

                return ResponseEntity.ok(allRecipes);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while processing the request.");
        }
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://cooking-lab.netlify.app"})
    @Operation(
            summary = "Get recipes by ID",
            description = "Retrieve recipes by specifying the recipe ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recipe retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid ID parameter"),
            @ApiResponse(responseCode = "404", description = "No recipes found for the given ID"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/api/recipes/personal/{id}")
    public ResponseEntity<?> getRecipeId(
            @Parameter(description = "The ID of the recipe to retrieve", example = "1")
            @PathVariable Integer id) {
        try {
            if (id == null) {
                return ResponseEntity.badRequest().body("ID parameter cannot be null.");
            }

            List<Recipe> recipes = recipeService.getRecipeById(id);
            if (recipes.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No recipes found for the given ID.");
            }

            return ResponseEntity.ok(recipes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while processing the request.");
        }
    }
}
