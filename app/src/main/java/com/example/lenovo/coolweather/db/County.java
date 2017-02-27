package com.example.lenovo.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * 项目名称：CoolWeather
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/2/22 10:23
 * 修改人：lenovo
 * 修改时间：2017/2/22 10:23
 * 修改备注：
 */

public class County extends DataSupport {
    private int id;
    private String countyName;
    private String weatherId ;
    private int cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
