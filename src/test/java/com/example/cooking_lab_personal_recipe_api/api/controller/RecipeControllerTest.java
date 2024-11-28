package com.example.cooking_lab_personal_recipe_api.api.controller;

import com.example.cooking_lab_personal_recipe_api.api.model.Recipe;
import com.example.cooking_lab_personal_recipe_api.service.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class RecipeControllerTest {

    @Mock
    private RecipeService recipeService;
    @InjectMocks
    private RecipeController recipeController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetRecipeWithId() {
        Recipe recipe = new Recipe();
        when(recipeService.getRecipeById(1)).thenReturn(Collections.singletonList(recipe));

        List<Recipe> result = recipeController.getRecipeId(1);
        assertEquals(1, result.size());
        assertEquals(recipe, result.get(0));
    }

    @Test
    public void testGetRecipeWithOwner() {
        Recipe recipe = new Recipe();
        when(recipeService.getRecipeByOwner("owner")).thenReturn(Collections.singletonList(recipe));

        List<Recipe> result = recipeController.getRecipe("owner");
        assertEquals(1, result.size());
        assertEquals(recipe, result.get(0));
    }

    @Test
    public void testGetRecipeWithNoParams() {
        Recipe recipe = new Recipe();
        when(recipeService.getAllRecipes()).thenReturn(Collections.singletonList(recipe));

        List<Recipe> result = recipeController.getRecipe(null);
        assertEquals(1, result.size());
        assertEquals(recipe, result.get(0));
    }

    @Test
    public void testGetRecipeIdWithNoParams() {
        Recipe recipe = new Recipe();
        when(recipeService.getAllRecipes()).thenReturn(Collections.singletonList(recipe));

        List<Recipe> result = recipeController.getRecipeId(null);
        assertEquals(1, result.size());
        assertEquals(recipe, result.get(0));
    }
}
