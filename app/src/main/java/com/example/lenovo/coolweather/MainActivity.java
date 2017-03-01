package com.example.lenovo.coolweather;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lenovo.coolweather.activity.BaseActivity;
import com.example.lenovo.coolweather.activity.WeatherActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String weatherInfo = sharedPreferences.getString("weather",null);
        if (weatherInfo != null){
            Intent intent = new Intent(this, WeatherActivity.class);
            startActivity(intent);
            this.finish();
        }
    }
}
