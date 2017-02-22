package com.example.lenovo.coolweather.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollete.AddActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollete.removeActivity(this);
    }
}
