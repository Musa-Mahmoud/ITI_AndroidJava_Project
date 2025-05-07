package com.iti.oishi.login.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iti.oishi.R;

public class LoginFragment extends Fragment {

    public LoginFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        IRepository repo = Repository.getInstance(MealsRemoteDataSource.getInstance(MealsNetworkDataSource.getInstance()));
//
//        repo.getMealsByName("Arrabiata", new INetworkCallback<MealResponse>() {
//            @Override
//            public void onSuccessfulResponse(MealResponse response) {
//                for (Meal meal : response.getMeals()) {
//                    Log.i(TAG, "-------------onSuccessfulResponse: " + meal.getName() + " ");
//                    if (meal.getIngredients() == null) Log.i(TAG, "5555555555555555555555: ");
//                    else
//                    for (Map.Entry<String, String> ingredient : meal.getIngredients().entrySet()) {
//                        Log.i(TAG, ingredient.getKey() + " " + ingredient.getValue() + '\n');
//                    }
//                }
//            }
//
//            @Override
//            public void onFailedResponse(String errorMsg) {
//                Log.i(TAG, "onFailedResponse: " + errorMsg);
//            }
//        });
//
//        repo.getAreas(new INetworkCallback<NameResponse>() {
//            @Override
//            public void onSuccessfulResponse(NameResponse response) {
//                for (Name name: response.getNameList()) {
//                    Log.i(TAG, "========onSuccessfulResponse: " + name.getName() + '\n');
//                }
//            }
//
//            @Override
//            public void onFailedResponse(String errorMsg) {
//                Log.i(TAG, "onFailedResponse: " + errorMsg);
//            }
//        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }
}