package com.iti.oishi.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.iti.oishi.model.local.room.Meal;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Dao
public interface MealDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMeal(Meal meal);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateMeal(Meal meal);

    @Delete
    void deleteMeal(Meal meal);

    @Query("SELECT * FROM meals")
    LiveData<List<Meal>> getAllMeals();

    @Query("SELECT * FROM meals WHERE isFavorite = 1")
    LiveData<List<Meal>> getFavoriteMeals();

    @Query("SELECT * FROM meals WHERE isPlanned = 1")
    LiveData<List<Meal>> getPlannedMeals();

    @Query("SELECT * FROM meals WHERE id = :mealId")
    LiveData<Meal> getMealById(int mealId);

    @Query("SELECT * FROM meals WHERE isPlanned = 1 AND plannedDate BETWEEN :startDate AND :endDate")
    LiveData<List<Meal>> getPlannedMealsForNextWeek(Date startDate, Date endDate);
}