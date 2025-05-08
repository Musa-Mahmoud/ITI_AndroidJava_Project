package com.iti.oishi.model.local;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.iti.oishi.model.local.room.IMealsRoomDataSource;
import com.iti.oishi.model.local.room.Meal;
import com.iti.oishi.model.local.room.MealsRoomDataSource;
import com.iti.oishi.model.local.sharedpref.IMealsSharedPref;
import com.iti.oishi.model.local.sharedpref.MealsSharedPref;

import java.util.List;

public class MealsLocalDataSource implements IMealsLocalDataSource {
    private static MealsLocalDataSource instance;
    private final IMealsRoomDataSource roomDataSource;
    private final IMealsSharedPref mealsSharedPref;

    private MealsLocalDataSource(Context context) {
        this.mealsSharedPref = MealsSharedPref.getInstance(context);
        this.roomDataSource = MealsRoomDataSource.getInstance(context);
    }

    private MealsLocalDataSource(IMealsRoomDataSource roomDataSource, IMealsSharedPref sharedPref) {
        this.roomDataSource = roomDataSource;
        this.mealsSharedPref = sharedPref;
    }
    public static MealsLocalDataSource getInstance(Context context) {
        if (instance == null) {
            instance = new MealsLocalDataSource(context);
        }
        return instance;
    }

    public static MealsLocalDataSource getInstance(IMealsRoomDataSource room, IMealsSharedPref sharedPref) {
        if (instance == null) {
            instance = new MealsLocalDataSource(room, sharedPref);
        }
        return instance;
    }

    // Room
    public LiveData<List<Meal>> getAllMeals() {
        return roomDataSource.getAllMeals();
    }

    public void insertMeal(Meal meal) {
        roomDataSource.insertMeal(meal);
    }

    public void updateMeal(Meal meal) {
        roomDataSource.updateMeal(meal);
    }

    public void deleteMeal(Meal meal) {
        roomDataSource.deleteMeal(meal);
    }

    public LiveData<List<Meal>> getPlannedMeals() {
        return roomDataSource.getPlannedMeals();
    }

    // Shared preferences
    @Override
    public boolean isLoggedIn() {
        return mealsSharedPref.isLoggedIn();
    }

    @Override
    public void setLoggedIn(boolean isLoggedIn) {
        mealsSharedPref.setLoggedIn(isLoggedIn);
    }

    @Override
    public boolean isGuest() {
        return mealsSharedPref.isGuest();
    }

    @Override
    public void setGuest(boolean isGuest) {
        mealsSharedPref.setGuest(isGuest);
    }

    @Override
    public String getUserId() {
        return mealsSharedPref.getUserId();
    }

    @Override
    public void setUserId(String userId) {
        mealsSharedPref.setUserId(userId);
    }

    @Override
    public void clearPreferences() {
        mealsSharedPref.clearPreferences();
    }
}