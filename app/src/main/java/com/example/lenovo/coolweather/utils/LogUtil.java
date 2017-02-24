package com.example.lenovo.coolweather.utils;

import android.util.Log;

/**
 * 项目名称：CoolWeather
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/2/21 18:07
 * 修改人：lenovo
 * 修改时间：2017/2/21 18:07
 * 修改备注：
 */

public class LogUtil {
    private static final int LEVEL_VER = 0;
    private static final int LEVEL_DEBUG = 1;
    private static final int LEVEL_INFO = 2;
    private static final int LEVEL_WARN = 3;
    private static final int LEVEL_ERROR = 4;
    private static final int LEVEL_NOTHING = 5;
    private static int currentLevel = LEVEL_VER;
    private static final String TAG = "LogUtil";

    public static void v(String msg){
        if (currentLevel <= LEVEL_VER){
            Log.v(TAG,msg);
        }
    }
    public static void d(String msg){
        if (currentLevel <= LEVEL_DEBUG) {
            Log.d(TAG, msg);
        }
    }
    public static void i(String msg){
        if (currentLevel <= LEVEL_INFO){
            Log.i(TAG, msg);
        }
    }
    public static void w(String msg){
        if (currentLevel <= LEVEL_WARN){
            Log.w(TAG, msg );
        }
    }
    public static void e(String msg){
        if (currentLevel <= LEVEL_ERROR){
            Log.e(TAG, msg );
        }
    }


}
