package com.example.y.mvp.utils.db;

import android.database.sqlite.SQLiteDatabase;

import com.example.y.mvp.DaoMaster;
import com.example.y.mvp.DaoSession;
import com.example.y.mvp.utils.UIUtils;

/**
 * by y on 2016/7/8.
 */
public class GreenDaoUtils {

    private static DaoMaster.DevOpenHelper devOpenHelper;
    private static SQLiteDatabase sqLiteDatabase;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;

    public static DaoSession getSession() {
        if (daoSession == null) {
            daoSession = getDaoMaster().newSession();
        }
        return daoSession;
    }

    public static DaoMaster getDaoMaster() {
        if (daoMaster == null) {
            daoMaster = new DaoMaster(getSQLiteDatabase());
        }
        return daoMaster;
    }

    public static SQLiteDatabase getSQLiteDatabase() {
        if (sqLiteDatabase == null) {
            sqLiteDatabase = getDevOpenHelper().getWritableDatabase();
        }
        return sqLiteDatabase;
    }

    public static DaoMaster.DevOpenHelper getDevOpenHelper() {
        if (devOpenHelper == null) {
            devOpenHelper = new DaoMaster.DevOpenHelper(UIUtils.getContext(), "greendao", null);
        }
        return devOpenHelper;
    }
}
