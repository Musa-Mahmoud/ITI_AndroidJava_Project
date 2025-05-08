package com.iti.oishi.model.repos;

import androidx.annotation.NonNull;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.iti.oishi.model.local.IMealsLocalDataSource;
import com.iti.oishi.model.remote.IMealsRemoteDataSource;
import com.iti.oishi.model.dto.CategoryResponse;
import com.iti.oishi.model.dto.IngredientResponse;
import com.iti.oishi.model.dto.MealResponse;
import com.iti.oishi.model.dto.NameResponse;
import com.iti.oishi.model.remote.firebase.IMealsFirebaseCallback;
import com.iti.oishi.model.remote.network.INetworkCallback;

public class Repository implements IRepository {
    private static Repository instance;
    private IMealsRemoteDataSource remoteDataSource;
    private IMealsLocalDataSource localDataSource;

    private Repository(IMealsRemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    private Repository(IMealsLocalDataSource localDataSource) {
        this.localDataSource = localDataSource;
    }

    private Repository(IMealsRemoteDataSource remoteDataSource, IMealsLocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    public static Repository getInstance(IMealsRemoteDataSource remoteDataSource) {
        if (instance == null) {
            instance = new Repository(remoteDataSource);
        }
        return instance;
    }

    public static Repository getInstance(IMealsLocalDataSource localDataSource) {
        if (instance == null) {
            instance = new Repository(localDataSource);
        }
        return instance;
    }

    public static Repository getInstance(IMealsRemoteDataSource remoteDataSource, IMealsLocalDataSource localDataSource) {
        if (instance == null) {
            instance = new Repository(remoteDataSource, localDataSource);
        }
        return instance;
    }

    // Remote data source methods
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

    public void signUpWithEmail(String email, String password, IMealsFirebaseCallback callback) {
        remoteDataSource.signUpWithEmail(email, password, callback);
    }

    public void signInWithEmail(String email, String password, IMealsFirebaseCallback callback) {
        remoteDataSource.signInWithEmail(email, password, callback);
    }

    public void signInWithGoogle(@NonNull GoogleSignInAccount account, IMealsFirebaseCallback callback) {
        remoteDataSource.signInWithGoogle(account, callback);
    }


    // Local data source methods
    public boolean isLoggedIn() {
        return localDataSource.isLoggedIn();
    }

    public void setLoggedIn(boolean isLoggedIn) {
        localDataSource.setLoggedIn(isLoggedIn);
    }

    public boolean isGuest() {
        return localDataSource.isGuest();
    }

    public void setGuest(boolean isGuest) {
        localDataSource.setGuest(isGuest);
    }

    public String getUserId() {
        return localDataSource.getUserId();
    }

    public void setUserId(String userId) {
        localDataSource.setUserId(userId);
    }

    public void clearPreferences() {
        localDataSource.clearPreferences();
    }
}
