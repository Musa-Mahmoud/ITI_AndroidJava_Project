package com.iti.oishi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.iti.oishi.login.view.LoginFragment;
import com.iti.oishi.splash.view.INavigationListener;
import com.iti.oishi.splash.view.SplashFragment;

public class MainActivity extends AppCompatActivity implements INavigationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragmentContainerView, new SplashFragment())
                    .commit();
        }
    }

    private Fragment getHomeFragment() {
        return new LoginFragment();
    }

    @Override
    public void navToHome() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView, getHomeFragment())
                .commit();
    }
}
