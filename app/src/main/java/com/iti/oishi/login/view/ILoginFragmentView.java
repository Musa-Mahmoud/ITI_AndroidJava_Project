package com.iti.oishi.login.view;

public interface ILoginFragmentView {
    void showLoading();
    void hideLoading();
    void onLoginSuccess(String userId);
    void onLoginFailure(String errorMessage);
}