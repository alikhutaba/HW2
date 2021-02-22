package com.example.common;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TLogDao {

    @Insert
    void insertAll(TLog... tLogs);

    @Query("SELECT * FROM time_logs")
    List<TLog> getAll();



}