package com.example.y.mvp.utils.theme;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/**
 * SharedPreferences管理类
 */
@SuppressWarnings("ALL")
public class SharedPreferencesMgr {

    private static SharedPreferences sharedPreferences;
    private static final String THEME = "theme";

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private static void initSharePreferences(Context context) {
        sharedPreferences = context.getSharedPreferences("derson", Context.MODE_ENABLE_WRITE_AHEAD_LOGGING);
    }

    public static void init(Context context) {
        initSharePreferences(context);
    }

    public static String fileName;

    public static int getInt() {
        return sharedPreferences.getInt(THEME, 0);
    }

    public static void setInt(int value) {
        sharedPreferences.edit().putInt(THEME, value).apply();
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public static void setBoolean(String key, boolean value) {
        sharedPreferences.edit().putBoolean(key, value).apply();
    }

    public static String getString(String key, String defaultValue) {
        if (sharedPreferences == null) {
            return defaultValue;
        }
        return sharedPreferences.getString(key, defaultValue);
    }

    public static void setString(String key, String value) {
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putString(key, value).apply();
    }

    public static void clearAll() {
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().clear().apply();
    }

}
