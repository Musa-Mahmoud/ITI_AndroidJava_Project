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

    // UI components
    private TextView mealName, originCountry, ingredients, measurements, steps;
    private ImageView mealImage, favoriteButton, plannedButton, playVideoButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mealName = view.findViewById(R.id.mealName);
        originCountry = view.findViewById(R.id.originCountry);
        ingredients = view.findViewById(R.id.ingredientsLabel);
        measurements = view.findViewById(R.id.measurementsLabel);
        steps = view.findViewById(R.id.stepsLabel);
        mealImage = view.findViewById(R.id.mealImage);
        favoriteButton = view.findViewById(R.id.favoriteButton);
        plannedButton = view.findViewById(R.id.calendarButton);
        playVideoButton = view.findViewById(R.id.videoThumbnail);

        presenter.getRandomMeal();

        return view;
    }

    @Override
    public void displayMeal(Meal meal) {
        mealName.setText(meal.getName());
        originCountry.setText(meal.getCategory());
//        ingredients.setText();
//        measurements.setText();
//        steps.setText();

        Glide.with(requireContext())
                .load(meal.getImageUrl())
                .placeholder(R.drawable.ic_loading)
                .into(mealImage);
    }

    @Override
    public void displayPlannedMeals(List<Meal> plannedMeals) {
        Toast.makeText(requireContext(), "Planned meals loaded: " + plannedMeals.size(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFavoriteAddedMessage() {
        Toast.makeText(requireContext(), "Meal added to favorites!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFavoriteRemovedMessage() {
        Toast.makeText(requireContext(), "Meal removed from favorites!", Toast.LENGTH_SHORT).show();
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