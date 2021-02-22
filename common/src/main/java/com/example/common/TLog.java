package com.example.common;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "time_logs")
public class TLog {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "time")
    public long time = 0;

    @ColumnInfo(name = "duration")
    public long duration = 0;

    public TLog() { }

    public TLog(long time, long duration) {
        this.time = time;
        this.duration = duration;
    }
}