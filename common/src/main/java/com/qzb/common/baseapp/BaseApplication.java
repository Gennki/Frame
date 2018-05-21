package com.qzb.common.baseapp;

import android.content.Context;
import android.content.res.Resources;
import android.support.multidex.MultiDexApplication;

/**
 * Created by QinZB on 2017/9/3.
 */

public class BaseApplication extends MultiDexApplication {
    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();

        baseApplication = this;
    }

    public static Context getAppContext() {
        return baseApplication;
    }

    public static Resources getAppResources() {
        return baseApplication.getResources();
    }
}
