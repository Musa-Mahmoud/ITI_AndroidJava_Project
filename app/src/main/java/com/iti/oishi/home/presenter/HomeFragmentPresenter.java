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

    }

    @Override
    public void toggleFavorite(int mealId) {

    }

    @Override
    public void togglePlanned(int mealId) {

    }

    @Override
    public void getAllPlannedMeals() {

    }
}