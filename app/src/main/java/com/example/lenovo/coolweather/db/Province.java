package com.example.lenovo.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * 项目名称：CoolWeather
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/2/21 18:11
 * 修改人：lenovo
 * 修改时间：2017/2/21 18:11
 * 修改备注：
 */

public class Province extends DataSupport {
    private int id;
    private String provinceName;
    private int provinceCode;

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
}
