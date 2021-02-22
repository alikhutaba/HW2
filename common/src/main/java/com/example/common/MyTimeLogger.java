package com.example.common;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MyTimeLogger {

    private  AppDatabase appDatabase;

    public MyTimeLogger(Context context, String dataBaseName) {
        appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, dataBaseName)
                // allow queries on the main thread.
                // Don't do this on a real app! See PersistenceBasicSample for an example.
                // .allowMainThreadQueries()
                .build();
    }


    public interface CallBack_Logs {
        void dataReady(List<TLog> tLogs);
    }

    public interface CallBack_Time {
        void dataReady(long time);
    }



    public void getAllDurations(CallBack_Time callBack_time) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<TLog> tLogs = appDatabase.tLogDao().getAll();
                long sum = 0;
                for (TLog tLog : tLogs) {
                    sum += tLog.duration;
//                    Log.e("pttt", "COMMON :: getAllDurations :: duration = "+tLog.duration);

                }

                if (callBack_time != null) {
                    callBack_time.dataReady(sum);
                }
            }
        }).start();
    }

    public void addTlogTime(long durationSec) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                appDatabase.tLogDao().insertAll(new TLog(System.currentTimeMillis(), durationSec));
            }
        }).start();
    }


    public void getAllLogs(CallBack_Logs callBack_logs) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<TLog> tLogs = appDatabase.tLogDao().getAll();
                if (callBack_logs != null) {
                    callBack_logs.dataReady(tLogs);
                }
            }
        }).start();
    }
}