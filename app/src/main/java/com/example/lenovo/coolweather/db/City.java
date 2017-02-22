package com.example.lenovo.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * 项目名称：CoolWeather
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/2/22 10:15
 * 修改人：lenovo
 * 修改时间：2017/2/22 10:15
 * 修改备注：
 */

public class City extends DataSupport {
    private int id;
    private String cityName;
    private int cityCode;
    private int provinceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}

