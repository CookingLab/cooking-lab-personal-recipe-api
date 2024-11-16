package com.example.cooking_lab_personal_recipe_api.api.controller;

import com.example.cooking_lab_personal_recipe_api.api.model.Recipe;
import com.example.cooking_lab_personal_recipe_api.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @GetMapping("/api/recipes/personal")
    public List<Recipe> getRecipe(@RequestParam(required = false) String owner){
        if (owner == null || owner.isEmpty()) {
            return recipeService.getAllRecipes();
        }
        return recipeService.getRecipeByOwner(owner);
    }
}
