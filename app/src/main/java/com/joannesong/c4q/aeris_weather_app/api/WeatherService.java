package com.joannesong.c4q.aeris_weather_app.api;

import com.joannesong.c4q.aeris_weather_app.model.AerisResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherService {

    @GET("forecasts/{zip}")
    Call<AerisResponse> getForecast(
            @Path("zip") String zip, @Query("client_id") String clientId, @Query("client_secret") String clientSecret);
}
