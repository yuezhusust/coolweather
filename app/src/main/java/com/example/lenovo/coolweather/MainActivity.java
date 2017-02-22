package com.example.lenovo.coolweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lenovo.coolweather.activity.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
