package com.example.cooking_lab_personal_recipe_api.api.model;
import java.util.List;

public class Recipe {
    private int id;
    private String title;
    private List<String> ingredients;
    private List<String> instructions;
    private String owner;
    private String imageURL;

    // Constructor
    public Recipe() {
    }
    public Recipe(int id, String title, List<String> ingredients, List<String> instructions, String owner, String imageURL) {
        this.id = id;
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.owner = owner;
        this.imageURL = imageURL;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", ingredients=" + ingredients +
                ", instructions=" + instructions +
                ", owner='" + owner + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
