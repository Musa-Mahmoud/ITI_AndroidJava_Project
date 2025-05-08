package com.iti.oishi.model.remote;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.GoogleAuthProvider;
import com.iti.oishi.model.dto.CategoryResponse;
import com.iti.oishi.model.dto.IngredientResponse;
import com.iti.oishi.model.dto.NameResponse;
import com.iti.oishi.model.remote.firebase.IMealsFirebaseCallback;
import com.iti.oishi.model.remote.firebase.IMealsFirebaseDataSource;
import com.iti.oishi.model.remote.network.IMealsNetworkDataSource;
import com.iti.oishi.model.remote.network.IMealsService;
import com.iti.oishi.model.remote.network.INetworkCallback;
import com.iti.oishi.model.dto.MealResponse;
import com.iti.oishi.model.remote.network.MealsNetworkDataSource;

import retrofit2.Call;

public class MealsRemoteDataSource implements IMealsRemoteDataSource {
    private static MealsRemoteDataSource instance;
    private IMealsNetworkDataSource mealsNetworkDataSource;
    private IMealsFirebaseDataSource mealsFirebaseDataSource;
    private final IMealsService mealsService = MealsNetworkDataSource.getMealsService();

    private MealsRemoteDataSource(IMealsNetworkDataSource mealsNetworkDataSource) {
        this.mealsNetworkDataSource = mealsNetworkDataSource;
    }

    private MealsRemoteDataSource(IMealsFirebaseDataSource mealsFirebaseDataSource) {
        this.mealsFirebaseDataSource = mealsFirebaseDataSource;
    }

    private MealsRemoteDataSource(IMealsNetworkDataSource mealsNetworkDataSource,
                                  IMealsFirebaseDataSource mealsFirebaseDataSource) {
        this.mealsNetworkDataSource = mealsNetworkDataSource;
        this.mealsFirebaseDataSource = mealsFirebaseDataSource;
    }

    public static MealsRemoteDataSource getInstance(IMealsNetworkDataSource mealsNetworkDataSource) {
        if (instance == null) {
            instance = new MealsRemoteDataSource(mealsNetworkDataSource);
        }
        return instance;
    }
    public static MealsRemoteDataSource getInstance(IMealsFirebaseDataSource mealsFirebaseDataSource) {
        if (instance == null) {
            instance = new MealsRemoteDataSource(mealsFirebaseDataSource);
        }
        return instance;
    }

    public static MealsRemoteDataSource getInstance(IMealsNetworkDataSource mealsNetworkDataSource,
                                                    IMealsFirebaseDataSource mealsFirebaseDataSource) {
        if (instance == null) {
            instance = new MealsRemoteDataSource(mealsNetworkDataSource, mealsFirebaseDataSource);
        }
        return instance;
    }

    public void signUpWithEmail(String email, String password, IMealsFirebaseCallback callback) {
        mealsFirebaseDataSource.registerWithEmail(email, password, callback);
    }

    public void signInWithEmail(String email, String password, IMealsFirebaseCallback callback) {
        mealsFirebaseDataSource.loginWithEmail(email, password, callback);
    }

    public void signInWithGoogle(GoogleSignInAccount account, IMealsFirebaseCallback callback) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mealsFirebaseDataSource.loginWithGoogle(credential, callback);
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
