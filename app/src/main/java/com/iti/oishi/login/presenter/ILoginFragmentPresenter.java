package com.iti.oishi.login.presenter;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public interface ILoginFragmentPresenter {
    void loginWithEmail(String email, String password);

    void loginWithGoogle(GoogleSignInAccount account);
}