package com.iti.oishi.model.local;

import android.content.Context;
import com.iti.oishi.model.local.sharedpref.IMealsSharedPref;
import com.iti.oishi.model.local.sharedpref.MealsSharedPref;

public class MealsLocalDataSource implements IMealsLocalDataSource {
    private static MealsLocalDataSource instance;
    private final IMealsSharedPref mealsSharedPref;

    private MealsLocalDataSource(Context context) {
        this.mealsSharedPref = MealsSharedPref.getInstance(context);
    }

    public static MealsLocalDataSource getInstance(Context context) {
        if (instance == null) {
            instance = new MealsLocalDataSource(context);
        }
        return instance;
    }

    @Override
    public boolean isLoggedIn() {
        return mealsSharedPref.isLoggedIn();
    }

    @Override
    public void setLoggedIn(boolean isLoggedIn) {
        mealsSharedPref.setLoggedIn(isLoggedIn);
    }

    @Override
    public boolean isGuest() {
        return mealsSharedPref.isGuest();
    }

    @Override
    public void setGuest(boolean isGuest) {
        mealsSharedPref.setGuest(isGuest);
    }

    @Override
    public String getUserId() {
        return mealsSharedPref.getUserId();
    }

    @Override
    public void setUserId(String userId) {
        mealsSharedPref.setUserId(userId);
    }

    @Override
    public void clearPreferences() {
        mealsSharedPref.clearPreferences();
    }
}