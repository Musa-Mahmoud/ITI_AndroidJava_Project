package com.iti.oishi.login.presenter;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.iti.oishi.login.view.ILoginFragmentView;
import com.iti.oishi.model.repos.IRepository;
import com.iti.oishi.model.remote.firebase.IMealsFirebaseCallback;
import com.google.firebase.auth.FirebaseUser;

public class LoginFragmentPresenter implements ILoginFragmentPresenter {
    private final ILoginFragmentView loginView;
    private final IRepository repository;

    public LoginFragmentPresenter(ILoginFragmentView loginView, IRepository repository) {
        this.loginView = loginView;
        this.repository = repository;
    }

    @Override
    public void loginWithEmail(String email, String password) {
        loginView.showLoading();
        repository.signInWithEmail(email, password, createAuthCallback());
    }

    @Override
    public void loginWithGoogle(GoogleSignInAccount account) {
        loginView.showLoading();
        if (account != null) {
            repository.signInWithGoogle(account, createAuthCallback());
        } else {
            loginView.hideLoading();
            loginView.onLoginFailure("Google account is null. Please try again.");
        }
    }

    private IMealsFirebaseCallback createAuthCallback() {
        return new IMealsFirebaseCallback() {
            @Override
            public void onAuthSuccess(FirebaseUser user) {
                handleAuthSuccess(user);
            }

            @Override
            public void onAuthFailure(String errorMessage) {
                handleAuthFailure(errorMessage);
            }
        };
    }

    private void handleAuthSuccess(FirebaseUser user) {
        loginView.hideLoading();
        repository.setLoggedIn(true);
        repository.setUserId(user.getUid());
        loginView.onLoginSuccess(user.getUid());
    }

    private void handleAuthFailure(String errorMessage) {
        loginView.hideLoading();
        loginView.onLoginFailure(errorMessage);
    }
}