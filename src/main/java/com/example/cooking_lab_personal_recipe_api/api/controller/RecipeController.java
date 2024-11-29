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

import java.util.List;

@RestController
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://cooking-lab.netlify.app"})
    @GetMapping("/api/recipes/personal")
    public ResponseEntity<?> getRecipe(@RequestParam(required = false) String owner) {
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
    @GetMapping("/api/recipes/personal/{id}")
    public ResponseEntity<?> getRecipeId(@PathVariable Integer id) {
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
