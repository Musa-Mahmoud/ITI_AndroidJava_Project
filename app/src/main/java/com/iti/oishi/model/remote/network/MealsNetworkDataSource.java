package com.iti.oishi.model.remote.network;

import androidx.annotation.NonNull;

import com.iti.oishi.model.dto.CategoryResponse;
import com.iti.oishi.model.dto.IngredientResponse;
import com.iti.oishi.model.dto.Meal;
import com.iti.oishi.model.dto.MealResponse;
import com.iti.oishi.model.dto.NameResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MealsNetworkDataSource implements IMealsNetworkDataSource {
    private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    private static final String ERROR_MESSAGE = "Failed to fetch data.";
    private static MealsNetworkDataSource instance;
    private static IMealsService mealsService = null;

    private MealsNetworkDataSource() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mealsService = retrofit.create(IMealsService.class);
    }

    public static MealsNetworkDataSource getInstance() {
        if (instance == null) {
            instance = new MealsNetworkDataSource();
        }
        return instance;
    }

    public static IMealsService getMealsService() {
        return mealsService;
    }

    private <T> void handleSuccessfulResponse(T responseBody, INetworkCallback<T> callback) {
        if (responseBody instanceof MealResponse || responseBody instanceof CategoryResponse
                || responseBody instanceof IngredientResponse || responseBody instanceof NameResponse) {
            callback.onSuccessfulResponse(responseBody);
        } else {
            callback.onFailedResponse(ERROR_MESSAGE);
        }
    }

    @Override
    public <T> void makeNetworkCall(Call<T> call, INetworkCallback<T> networkCallback) {
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<T> call, @NonNull retrofit2.Response<T> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    networkCallback.onFailedResponse(ERROR_MESSAGE);
                    return;
                }
                handleSuccessfulResponse(response.body(), networkCallback);
            }

            @Override
            public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
                networkCallback.onFailedResponse(t.getMessage());
            }
        });
    }
}
