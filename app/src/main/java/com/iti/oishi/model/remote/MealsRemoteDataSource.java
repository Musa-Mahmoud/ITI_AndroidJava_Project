package com.iti.oishi.model.remote;

import com.iti.oishi.model.dto.CategoryResponse;
import com.iti.oishi.model.dto.IngredientResponse;
import com.iti.oishi.model.dto.NameResponse;
import com.iti.oishi.model.remote.network.IMealsNetworkDataSource;
import com.iti.oishi.model.remote.network.IMealsService;
import com.iti.oishi.model.remote.network.INetworkCallback;
import com.iti.oishi.model.dto.MealResponse;
import com.iti.oishi.model.remote.network.MealsNetworkDataSource;

import retrofit2.Call;

public class MealsRemoteDataSource implements IMealsRemoteDataSource {
    private static MealsRemoteDataSource instance;
    private final IMealsNetworkDataSource mealsNetworkDataSource;
    private final IMealsService mealsService;

    private MealsRemoteDataSource(IMealsNetworkDataSource mealsNetworkDataSource) {
        this.mealsNetworkDataSource = mealsNetworkDataSource;
        mealsService = MealsNetworkDataSource.getMealsService();
    }

    public static MealsRemoteDataSource getInstance(IMealsNetworkDataSource mealsNetworkDataSource) {
        if (instance == null) {
            instance = new MealsRemoteDataSource(mealsNetworkDataSource);
        }
        return instance;
    }

    @Override
    public void getMealsByName(String nameHint, INetworkCallback<MealResponse> callback) {
        if (nameHint == null || nameHint.isEmpty()) return;
        
        Call<MealResponse> call = mealsService.getMealsByName(nameHint);
        mealsNetworkDataSource.makeNetworkCall(call, callback);
    }

    @Override
    public void getMealsByFirstLetter(String letter, INetworkCallback<MealResponse> callback) {
        if (letter == null || letter.isEmpty()) return;

        Call<MealResponse> call = mealsService.getMealsByFirstLetter(letter);
        mealsNetworkDataSource.makeNetworkCall(call, callback);
    }

    @Override
    public void getMealById(String id, INetworkCallback<MealResponse> callback) {
        if (id == null || id.isEmpty()) return;

        Call<MealResponse> call = mealsService.getMealById(id);
        mealsNetworkDataSource.makeNetworkCall(call, callback);
    }

    @Override
    public void getRandomMeal(INetworkCallback<MealResponse> callback) {
        Call<MealResponse> call = mealsService.getRandomMeal();
        mealsNetworkDataSource.makeNetworkCall(call, callback);
    }

    @Override
    public void getDetailedCategories(INetworkCallback<CategoryResponse> callback) {
        Call<CategoryResponse> call = mealsService.getDetailedCategories();
        mealsNetworkDataSource.makeNetworkCall(call, callback);
    }

    @Override
    public void getCategories(INetworkCallback<NameResponse> callback) {
        Call<NameResponse> call = mealsService.getCategories("list");
        mealsNetworkDataSource.makeNetworkCall(call, callback);
    }

    @Override
    public void getAreas(INetworkCallback<NameResponse> callback) {
        Call<NameResponse> call = mealsService.getAreas("list");
        mealsNetworkDataSource.makeNetworkCall(call, callback);
    }

    @Override
    public void getIngredients(INetworkCallback<IngredientResponse> callback) {
        Call<IngredientResponse> call = mealsService.getIngredients("list");
        mealsNetworkDataSource.makeNetworkCall(call, callback);
    }

    @Override
    public void getMealsByIngredient(String ingredient, INetworkCallback<MealResponse> callback) {
        if (ingredient == null || ingredient.isEmpty()) return;

        Call<MealResponse> call = mealsService.getMealsByIngredient(ingredient);
        mealsNetworkDataSource.makeNetworkCall(call, callback);
    }

    @Override
    public void getMealsByCategory(String category, INetworkCallback<MealResponse> callback) {
        if (category == null || category.isEmpty()) return;

        Call<MealResponse> call = mealsService.getMealsByCategory(category);
        mealsNetworkDataSource.makeNetworkCall(call, callback);
    }

    @Override
    public void getMealsByArea(String area, INetworkCallback<MealResponse> callback) {
        if (area == null || area.isEmpty()) return;

        Call<MealResponse> call = mealsService.getMealsByArea(area);
        mealsNetworkDataSource.makeNetworkCall(call, callback);
    }
}
