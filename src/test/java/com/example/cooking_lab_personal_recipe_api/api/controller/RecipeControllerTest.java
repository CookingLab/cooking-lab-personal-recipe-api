package com.example.cooking_lab_personal_recipe_api.api.controller;

import com.example.cooking_lab_personal_recipe_api.api.model.Recipe;
import com.example.cooking_lab_personal_recipe_api.service.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
    public void testGetRecipeWithOwner() {
        Recipe recipe = new Recipe();
        when(recipeService.getRecipeByOwner("tm")).thenReturn(Collections.singletonList(recipe));

        ResponseEntity<?> result = recipeController.getRecipe("tm");
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void testGetRecipeWithOwnerAndEmptyList() {
        ResponseEntity<?> result = recipeController.getRecipe("tm");
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }

    @Test
    public void testGetRecipeWithNoParams() {
        Recipe recipe = new Recipe();
        when(recipeService.getAllRecipes()).thenReturn(Collections.singletonList(recipe));

        ResponseEntity<?> result = recipeController.getRecipe(null);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void testGetRecipeWithNoParamsAndEmptyList() {
        ResponseEntity<?> result = recipeController.getRecipe(null);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }

    @Test
    public void testGetRecipeWithOwnerException() {
        when(recipeService.getRecipeByOwner("tm")).thenThrow(new RuntimeException("Service exception"));
        ResponseEntity<?> result = recipeController.getRecipe("tm");
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
        assertEquals("An error occurred while processing the request.", result.getBody());
    }

    @Test
    public void testGetRecipeIdWithNoParams() {
        Recipe recipe = new Recipe();
        when(recipeService.getAllRecipes()).thenReturn(Collections.singletonList(recipe));

        ResponseEntity<?> result = recipeController.getRecipeId(null);
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }

    @Test
    public void testGetRecipeWithId() {
        Recipe recipe = new Recipe();
        when(recipeService.getRecipeById(1)).thenReturn(Collections.singletonList(recipe));

        ResponseEntity<?> result = recipeController.getRecipeId(1);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void testGetRecipeWithIdAndEmptyList() {
        ResponseEntity<?> result = recipeController.getRecipeId(1);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }

    @Test
    public void testGetRecipeWithIdHandlesException() {
        when(recipeService.getRecipeById(1)).thenThrow(new RuntimeException("Simulated exception"));
        ResponseEntity<?> result = recipeController.getRecipeId(1);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
        assertEquals("An error occurred while processing the request.", result.getBody());
    }
}
