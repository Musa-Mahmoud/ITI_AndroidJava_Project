package com.iti.oishi.model.remote.firebase;

import androidx.annotation.NonNull;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

public class MealsFirebaseDataSource {

    private final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    public void signUpWithEmail(String email, String password, IMealsFirebaseCallback callback) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful() && task.getResult() != null) {
                        callback.onAuthSuccess(task.getResult().getUser());
                    } else {
                        String errorMessage = task.getException() != null
                                ? task.getException().getLocalizedMessage()
                                : "Unknown error occurred.";
                        callback.onAuthFailure(errorMessage);
                    }
                });
    }

    public void signInWithEmail(String email, String password, IMealsFirebaseCallback callback) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful() && task.getResult() != null) {
                        callback.onAuthSuccess(task.getResult().getUser());
                    } else {
                        String errorMessage = task.getException() != null
                                ? task.getException().getLocalizedMessage()
                                : "Unknown error occurred.";
                        callback.onAuthFailure(errorMessage);
                    }
                });
    }

    public void signInWithGoogle(@NonNull GoogleSignInAccount account, IMealsFirebaseCallback callback) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful() && task.getResult() != null) {
                        callback.onAuthSuccess(task.getResult().getUser());
                    } else {
                        String errorMessage = task.getException() != null
                                ? task.getException().getLocalizedMessage()
                                : "Unknown error occurred.";
                        callback.onAuthFailure(errorMessage);
                    }
                });
    }
}
