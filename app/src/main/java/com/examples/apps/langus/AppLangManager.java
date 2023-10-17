package com.examples.apps.langus;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import java.util.Locale;

public class AppLangManager {
    private SharedPreferences prefsmang;

    public AppLangManager(Context con) {
        prefsmang = PreferenceManager.getDefaultSharedPreferences(con);
    }

    public String getLanguage() {
        return prefsmang.getString("langkey", "en");
    }


    public Context setLocale(Context ctx) {
        Locale locale = new Locale(getLanguage());
        Locale.setDefault(locale);
        Resources res = ctx.getResources();
        Configuration config = new Configuration(res.getConfiguration());
        config.locale = locale;
        res.updateConfiguration(config, res.getDisplayMetrics());
        return ctx;
    }

    public Context setNewLocale(Context conn, String language) {

        prefsmang.edit().putString("langkey", language).commit();

        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Resources res = conn.getResources();
        Configuration config = new Configuration(res.getConfiguration());
        config.locale = locale;
        res.updateConfiguration(config, res.getDisplayMetrics());
        return conn;
    }

}