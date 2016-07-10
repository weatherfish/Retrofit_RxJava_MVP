package com.example.y.mvp.utils.db;

import android.database.sqlite.SQLiteDatabase;

import com.example.y.mvp.DaoMaster;
import com.example.y.mvp.DaoSession;
import com.example.y.mvp.ImageDetailInfoDao;
import com.example.y.mvp.ImageListInfoDao;
import com.example.y.mvp.ImageTabNameInfoDao;
import com.example.y.mvp.JokePicInfoDao;
import com.example.y.mvp.JokeTextInfoDao;
import com.example.y.mvp.NewsDetailInfoDao;
import com.example.y.mvp.NewsListInfoDao;
import com.example.y.mvp.NewsTabNameInfoDao;
import com.example.y.mvp.utils.UIUtils;

/**
 * by y on 2016/7/8.
 */
public class GreenDaoUtils {

    private static DaoMaster.DevOpenHelper devOpenHelper;
    private static SQLiteDatabase sqLiteDatabase;
    private static DaoMaster daoMaster;

    private static final String SQL_NAME = "simple";

    private static class SessionHolder {
        public static final DaoSession daoSession = getDaoMaster().newSession();
    }

    public static DaoSession getInstance() {
        return SessionHolder.daoSession;
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
            devOpenHelper = new DaoMaster.DevOpenHelper(UIUtils.getContext(), SQL_NAME, null);
        }
        return devOpenHelper;
    }

    public static void clearSql() {
        getNewsTabNameDb().deleteAll();
        getNewsListInfoDb().deleteAll();
        getNewsDetailDb().deleteAll();
        getImageTabNameDb().deleteAll();
        getImageListInfoDb().deleteAll();
        getImageDetailDb().deleteAll();
        getJokePicDb().deleteAll();
        getJokeTextDb().deleteAll();
    }


    public static NewsTabNameInfoDao getNewsTabNameDb() {
        return GreenDaoUtils.getInstance().getNewsTabNameInfoDao();
    }

    public static NewsListInfoDao getNewsListInfoDb() {
        return GreenDaoUtils.getInstance().getNewsListInfoDao();
    }


    public static NewsDetailInfoDao getNewsDetailDb() {
        return GreenDaoUtils.getInstance().getNewsDetailInfoDao();
    }

    public static ImageTabNameInfoDao getImageTabNameDb() {
        return GreenDaoUtils.getInstance().getImageTabNameInfoDao();
    }

    public static ImageListInfoDao getImageListInfoDb() {
        return GreenDaoUtils.getInstance().getImageListInfoDao();
    }

    public static ImageDetailInfoDao getImageDetailDb() {
        return GreenDaoUtils.getInstance().getImageDetailInfoDao();
    }

    public static JokePicInfoDao getJokePicDb() {
        return GreenDaoUtils.getInstance().getJokePicInfoDao();
    }

    public static JokeTextInfoDao getJokeTextDb() {
        return GreenDaoUtils.getInstance().getJokeTextInfoDao();
    }
}
