package com.iti.oishi.model.local.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;

public class MealsSharedPref implements IMealsSharedPref {

    private static final String PREF_NAME = "MealsPrefs";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    private static final String KEY_IS_GUEST = "isGuest";
    private static final String KEY_USER_ID = "userId";

    private final SharedPreferences sharedPreferences;

    private static MealsSharedPref instance;

    private MealsSharedPref(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized MealsSharedPref getInstance(Context context) {
        if (instance == null) {
            instance = new MealsSharedPref(context);
        }
        return instance;
    }

    @Override
    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    @Override
    public void setLoggedIn(boolean isLoggedIn) {
        sharedPreferences.edit().putBoolean(KEY_IS_LOGGED_IN, isLoggedIn).apply();
    }

    @Override
    public boolean isGuest() {
        return sharedPreferences.getBoolean(KEY_IS_GUEST, false);
    }

    @Override
    public void setGuest(boolean isGuest) {
        sharedPreferences.edit().putBoolean(KEY_IS_GUEST, isGuest).apply();
    }

    @Override
    public String getUserId() {
        return sharedPreferences.getString(KEY_USER_ID, null);
    }

    @Override
    public void setUserId(String userId) {
        sharedPreferences.edit().putString(KEY_USER_ID, userId).apply();
    }

    @Override
    public void clearPreferences() {
        sharedPreferences.edit().clear().apply();
    }
}