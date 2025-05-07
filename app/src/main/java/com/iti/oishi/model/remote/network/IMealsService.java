package com.iti.oishi.model.remote.network;

import com.iti.oishi.model.dto.CategoryResponse;
import com.iti.oishi.model.dto.IngredientResponse;
import com.iti.oishi.model.dto.MealResponse;
import com.iti.oishi.model.dto.NameResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IMealsService {
    @GET("search.php")
    Call<MealResponse> getMealsByName(@Query("s") String nameHint);

    @GET("search.php")
    Call<MealResponse> getMealsByFirstLetter(@Query("f") String letter);

    @GET("lookup.php")
    Call<MealResponse> getMealById(@Query("i") String id);

    @GET("random.php")
    Call<MealResponse> getRandomMeal();

    @GET("category.php")
    Call<CategoryResponse> getDetailedCategories();

    @GET("list.php")
    Call<NameResponse> getCategories(@Query("c") String list);

    @GET("list.php")
    Call<NameResponse> getAreas(@Query("a") String list);

    @GET("list.php")
    Call<IngredientResponse> getIngredients(@Query("i") String list);

    @GET("filter.php")
    Call<MealResponse> getMealsByIngredient(@Query("i") String ingredient);

    @GET("filter.php")
    Call<MealResponse> getMealsByCategory(@Query("c") String category);

    @GET("filter.php")
    Call<MealResponse> getMealsByArea(@Query("a") String area);
}
