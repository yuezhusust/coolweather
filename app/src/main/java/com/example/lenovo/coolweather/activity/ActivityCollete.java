package com.example.lenovo.coolweather.activity;

import android.app.Activity;
import android.support.v7.app.ActionBar;

import java.util.List;

/**
 * 项目名称：CoolWeather
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/2/21 18:12
 * 修改人：lenovo
 * 修改时间：2017/2/21 18:12
 * 修改备注：
 */

public class ActivityCollete {
    private static  List <Activity> activityList = null;
    public static void AddActivity(Activity activity){
        activityList.add(activity);
    }
    public static void removeActivity(Activity activity){
        activityList.remove(activity);
    }
    public static void finishAllActivity(){
        for (Activity activity:activityList){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }

}
