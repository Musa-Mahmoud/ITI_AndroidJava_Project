package com.iti.oishi.home.presenter;

public interface IHomeFragmentPresenter {
    void getRandomMeal();
    void toggleFavorite(int mealId);
    void togglePlanned(int mealId);
    void getAllPlannedMeals();
}