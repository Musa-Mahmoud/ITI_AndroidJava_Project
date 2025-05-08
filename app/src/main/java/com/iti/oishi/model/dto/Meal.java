package com.iti.oishi.model.dto;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class Meal {
    @SerializedName("idMeal")
    private String id;
    @SerializedName("strMeal")
    private String name;
    @SerializedName("strCategory")
    private String category;
    @SerializedName("strArea")
    private String area;
    @SerializedName("strMealThumb")
    private String thumbnail;
    @SerializedName("strInstructions")
    private String instructions;
    @SerializedName("strYoutube")
    private String video;
    @SerializedName("strIngredient1")
    private String ingredient1;
    @SerializedName("strIngredient2")
    private String ingredient2;
    @SerializedName("strIngredient3")
    private String ingredient3;
    @SerializedName("strIngredient4")
    private String ingredient4;
    @SerializedName("strIngredient5")
    private String ingredient5;
    @SerializedName("strIngredient6")
    private String ingredient6;
    @SerializedName("strIngredient7")
    private String ingredient7;
    @SerializedName("strIngredient8")
    private String ingredient8;
    @SerializedName("strIngredient9")
    private String ingredient9;
    @SerializedName("strIngredient10")
    private String ingredient10;
    @SerializedName("strIngredient11")
    private String ingredient11;
    @SerializedName("strIngredient12")
    private String ingredient12;
    @SerializedName("strIngredient13")
    private String ingredient13;
    @SerializedName("strIngredient14")
    private String ingredient14;
    @SerializedName("strIngredient15")
    private String ingredient15;
    @SerializedName("strIngredient16")
    private String ingredient16;
    @SerializedName("strIngredient17")
    private String ingredient17;
    @SerializedName("strIngredient18")
    private String ingredient18;
    @SerializedName("strIngredient19")
    private String ingredient19;
    @SerializedName("strIngredient20")
    private String ingredient20;
    @SerializedName("strMeasure1")
    private String measure1;
    @SerializedName("strMeasure2")
    private String measure2;
    @SerializedName("strMeasure3")
    private String measure3;
    @SerializedName("strMeasure4")
    private String measure4;
    @SerializedName("strMeasure5")
    private String measure5;
    @SerializedName("strMeasure6")
    private String measure6;
    @SerializedName("strMeasure7")
    private String measure7;
    @SerializedName("strMeasure8")
    private String measure8;
    @SerializedName("strMeasure9")
    private String measure9;
    @SerializedName("strMeasure10")
    private String measure10;
    @SerializedName("strMeasure11")
    private String measure11;
    @SerializedName("strMeasure12")
    private String measure12;
    @SerializedName("strMeasure13")
    private String measure13;
    @SerializedName("strMeasure14")
    private String measure14;
    @SerializedName("strMeasure15")
    private String measure15;
    @SerializedName("strMeasure16")
    private String measure16;
    @SerializedName("strMeasure17")
    private String measure17;
    @SerializedName("strMeasure18")
    private String measure18;
    @SerializedName("strMeasure19")
    private String measure19;
    @SerializedName("strMeasure20")
    private String measure20;

    private Map<String, String> ingredients;

    public Meal() {
    }

    public Meal(String id, String name, String category, String area, String thumbnail,
                String instructions, String video) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.area = area;
        this.thumbnail = thumbnail;
        this.instructions = instructions;
        this.video = video;
    }

    private Map<String, String > populateIngredients() {
        if (ingredients == null) {
            ingredients = new HashMap<>();
        }

        if (ingredient1 != null && !ingredient1.isEmpty() && measure1 != null && !measure1.isEmpty()) {
            ingredients.put(ingredient1, measure1);
        }
        if (ingredient2 != null && !ingredient2.isEmpty() && measure2 != null && !measure2.isEmpty()) {
            ingredients.put(ingredient2, measure2);
        }
        if (ingredient3 != null && !ingredient3.isEmpty() && measure3 != null && !measure3.isEmpty()) {
            ingredients.put(ingredient3, measure3);
        }
        if (ingredient4 != null && !ingredient4.isEmpty() && measure4 != null && !measure4.isEmpty()) {
            ingredients.put(ingredient4, measure4);
        }
        if (ingredient5 != null && !ingredient5.isEmpty() && measure5 != null && !measure5.isEmpty()) {
            ingredients.put(ingredient5, measure5);
        }
        if (ingredient6 != null && !ingredient6.isEmpty() && measure6 != null && !measure6.isEmpty()) {
            ingredients.put(ingredient6, measure6);
        }
        if (ingredient7 != null && !ingredient7.isEmpty() && measure7 != null && !measure7.isEmpty()) {
            ingredients.put(ingredient7, measure7);
        }
        if (ingredient8 != null && !ingredient8.isEmpty() && measure8 != null && !measure8.isEmpty()) {
            ingredients.put(ingredient8, measure8);
        }
        if (ingredient9 != null && !ingredient9.isEmpty() && measure9 != null && !measure9.isEmpty()) {
            ingredients.put(ingredient9, measure9);
        }
        if (ingredient10 != null && !ingredient10.isEmpty() && measure10 != null && !measure10.isEmpty()) {
            ingredients.put(ingredient10, measure10);
        }
        if (ingredient11 != null && !ingredient11.isEmpty() && measure11 != null && !measure11.isEmpty()) {
            ingredients.put(ingredient11, measure11);
        }
        if (ingredient12 != null && !ingredient12.isEmpty() && measure12 != null && !measure12.isEmpty()) {
            ingredients.put(ingredient12, measure12);
        }
        if (ingredient13 != null && !ingredient13.isEmpty() && measure13 != null && !measure13.isEmpty()) {
            ingredients.put(ingredient13, measure13);
        }
        if (ingredient14 != null && !ingredient14.isEmpty() && measure14 != null && !measure14.isEmpty()) {
            ingredients.put(ingredient14, measure14);
        }
        if (ingredient15 != null && !ingredient15.isEmpty() && measure15 != null && !measure15.isEmpty()) {
            ingredients.put(ingredient15, measure15);
        }
        if (ingredient16 != null && !ingredient16.isEmpty() && measure16 != null && !measure16.isEmpty()) {
            ingredients.put(ingredient16, measure16);
        }
        if (ingredient17 != null && !ingredient17.isEmpty() && measure17 != null && !measure17.isEmpty()) {
            ingredients.put(ingredient17, measure17);
        }
        if (ingredient18 != null && !ingredient18.isEmpty() && measure18 != null && !measure18.isEmpty()) {
            ingredients.put(ingredient18, measure18);
        }
        if (ingredient19 != null && !ingredient19.isEmpty() && measure19 != null && !measure19.isEmpty()) {
            ingredients.put(ingredient19, measure19);
        }
        if (ingredient20 != null && !ingredient20.isEmpty() && measure20 != null && !measure20.isEmpty()) {
            ingredients.put(ingredient20, measure20);
        }
        return ingredients;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Map<String, String> getIngredients() {
        return populateIngredients();
    }

    public void setIngredients(Map<String, String> ingredients) {
        this.ingredients = ingredients;
    }
}
