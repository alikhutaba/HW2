package com.example.common;


import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main_Activity_Parent extends AppCompatActivity {


    private TextView main_LBL_time;
    private TextView main_LBL_GarageName;
    private TextView main_LBL_GarageAddress;
    private TextView main_LBL_GarageOpen;
    private ListView main_LBL_CarsList;

    private static String baseUrl = "https://pastebin.com/raw/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_parent);

        main_LBL_time = findViewById(R.id.main_LBL_time);
        main_LBL_GarageName = findViewById(R.id.main_LBL_GarageName);
        main_LBL_GarageAddress = findViewById(R.id.main_LBL_GarageAddress);
        main_LBL_GarageOpen = findViewById(R.id.main_LBL_GarageOpen);
        main_LBL_CarsList = findViewById(R.id.main_LBL_CarsList);


        downloadGarage();


    }


    private void downloadGarage() {

        new GarageController(baseUrl).getGarage(new GarageController.CallBack_Garage() {
            @Override
            public void garage(Garage garage) {
                Log.d("pttt", garage.toString());
                showGarage(garage);

            }
        });
    }


    private void showGarage(Garage garage){

        main_LBL_GarageName.setText(garage.getName());
        main_LBL_GarageAddress.setText(garage.getAddress());
        main_LBL_GarageOpen.setText(garage.isOpen()? "true":"false");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                garage.getCars() );

        main_LBL_CarsList.setAdapter(arrayAdapter);


    }

    public void setTime(String time) {
        main_LBL_time.setText(time);
    }
}
