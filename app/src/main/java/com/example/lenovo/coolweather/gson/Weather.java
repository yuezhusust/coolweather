package com.example.lenovo.coolweather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 项目名称：CoolWeather
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/2/27 15:48
 * 修改人：lenovo
 * 修改时间：2017/2/27 15:48
 * 修改备注：
 */

public class Weather {
    public String status;
    public Basic basic;
    public AQI aqi;
    public Now now;
    public Suggestion suggestion;
    @SerializedName("daily_forecast")
    public List<Forecast>forecastList;
}
