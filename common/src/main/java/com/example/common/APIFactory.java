package com.example.common;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIFactory{

    @GET("WypPzJCt")
    Call<Garage> getGarage();
}