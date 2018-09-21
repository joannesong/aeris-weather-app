package com.joannesong.c4q.aeris_weather_app.rv;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joannesong.c4q.aeris_weather_app.R;
import com.joannesong.c4q.aeris_weather_app.model.Periods;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherViewHolder> {
    private List<Periods> forecastList;

    public WeatherAdapter(List<Periods> forecastList) {
        this.forecastList = forecastList;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.weather_itemview, viewGroup, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int i) {
        holder.bind(forecastList.get(i), i);
    }

    @Override
    public int getItemCount() {
        return forecastList.size();
    }
}
