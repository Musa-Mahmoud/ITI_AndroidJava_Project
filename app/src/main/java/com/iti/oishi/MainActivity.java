package com.iti.oishi;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.iti.oishi.login.view.LoginFragment;
import com.iti.oishi.model.dto.Meal;
import com.iti.oishi.model.dto.MealResponse;
import com.iti.oishi.model.dto.Name;
import com.iti.oishi.model.dto.NameResponse;
import com.iti.oishi.model.remote.MealsRemoteDataSource;
import com.iti.oishi.model.remote.network.INetworkCallback;
import com.iti.oishi.model.remote.network.MealsNetworkDataSource;
import com.iti.oishi.model.repos.IRepository;
import com.iti.oishi.model.repos.Repository;
import com.iti.oishi.splash.view.ISplashNavListener;
import com.iti.oishi.splash.view.SplashFragment;

public class MainActivity extends AppCompatActivity implements ISplashNavListener {
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
    public void navToEntryScreen() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView, getHomeFragment())
                .commit();
    }
}
