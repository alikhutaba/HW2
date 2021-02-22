package com.example.common;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GarageController {


    private String baseUrl;
    private CallBack_Garage callBack_garage;


    Callback<Garage> garageCallBack  = new Callback<Garage>() {
        @Override
        public void onResponse(Call<Garage> call, Response<Garage> response) {
            if (response.isSuccessful()) {
                Garage garage = response.body();
                if (callBack_garage != null) {
                    callBack_garage.garage(garage);
//                    Log.d("pttt", garage.toString());

                }
            } else {
                System.out.println(response.errorBody());
                Log.d("pttt", response.errorBody().toString());

            }
        }

        @Override
        public void onFailure(Call<Garage> call, Throwable t) {
            t.printStackTrace();
            Log.d("pttt", t.getMessage());

        }
    };



    public GarageController(String baseUrl) {
        setBaseUrl(baseUrl);
    }


    private void setBaseUrl(String baseUrl) {
        if(baseUrl == null || baseUrl.isEmpty())
            throw new RuntimeException("unvalid base url");
        this.baseUrl = baseUrl;
    }



    public void getGarage(CallBack_Garage callBack_garage) {
        this.callBack_garage = callBack_garage;
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        APIFactory apiFactory = retrofit.create(APIFactory.class);

        Call<Garage> call = apiFactory.getGarage();
        call.enqueue(garageCallBack);
    }




    public interface CallBack_Garage {
        void garage(Garage garage);
    }
}
