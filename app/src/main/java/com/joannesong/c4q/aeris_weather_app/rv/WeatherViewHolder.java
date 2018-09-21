package com.joannesong.c4q.aeris_weather_app.rv;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.joannesong.c4q.aeris_weather_app.R;
import com.joannesong.c4q.aeris_weather_app.model.Periods;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.forecast_image)
    ImageView forecastImage;
    @BindView(R.id.max_temp)
    TextView maxTemp;
    @BindView(R.id.min_temp)
    TextView minTemp;

    private Date parsedDate;
    private String fdate;
    private String[] dateArr;

    public WeatherViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }

    public void bind(Periods periods, int i) {

        String min = "High: " + periods.getMinTempC() + "\u00B0 C";
        String max = "Low: " + periods.getMaxTempC() + "\u00B0 C";

        parseDate(periods);

        date.setText(fdate);
        maxTemp.setText(max);
        minTemp.setText(min);

        Picasso.get().load(R.drawable.am_pcloudy).
                fit().
                centerCrop().
                placeholder(R.drawable.ic_image_black_24dp).
                error(R.drawable.ic_error).
                into(forecastImage);
    }

    private void parseDate(Periods periods) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        try {
            parsedDate = dateFormat.parse(periods.getValidTime());
            dateArr = parsedDate.toString().split(" ");

            fdate= dateArr[0] + "\n" + dateArr[1] + " " + dateArr[2];

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


}
