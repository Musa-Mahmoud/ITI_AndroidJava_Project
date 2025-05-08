package com.iti.oishi.home.view;

import com.iti.oishi.model.local.room.Meal;

import java.util.List;

public interface IHomeFragmentView {
    void displayMeal(Meal meal);
    void displayPlannedMeals(List<Meal> plannedMeals);
    void showFavoriteAddedMessage();
    void showFavoriteRemovedMessage();
    void showPlannedAddedMessage();
    void showPlannedRemovedMessage();
    void showError(String message);
}