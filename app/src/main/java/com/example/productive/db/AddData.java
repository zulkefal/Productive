package com.example.productive.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities={User.class},version = 1)

public abstract class AddData extends RoomDatabase {

    public abstract UserDao userDao();
    public static AddData INSTANCE;

    public static AddData getDbInstance(Context context) {
        if (INSTANCE==null)
        {
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(),AddData.class,"Db name").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

}