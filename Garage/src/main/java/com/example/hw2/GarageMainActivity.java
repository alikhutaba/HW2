package com.example.hw2;

import android.os.Bundle;

import com.example.common.Main_Activity_Parent;
import com.example.common.MyTimeLogger;

public class GarageMainActivity extends Main_Activity_Parent {

    private long startTimeStamp = 0;
    private MyTimeLogger myTimeLogger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myTimeLogger = new MyTimeLogger(getApplicationContext(), "garage.db");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showTime();
        startTimeStamp = System.currentTimeMillis();
    }

    @Override
    protected void onStop() {
        super.onStop();
        long duration = System.currentTimeMillis() - startTimeStamp;
        myTimeLogger.addTlogTime(duration);
    }


    private void showTime() {
        myTimeLogger.getAllDurations(new MyTimeLogger.CallBack_Time() {
            @Override
            public void dataReady(long time) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setTime(time + "");

                    }
                });
            }
        });
    }

}