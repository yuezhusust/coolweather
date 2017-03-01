package com.example.lenovo.coolweather.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.coolweather.R;
import com.example.lenovo.coolweather.gson.Forecast;
import com.example.lenovo.coolweather.gson.Weather;
import com.example.lenovo.coolweather.utils.HttpUtil;
import com.example.lenovo.coolweather.utils.LogUtil;
import com.example.lenovo.coolweather.utils.Utility;

import org.w3c.dom.Text;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends BaseActivity {
    private ScrollView weatherLayout;
    private TextView cityText;
    private TextView timeText;
    private TextView tmpText;
    private TextView infoText;
    private LinearLayout forecastLayout;
    private TextView aqiText;
    private TextView pmText;
    private TextView comfortText;
    private TextView washText;
    private TextView sportText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        weatherLayout = (ScrollView) findViewById(R.id.weather_layout);
        cityText = (TextView) findViewById(R.id.city_text);
        timeText = (TextView) findViewById(R.id.time_text);
        tmpText = (TextView) findViewById(R.id.temp_text);
        infoText = (TextView) findViewById(R.id.info_text);
        forecastLayout = (LinearLayout) findViewById(R.id.forecast_layout);
        aqiText = (TextView) findViewById(R.id.aqi_text);
        pmText = (TextView) findViewById(R.id.pm_text);
        comfortText = (TextView) findViewById(R.id.comfort_text);
        washText = (TextView) findViewById(R.id.wash_text);
        sportText = (TextView) findViewById(R.id.sport_text);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String weatherInfo = sharedPreferences.getString("weather",null);
        if (weatherInfo !=null){
            Weather weather = Utility.handleWeatherResponse(weatherInfo);
            showWeatherInfo(weather);

        }else {
            weatherLayout.setVisibility(View.INVISIBLE);
            Intent intent = getIntent();
            String weatherId = intent.getStringExtra("weather_id");
            requestWeatherInfo(weatherId);
        }

    }

    private void requestWeatherInfo(String weatherId) {
        String weatherUrl = "http://guolin.tech/api/weather?cityid="+weatherId+"&key=bc0418b57b2d4918819d3974ac1285d9";
        LogUtil.d("the weatherUrl is="+weatherUrl);
        HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(WeatherActivity.this, "获取天气信息失败", Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();
                final Weather weather = Utility.handleWeatherResponse(responseText);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (weather != null && "ok".equals(weather.status)){
                            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("weather",responseText);
                            editor.commit();
                            showWeatherInfo(weather);
                        }else {
                            Toast.makeText(WeatherActivity.this, "获取天气信息失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }

    private void showWeatherInfo(Weather weatherInfo) {
        String cityName = weatherInfo.basic.cityName;
        String updateTime = weatherInfo.basic.update.updateName.split(" ")[1];
        String degree = weatherInfo.now.temperature+"℃";
        String info = weatherInfo.now.more.info;
        cityText.setText(cityName);
        timeText.setText(updateTime);
        tmpText.setText(degree);
        infoText.setText(info);
        forecastLayout.removeAllViews();
        for(Forecast forecast:weatherInfo.forecastList){
            View view = LayoutInflater.from(this).inflate(R.layout.forecast_item,forecastLayout,false);
            TextView dateText = (TextView) view.findViewById(R.id.date_text);
            TextView descText = (TextView) view.findViewById(R.id.desc_text);
            TextView minText = (TextView) view.findViewById(R.id.min_text);
            TextView maxText = (TextView) view.findViewById(R.id.max_text);
            dateText.setText(forecast.date);
            descText.setText(forecast.more.info);
            minText.setText(forecast.temperature.min);
            maxText.setText(forecast.temperature.max);
            forecastLayout.addView(view);
        }
        if (weatherInfo.aqi != null){
            aqiText.setText(weatherInfo.aqi.city.aqi);
            pmText.setText(weatherInfo.aqi.city.pm25);
        }
        String comfort ="舒适度："+weatherInfo.suggestion.comfort.info;
        String wash ="洗车指数："+weatherInfo.suggestion.carWash.info;
        String sport = "运动建议："+weatherInfo.suggestion.sport.info;
        comfortText.setText(comfort);
        washText.setText(wash);
        sportText.setText(sport);
        weatherLayout.setVisibility(View.VISIBLE);

    }
}
