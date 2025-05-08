package com.iti.oishi.model.local.room;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface IMealsRoomDataSource {
    LiveData<List<Meal>> getAllMeals();

    LiveData<List<Meal>> getFavoriteMeals();

    LiveData<List<Meal>> getPlannedMeals();

    LiveData<List<Meal>> getPlannedMealsForNextWeek();

    void insertMeal(Meal meal);

    void updateMeal(Meal meal);

    void deleteMeal(Meal meal);

    LiveData<Meal> getMealById(int mealId);
}
