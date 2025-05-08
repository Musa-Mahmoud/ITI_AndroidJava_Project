package com.iti.oishi.model.remote.firebase;

import com.google.firebase.auth.FirebaseUser;

public interface IMealsFirebaseCallback {
    void onAuthSuccess(FirebaseUser user);

    void onAuthFailure(String errorMessage);
}
