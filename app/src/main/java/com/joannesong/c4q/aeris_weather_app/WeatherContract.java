package com.joannesong.c4q.aeris_weather_app;

import com.joannesong.c4q.aeris_weather_app.model.Periods;

import java.util.List;

public interface WeatherContract {
    interface Presenter{
        void setNetworkCall();
        List<Periods> getWeatherList();
    }

    interface View{
        void showWeatherList();

    }

}
