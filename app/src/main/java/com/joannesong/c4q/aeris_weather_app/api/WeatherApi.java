package com.joannesong.c4q.aeris_weather_app.api;

import android.support.annotation.NonNull;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApi {
    private static final String AERIS_BASE_URL = "https://api.aerisapi.com/";

    private Retrofit retrofit;

    public WeatherApi() {
        retrofit = new Retrofit.Builder()
                .baseUrl(AERIS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    @NonNull
    public WeatherService provideRetrofit() {
        return retrofit.create(WeatherService.class);
    }
}
