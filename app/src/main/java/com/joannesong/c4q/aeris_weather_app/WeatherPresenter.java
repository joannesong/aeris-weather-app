package com.joannesong.c4q.aeris_weather_app;

import com.joannesong.c4q.aeris_weather_app.api.WeatherApi;
import com.joannesong.c4q.aeris_weather_app.model.AerisResponse;
import com.joannesong.c4q.aeris_weather_app.model.Periods;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherPresenter implements WeatherContract.Presenter{
    private static final String CLIENT_ID = "0EMckxNMO2tSwXraAAcId";
    private static final String CLIENT_SECRET = "Iiar9h4wBoiQkLdEhkPJAHBdv3BZnJMwgdmUpmKL";
    private String zipCode;
    private List<Periods> forecastList = new ArrayList<>();
    private WeatherContract.View view;

    public WeatherPresenter(WeatherContract.View view, String zipCode) {
        this.view = view;
        this.zipCode = zipCode;


    }

    @Override
    public void setNetworkCall() {
        WeatherApi retrofit = new WeatherApi();
        Call<AerisResponse> call = retrofit.provideRetrofit().getForecast(zipCode, CLIENT_ID, CLIENT_SECRET);
        call.enqueue(new Callback<AerisResponse>() {
            @Override
            public void onResponse(Call<AerisResponse> call, Response<AerisResponse> response) {
                for(int i = 0; i<7; i++){
                    forecastList.add(response.body().getResponse().get(0).getPeriods().get(i));
                }
                view.showWeatherList();
            }

            @Override
            public void onFailure(Call<AerisResponse> call, Throwable t) {

            }
        });

    }

    @Override
    public List<Periods> getWeatherList() {
        return forecastList;

    }

}
