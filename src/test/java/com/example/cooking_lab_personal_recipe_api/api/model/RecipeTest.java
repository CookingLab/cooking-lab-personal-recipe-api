package com.example.cooking_lab_personal_recipe_api.api.model;import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipeTest {

    @Test

    public void testGettersAndSetters() {
        Recipe recipe = new Recipe();
        recipe.setId(1);
        recipe.setTitle("Pancakes");
        List<String> ingredients = Arrays.asList("Flour", "Eggs", "Milk");
        recipe.setIngredients(ingredients);
        List<String> instructions = Arrays.asList("Mix ingredients", "Cook on stove");
        recipe.setInstructions(instructions);
        recipe.setOwner("John Doe");
        recipe.setImageURL("http://example.com/pancakes.jpg");

        assertEquals(1, recipe.getId());
        assertEquals("Pancakes", recipe.getTitle());
        assertEquals(ingredients, recipe.getIngredients());
        assertEquals(instructions, recipe.getInstructions());
        assertEquals("John Doe", recipe.getOwner());
        assertEquals("http://example.com/pancakes.jpg", recipe.getImageURL());
    }

    @Test
    public void testConstructorWithParameters() {
        List<String> ingredients = Arrays.asList("Flour", "Eggs", "Milk");
        List<String> instructions = Arrays.asList("Mix ingredients", "Cook on stove");
        Recipe recipe = new Recipe(1, "Pancakes", ingredients, instructions, "John Doe", "http://example.com/pancakes.jpg");

        assertEquals(1, recipe.getId());
        assertEquals("Pancakes", recipe.getTitle());
        assertEquals(ingredients, recipe.getIngredients());
        assertEquals(instructions, recipe.getInstructions());
        assertEquals("John Doe", recipe.getOwner());
        assertEquals("http://example.com/pancakes.jpg", recipe.getImageURL());
    }

    @Test
    public void testToString() {
        List<String> ingredients = Arrays.asList("Flour", "Eggs", "Milk");
        List<String> instructions = Arrays.asList("Mix ingredients", "Cook on stove");
        Recipe recipe = new Recipe(1, "Pancakes", ingredients, instructions, "John Doe", "http://example.com/pancakes.jpg");

        String expected = "Recipe{id='1', title='Pancakes', ingredients=[Flour, Eggs, Milk], instructions=[Mix ingredients, Cook on stove], owner='John Doe', imageURL='http://example.com/pancakes.jpg'}";
        assertEquals(expected, recipe.toString());
    }
}
