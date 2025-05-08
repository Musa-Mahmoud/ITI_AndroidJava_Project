package com.iti.oishi.home.presenter;

import com.iti.oishi.model.local.room.Meal;
import com.iti.oishi.home.view.IHomeFragmentView;
import com.iti.oishi.model.local.MealsLocalDataSource;
import com.iti.oishi.model.repos.IRepository;

public class HomeFragmentPresenter implements IHomeFragmentPresenter {

    private final IRepository repository;
    private final IHomeFragmentView view;

    public HomeFragmentPresenter(IRepository repository, IHomeFragmentView view) {
        this.repository = repository;
        this.view = view;
    }

    @Override
    public void getRandomMeal() {
        repository.getAllMeals().observeForever(meals -> {
            if (meals != null && !meals.isEmpty()) {
                Meal randomMeal = meals.get(0);
                view.displayMeal(randomMeal);
            } else {
                view.showError("Failed to load random meal.");
            }
        });
    }

    @Override
    public void toggleFavorite(int mealId) {
        Meal meal = repository.getFavorites().stream()
                .filter(m -> m.getId() == mealId)
                .findFirst()
                .orElse(null);
        if (meal != null) {
            boolean isFavorite = !meal.isFavorite();
            meal.setFavorite(isFavorite);
            if (isFavorite) {
                view.showFavoriteAddedMessage();
            } else {
                view.showFavoriteRemovedMessage();
            }
        } else {
            view.showError("Meal not found.");
        }
    }

    @Override
    public void togglePlanned(int mealId) {
        Meal meal = repository.getPlannedMeals().stream()
                .filter(m -> m.getId() == mealId)
                .findFirst()
                .orElse(null);
        if (meal != null) {
            boolean isPlanned = !meal.isPlanned();
            meal.setPlanned(isPlanned);
            if (isPlanned) {
                view.showPlannedAddedMessage();
            } else {
                view.showPlannedRemovedMessage();
            }
        } else {
            view.showError("Meal not found.");
        }
    }

    @Override
    public void getAllPlannedMeals() {
        repository.getPlannedMeals().observeForever(meals -> {
            if (meals != null) {
                view.displayPlannedMeals(meals);
            } else {
                view.showError("No planned meals found.");
            }
        });
    }
}