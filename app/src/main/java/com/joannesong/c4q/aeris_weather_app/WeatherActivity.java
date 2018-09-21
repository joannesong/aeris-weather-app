package com.joannesong.c4q.aeris_weather_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.joannesong.c4q.aeris_weather_app.rv.WeatherAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WeatherActivity extends AppCompatActivity implements WeatherContract.View {
    @BindView(R.id.recycler)
    RecyclerView weatherRV;
    @BindView(R.id.zip_edit_text)
    EditText zipcodeET;
    @BindView(R.id.zip_button)
    ImageButton zipButton;
    private WeatherPresenter presenter;
    private String zipCode;
    private WeatherAdapter weatherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        zipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zipCode = zipcodeET.getText().toString();
                startNetworkCall();
            }
        });
        showRV();
    }

    private void startNetworkCall() {
        presenter = new WeatherPresenter(this, zipCode);
        presenter.setNetworkCall();
    }

    private void showRV() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 3);
        weatherRV.setLayoutManager(gridLayoutManager);
    }


    @Override
    public void showWeatherList() {
        weatherAdapter = new WeatherAdapter(presenter.getWeatherList());
        weatherRV.setAdapter(weatherAdapter);
    }
}
