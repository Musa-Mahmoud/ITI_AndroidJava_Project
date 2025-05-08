package com.iti.oishi.home.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.iti.oishi.R;
import com.iti.oishi.home.presenter.HomeFragmentPresenter;
import com.iti.oishi.home.presenter.IHomeFragmentPresenter;
import com.iti.oishi.model.local.MealsLocalDataSource;
import com.iti.oishi.model.local.room.Meal;

import java.util.List;

public class HomeFragment extends Fragment implements IHomeFragmentView {

    private IHomeFragmentPresenter presenter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);;
    }

    @Override
    public void displayMeal(Meal meal) {

    }

    @Override
    public void displayPlannedMeals(List<Meal> plannedMeals) {

    }

    @Override
    public void showFavoriteAddedMessage() {

    }

    @Override
    public void showFavoriteRemovedMessage() {

    }

    @Override
    public void showPlannedAddedMessage() {
        Toast.makeText(requireContext(), "Meal added to planned list!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPlannedRemovedMessage() {
        Toast.makeText(requireContext(), "Meal removed from planned list!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show();
    }
}