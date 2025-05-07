package com.iti.oishi.model.repos;

import com.iti.oishi.model.dto.CategoryResponse;
import com.iti.oishi.model.dto.IngredientResponse;
import com.iti.oishi.model.dto.MealResponse;
import com.iti.oishi.model.dto.NameResponse;
import com.iti.oishi.model.remote.IMealsRemoteDataSource;
import com.iti.oishi.model.remote.network.INetworkCallback;

public class Repository implements IRepository {
    private static Repository instance;
    private final IMealsRemoteDataSource remoteDataSource;

    private Repository(IMealsRemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public static Repository getInstance(IMealsRemoteDataSource remoteDataSource) {
        if (instance == null) {
            instance = new Repository(remoteDataSource);
        }
        return instance;
    }

    @Override
    public void getMealsByName(String nameHint, INetworkCallback<MealResponse> networkCallback) {
        remoteDataSource.getMealsByName(nameHint, networkCallback);
    }

    @Override
    public void getMealsByFirstLetter(String letter, INetworkCallback<MealResponse> networkCallback) {
        remoteDataSource.getMealsByFirstLetter(letter, networkCallback);
    }

    @Override
    public void getMealById(String id, INetworkCallback<MealResponse> networkCallback) {
        remoteDataSource.getMealById(id, networkCallback);
    }

    @Override
    public void getRandomMeal(INetworkCallback<MealResponse> networkCallback) {
        remoteDataSource.getRandomMeal(networkCallback);
    }

    @Override
    public void getDetailedCategories(INetworkCallback<CategoryResponse> networkCallback) {
        remoteDataSource.getDetailedCategories(networkCallback);
    }
    
    @Override
    public void getCategories(INetworkCallback<NameResponse> networkCallback) {
        remoteDataSource.getCategories(networkCallback);
    }

    @Override
    public void getAreas(INetworkCallback<NameResponse> networkCallback) {
        remoteDataSource.getAreas(networkCallback);
    }

    @Override
    public void getIngredients(INetworkCallback<IngredientResponse> networkCallback) {
        remoteDataSource.getIngredients(networkCallback);
    }

    @Override
    public void getMealsByIngredient(String ingredient, INetworkCallback<MealResponse> networkCallback) {
        remoteDataSource.getMealsByIngredient(ingredient, networkCallback);
    }

    @Override
    public void getMealsByCategory(String category, INetworkCallback<MealResponse> networkCallback) {
        remoteDataSource.getMealsByCategory(category, networkCallback);
    }

    @Override
    public void getMealsByArea(String area, INetworkCallback<MealResponse> networkCallback) {
        remoteDataSource.getMealsByArea(area, networkCallback);
    }
}
