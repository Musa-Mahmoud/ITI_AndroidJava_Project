package com.iti.oishi.model.remote;

import com.iti.oishi.model.dto.CategoryResponse;
import com.iti.oishi.model.dto.IngredientResponse;
import com.iti.oishi.model.dto.MealResponse;
import com.iti.oishi.model.dto.NameResponse;
import com.iti.oishi.model.remote.network.INetworkCallback;

public interface IMealsRemoteDataSource {
    void getMealsByName(String nameHint, INetworkCallback<MealResponse> callback);

    void getMealsByFirstLetter(String letter, INetworkCallback<MealResponse> callback);

    void getMealById(String id, INetworkCallback<MealResponse> callback);

    void getRandomMeal(INetworkCallback<MealResponse> callback);

    void getDetailedCategories(INetworkCallback<CategoryResponse> callback);

    void getCategories(INetworkCallback<NameResponse> callback);

    void getAreas(INetworkCallback<NameResponse> callback);

    void getIngredients(INetworkCallback<IngredientResponse> callback);

    void getMealsByIngredient(String ingredient, INetworkCallback<MealResponse> callback);

    void getMealsByCategory(String category, INetworkCallback<MealResponse> callback);

    void getMealsByArea(String area, INetworkCallback<MealResponse> callback);
}
