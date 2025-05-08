package com.iti.oishi.model.remote.firebase;

import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class MealsFirebaseDataSource implements IMealsFirebaseDataSource {

    private static final String USERS_COLLECTION = "users";
    private final FirebaseAuth firebaseAuth;
    private final FirebaseFirestore firebaseFirestore;

    public MealsFirebaseDataSource() {
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.firebaseFirestore = FirebaseFirestore.getInstance();
    }

    @Override
    public void loginWithEmail(String email, String password, IMealsFirebaseCallback callback) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    FirebaseUser user = authResult.getUser();
                    if (user != null) {
                        callback.onAuthSuccess(user);
                    } else {
                        callback.onAuthFailure("Authentication failed, user null");
                    }
                })
                .addOnFailureListener(e -> callback.onAuthFailure(e.getMessage()));
    }

    @Override
    public void loginWithGoogle(AuthCredential credential, IMealsFirebaseCallback callback) {
        firebaseAuth.signInWithCredential(credential)
                .addOnSuccessListener(authResult -> {
                    FirebaseUser user = authResult.getUser();
                    if (user != null) {
                        callback.onAuthSuccess(user);
                    } else {
                        callback.onAuthFailure("Google sign-in failed, user null");
                    }
                })
                .addOnFailureListener(e -> callback.onAuthFailure(e.getMessage()));
    }

    @Override
    public void logout() {
        firebaseAuth.signOut();
    }

    @Override
    public void registerWithEmail(String email, String password, IMealsFirebaseCallback callback) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    FirebaseUser user = authResult.getUser();
                    if (user != null) {
                        callback.onAuthSuccess(user);
                    } else {
                        callback.onAuthFailure("Registration failed, user null");
                    }
                })
                .addOnFailureListener(e -> callback.onAuthFailure(e.getMessage()));
    }

    @Override
    public FirebaseUser getCurrentUser() {
        return firebaseAuth.getCurrentUser();
    }

    @Override
    public void addUserToFirestore(FirebaseUser user, Object data, IMealsFirebaseCallback callback) {
        addDataToFirestore(USERS_COLLECTION, user.getUid(), data, callback);
    }

    private void addDataToFirestore(String collection, String documentId, Object data, IMealsFirebaseCallback callback) {
        firebaseFirestore.collection(collection).document(documentId).set(data)
                .addOnSuccessListener(aVoid -> callback.onAuthSuccess(firebaseAuth.getCurrentUser()))
                .addOnFailureListener(e -> callback.onAuthFailure(e.getMessage()));
    }
}
