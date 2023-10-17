package com.examples.apps.langus;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

public class MainApplication extends Application {

    public static AppLangManager applangmng;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context ctx) {
        applangmng = new AppLangManager(ctx);
        super.attachBaseContext(applangmng.setLocale(ctx));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        applangmng.setLocale(this);
    }


}