package com.example.lenovo.coolweather.gson;

/**
 * 项目名称：CoolWeather
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/2/27 14:33
 * 修改人：lenovo
 * 修改时间：2017/2/27 14:33
 * 修改备注：
 */

public class AQI {
    public AQICity city;

    public class AQICity {
        public String aqi;
        public String pm25;
    }
}
