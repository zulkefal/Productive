package com.example.productive.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity // (tableName = "usertasks")
public class User {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name="e_time")
    public String time;

    @ColumnInfo(name="e_task")
    public String task;

    @ColumnInfo(name="e_descp")
    public String descp;


}
