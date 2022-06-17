package com.example.productive.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("Select * from User")
    List<User> getAllUsers();

    @Insert
    void insertUser(User... users);

    @Delete
    void insertUser(User user);

}
