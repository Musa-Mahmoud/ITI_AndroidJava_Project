package com.iti.oishi.model.local.room;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.iti.oishi.room.dao.MealDao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MealsRoomDataSource implements IMealsRoomDataSource {

    private final MealDao mealDao;

    private static MealsRoomDataSource instance;

    private MealsRoomDataSource(Context context) {
        mealDao = MealDb.getInstance(context).getMealDao();
    }

    public static MealsRoomDataSource getInstance(Context context) {
        if (instance == null) {
            instance = new MealsRoomDataSource(context);
        }
        return instance;
    }

    public static boolean isPlannedDateValid(Date plannedDate) {
        Calendar now = Calendar.getInstance();
        Calendar nextWeek = Calendar.getInstance();
        nextWeek.add(Calendar.DAY_OF_YEAR, 7);

        return plannedDate != null && plannedDate.after(now.getTime())
                && plannedDate.before(nextWeek.getTime());
    }

    @Override
    public LiveData<List<Meal>> getAllMeals() {
        return mealDao.getAllMeals();
    }

    @Override
    public LiveData<List<Meal>> getFavoriteMeals() {
        return mealDao.getFavoriteMeals();
    }

    @Override
    public LiveData<List<Meal>> getPlannedMeals() {
        return mealDao.getPlannedMeals();
    }

    @Override
    public LiveData<List<Meal>> getPlannedMealsForNextWeek() {
        Calendar now = Calendar.getInstance();
        Date startDate = now.getTime();

        Calendar nextWeek = Calendar.getInstance();
        nextWeek.add(Calendar.DAY_OF_YEAR, 7);
        Date endDate = nextWeek.getTime();

        return mealDao.getPlannedMealsForNextWeek(startDate, endDate);
    }

    @Override
    public void insertMeal(Meal meal) {
        new Thread(() -> mealDao.insertMeal(meal)).start();
    }

    @Override
    public void updateMeal(Meal meal) {
        if (meal.isPlanned() && isPlannedDateValid(meal.getPlannedDate())) {
            new Thread(() -> mealDao.updateMeal(meal)).start();
        } else {
            throw new IllegalArgumentException("Planned date must be within the next week.");
        }
    }

    @Override
    public void deleteMeal(Meal meal) {
        new Thread(() -> mealDao.deleteMeal(meal)).start();
    }

    @Override
    public LiveData<Meal> getMealById(int mealId) {
        return mealDao.getMealById(mealId);
    }
}
