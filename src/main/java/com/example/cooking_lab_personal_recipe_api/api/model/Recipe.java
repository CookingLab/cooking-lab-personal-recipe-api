package com.example.cooking_lab_personal_recipe_api.api.model;
import java.util.List;

public class Recipe {
    private String title;
    private List<String> ingredients;
    private List<String> instructions;
    private String owner;

    // Constructor
    public Recipe() {
    }
    public Recipe(String title, List<String> ingredients, List<String> instructions, String owner) {
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.owner = owner;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                ", title='" + title + '\'' +
                ", ingredients=" + ingredients +
                ", instructions=" + instructions +
                ", owner='" + owner + '\'' +
                '}';
    }
}
