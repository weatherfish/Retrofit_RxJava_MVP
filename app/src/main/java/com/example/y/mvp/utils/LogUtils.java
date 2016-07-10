package com.example.y.mvp.utils;

import android.util.Log;

/**
 * by 12406 on 2016/4/28.
 */
@SuppressWarnings("ALL")
public class LogUtils {


    private static final boolean DEBUG = true;

    private static final String TAG = "Log_Utils-->:";

    public static void v(Object message) {
        if (DEBUG) {
            Log.v(TAG, message + "");
        }
    }

    public static void v(String tag, Object message) {
        if (DEBUG) {
            Log.v(tag, message + "");
        }
    }

    public static void d(Object message) {
        if (DEBUG) {
            Log.d(TAG, message + "");
        }
    }

    public static void d(String tag, Object message) {
        if (DEBUG) {
            Log.d(tag, message + "");
        }
    }

    public static void i(Object message) {
        if (DEBUG) {
            Log.i(TAG, message + "");
        }
    }

    public static void i(String tag, Object message) {
        if (DEBUG) {
            Log.i(tag, message + "");
        }
    }

    public static void w(Object message) {
        if (DEBUG) {
            Log.w(TAG, message + "");
        }
    }

    public static void w(String tag, Object message) {
        if (DEBUG) {
            Log.w(tag, message + "");
        }
    }

    public static void e(Object message) {
        if (DEBUG) {
            Log.e(TAG, message + "");
        }
    }

    public static void e(String tag, Object message) {
        if (DEBUG) {
            Log.e(tag, message + "");
        }
    }

}
