package com.iti.oishi.model.remote.firebase;

import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseUser;

public interface IMealsFirebaseDataSource {
    void loginWithEmail(String email, String password, IMealsFirebaseCallback callback);

    void loginWithGoogle(AuthCredential credential, IMealsFirebaseCallback callback);

    void logout();

    void registerWithEmail(String email, String password, IMealsFirebaseCallback callback);

    FirebaseUser getCurrentUser();

    void addUserToFirestore(FirebaseUser user, Object data, IMealsFirebaseCallback callback);
}
