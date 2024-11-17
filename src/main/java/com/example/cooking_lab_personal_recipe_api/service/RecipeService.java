package com.example.cooking_lab_personal_recipe_api.service;

import com.example.cooking_lab_personal_recipe_api.api.model.Recipe;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    private List<Recipe> recipeList;

    public RecipeService() {
        this.recipeList = new ArrayList<>();
        loadRecipesFromJson();
    }

    private void loadRecipesFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Load the file from the resources folder
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("recipes.json");
            if (inputStream != null) {
                this.recipeList = objectMapper.readValue(inputStream, new TypeReference<List<Recipe>>() {});
            } else {
                throw new IOException("recipes.json not found in resources.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load recipes from JSON file.");
        }
    }

    public List<Recipe> getAllRecipes(){
        return recipeList;
    }

    public List<Recipe> getRecipeByOwner(String owner) {
        List<Recipe> targetRecipes = new ArrayList<>();
        for(Recipe recipe : recipeList){
            if(owner.equals(recipe.getOwner())){
                targetRecipes.add(recipe);
            }
        }
        return targetRecipes;
    }

    public List<Recipe> getRecipeById(int id) {
        List<Recipe> targetRecipes = new ArrayList<>();
        for(Recipe recipe : recipeList){
            if(id == recipe.getId()){
                targetRecipes.add(recipe);
            }
        }
        return targetRecipes;
    }

}
