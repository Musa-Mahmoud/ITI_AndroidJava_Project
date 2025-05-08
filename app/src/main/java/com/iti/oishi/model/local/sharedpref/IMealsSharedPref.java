package com.iti.oishi.model.local.sharedpref;

public interface IMealsSharedPref {
    boolean isLoggedIn();
    void setLoggedIn(boolean isLoggedIn);

    boolean isGuest();
    void setGuest(boolean isGuest);

    String getUserId();
    void setUserId(String userId);

    void clearPreferences();
}