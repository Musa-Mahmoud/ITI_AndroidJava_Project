package com.iti.oishi.splash.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;
import com.iti.oishi.R;
import com.iti.oishi.model.local.MealsLocalDataSource;
import com.iti.oishi.model.repos.IRepository;
import com.iti.oishi.model.repos.Repository;
import com.iti.oishi.splash.presenter.ISplashFragmentPresenter;
import com.iti.oishi.splash.presenter.SplashFragmentPresenter;

public class SplashFragment extends Fragment implements ISplashFragmentView {

    public SplashFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = requireContext();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        IRepository repository = Repository.getInstance(
                MealsLocalDataSource.getInstance(getContext())
        );

        ISplashFragmentPresenter splashPresenterView = new SplashFragmentPresenter(SplashFragment.this, repository);

        LottieAnimationView viewSplash = view.findViewById(R.id.frgSplash);
        viewSplash.playAnimation();

        splashPresenterView.scheduleHomeNavigation(3000);
    }

    @Override
    public void navToLogin() {
        NavHostFragment.findNavController(this).navigate(R.id.action_splash_to_login);

    }

    @Override
    public void navToHome() {
        NavHostFragment.findNavController(this).navigate(R.id.action_splash_to_home);
    }
}