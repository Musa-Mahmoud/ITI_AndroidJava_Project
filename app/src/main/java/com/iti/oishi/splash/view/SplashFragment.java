package com.iti.oishi.splash.view;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;
import com.iti.oishi.MainActivity;
import com.iti.oishi.R;
import com.iti.oishi.splash.presenter.ISplashPresenterView;
import com.iti.oishi.splash.presenter.SplashPresenter;

public class SplashFragment extends Fragment implements ISplashFragmentView {
    LottieAnimationView viewSplash;
    ISplashPresenterView splashPresenterView;

    public SplashFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        splashPresenterView = new SplashPresenter(SplashFragment.this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewSplash = view.findViewById(R.id.frgSplash);
        viewSplash.playAnimation();

        splashPresenterView.scheduleHomeNavigation(3000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void navToNextScreen() {
        Activity activity = getActivity();
        if (activity instanceof INavigationListener)
            ((MainActivity) activity).navToHome();
    }
}