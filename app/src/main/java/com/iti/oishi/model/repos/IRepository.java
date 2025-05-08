package com.iti.oishi.model.repos;

import androidx.annotation.NonNull;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.iti.oishi.model.dto.CategoryResponse;
import com.iti.oishi.model.dto.IngredientResponse;
import com.iti.oishi.model.dto.MealResponse;
import com.iti.oishi.model.dto.NameResponse;
import com.iti.oishi.model.remote.firebase.IMealsFirebaseCallback;
import com.iti.oishi.model.remote.network.INetworkCallback;

public interface IRepository {
    // Remote data source methods
    void getMealsByName(String nameHint, INetworkCallback<MealResponse> networkCallback);

    void getMealsByFirstLetter(String letter, INetworkCallback<MealResponse> networkCallback);

    void getMealById(String id, INetworkCallback<MealResponse> networkCallback);

    void getRandomMeal(INetworkCallback<MealResponse> networkCallback);

    void getDetailedCategories(INetworkCallback<CategoryResponse> networkCallback);

    void getCategories(INetworkCallback<NameResponse> networkCallback);

    void getAreas(INetworkCallback<NameResponse> networkCallback);

    void getIngredients(INetworkCallback<IngredientResponse> networkCallback);

    void getMealsByIngredient(String ingredient, INetworkCallback<MealResponse> networkCallback);

    void getMealsByCategory(String category, INetworkCallback<MealResponse> networkCallback);

    void getMealsByArea(String area, INetworkCallback<MealResponse> networkCallback);

    void signUpWithEmail(String email, String password, IMealsFirebaseCallback callback);

    void signInWithEmail(String email, String password, IMealsFirebaseCallback callback);

    void signInWithGoogle(@NonNull GoogleSignInAccount account, IMealsFirebaseCallback callback);


    // Local data source methods
    boolean isLoggedIn();
    void setLoggedIn(boolean isLoggedIn);

    boolean isGuest();
    void setGuest(boolean isGuest);

    String getUserId();
    void setUserId(String userId);

    void clearPreferences();

}
