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

    public static final String SQL_NAME = "simple";

    private static class SessionHolder {
        public static final DaoSession daoSession = getDaoMaster().newSession();
    }

    @SuppressWarnings("SameReturnValue")
    public static DaoSession getInstance() {
        return SessionHolder.daoSession;
    }

    private static DaoMaster getDaoMaster() {
        if (daoMaster == null) {
            daoMaster = new DaoMaster(getSQLiteDatabase());
        }
        return daoMaster;
    }

    private static SQLiteDatabase getSQLiteDatabase() {
        if (sqLiteDatabase == null) {
            sqLiteDatabase = getDevOpenHelper().getWritableDatabase();
        }
        return sqLiteDatabase;
    }

    private static DaoMaster.DevOpenHelper getDevOpenHelper() {
        if (devOpenHelper == null) {
            devOpenHelper = new DaoMaster.DevOpenHelper(UIUtils.getContext());
        }
        return devOpenHelper;
    }

}
