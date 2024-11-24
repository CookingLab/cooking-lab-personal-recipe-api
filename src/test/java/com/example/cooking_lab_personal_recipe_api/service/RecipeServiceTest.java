package com.example.cooking_lab_personal_recipe_api.service;
import com.example.cooking_lab_personal_recipe_api.api.model.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecipeServiceTest {

    @InjectMocks
    private RecipeService recipeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeService = new RecipeService();
    }

    @Test
    public void testGetAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();
        assertTrue(recipes.size() > 0, "Recipe list should not be empty");
    }

    @Test
    public void testGetRecipeByOwner() {
        String owner = "John Doe";
        List<Recipe> recipes = recipeService.getRecipeByOwner(owner);
        for (Recipe recipe : recipes) {
            assertEquals(owner, recipe.getOwner(), "Recipe owner should match the given owner");
        }
    }

    @Test
    public void testGetRecipeById() {
        int id = 1;
        List<Recipe> recipes = recipeService.getRecipeById(id);
        for (Recipe recipe : recipes) {
            assertEquals(id, recipe.getId(), "Recipe ID should match the given ID");
        }
    }
}
