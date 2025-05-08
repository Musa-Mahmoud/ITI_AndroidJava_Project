package com.iti.oishi.model.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.iti.oishi.room.dao.MealDao;

@Database(entities = {Meal.class}, version = 1)
@TypeConverters({DateConverter.class})
public abstract class MealDb extends RoomDatabase {

    private static MealDb instance;

    public abstract MealDao getMealDao();

    public static synchronized MealDb getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),MealDb.class, "meal_db")
                        .build();
        }
        return instance;
    }
}
