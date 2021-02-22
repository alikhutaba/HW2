package com.example.customers;

import android.os.Bundle;
import android.util.Log;

import com.example.common.Main_Activity_Parent;
import com.example.common.MyTimeLogger;
import com.example.common.TLog;

import java.util.List;

public class CustomerMainActivity extends Main_Activity_Parent {

    private long startTimeStamp = 0;
    private MyTimeLogger myTimeLogger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myTimeLogger = new MyTimeLogger(getApplicationContext(), "customer.db");


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



    private void showTime(){
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