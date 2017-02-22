package com.example.lenovo.coolweather.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 项目名称：CoolWeather
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/2/22 13:57
 * 修改人：lenovo
 * 修改时间：2017/2/22 13:57
 * 修改备注：
 */

public class HttpUtil {
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
