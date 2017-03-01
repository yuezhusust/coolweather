package com.example.lenovo.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 项目名称：CoolWeather
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/2/27 15:31
 * 修改人：lenovo
 * 修改时间：2017/2/27 15:31
 * 修改备注：
 */

public class Forecast {
    public String date;
    @SerializedName("tmp")
    public Temperature temperature;
    @SerializedName("cond")
    public More more;

    public class Temperature {
        public String max;
        public String min;
    }

    public class More {
        @SerializedName("txt_d")
        public String info;
    }
}
