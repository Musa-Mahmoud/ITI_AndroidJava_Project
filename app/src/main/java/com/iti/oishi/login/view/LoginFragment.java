package com.iti.oishi.login.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import com.google.firebase.auth.FirebaseAuth;
import com.iti.oishi.R;
import com.iti.oishi.login.presenter.ILoginFragmentPresenter;
import com.iti.oishi.login.presenter.LoginFragmentPresenter;
import com.iti.oishi.model.remote.MealsRemoteDataSource;
import com.iti.oishi.model.remote.firebase.MealsFirebaseDataSource;
import com.iti.oishi.model.repos.Repository;

public class LoginFragment extends Fragment implements ILoginFragmentView {

    private ILoginFragmentPresenter loginPresenter;
    private ProgressBar progressBar;
    private EditText emailInput, passwordInput;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        emailInput = view.findViewById(R.id.email);
        passwordInput = view.findViewById(R.id.password);
        progressBar = view.findViewById(R.id.progressBar);

        Repository repository = Repository.getInstance(MealsRemoteDataSource.getInstance(new MealsFirebaseDataSource()));
        loginPresenter = new LoginFragmentPresenter(this, repository);

        Button loginButton = view.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();

            if (!email.isEmpty() && !password.isEmpty()) {
                loginPresenter.loginWithEmail(email, password);
            } else {
                onLoginFailure("Email and password cannot be empty.");
            }
        });

//        Button googleLoginButton = view.findViewById(R.id.googleLoginButton);
//        googleLoginButton.setOnClickListener(v -> {
//            if (loginPresenter != null) {
//                showLoading();
//                GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getContext());
//                if (account != null) {
//                    loginPresenter.loginWithGoogle(account);
//                } else {
//                    hideLoading();
//                    onLoginFailure("Google Sign-In failed.");
//                }
//            }
//        });

        TextView signUpButton = view.findViewById(R.id.signUp);
        signUpButton.setOnClickListener(v -> {
            NavController navController = NavHostFragment.findNavController(this);
            navController.navigate(R.id.action_login_to_signup);
        });

        TextView guestButton = view.findViewById(R.id.guestLogin);
        guestButton.setOnClickListener(v -> {
            NavController navController = NavHostFragment.findNavController(this);
            navController.navigate(R.id.action_login_to_home);
        });

        TextView forgotPasswordButton = view.findViewById(R.id.forgotPassword);
        forgotPasswordButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString().trim();
            if (!email.isEmpty()) {
                showLoading();
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                        .addOnCompleteListener(task -> {
                            hideLoading();
                            if (task.isSuccessful()) {
                                Toast.makeText(requireContext(), "Password reset email sent.", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(requireContext(), "Failed to send reset email: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            } else {
                Toast.makeText(requireContext(), "Please enter your email.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onLoginSuccess(String userId) {
        NavController navController = NavHostFragment.findNavController(this);
        navController.navigate(R.id.action_login_to_home);
    }

    @Override
    public void onLoginFailure(String errorMessage) {
        Toast.makeText(requireContext(), "Login Failed: " + errorMessage, Toast.LENGTH_SHORT).show();
    }

}