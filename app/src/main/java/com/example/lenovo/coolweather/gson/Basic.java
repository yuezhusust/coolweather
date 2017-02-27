package com.example.lenovo.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 项目名称：CoolWeather
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/2/27 14:14
 * 修改人：lenovo
 * 修改时间：2017/2/27 14:14
 * 修改备注：
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;
    public Update update;

    public class Update {
        @SerializedName("loc")
        public String updateName;
    }
}
