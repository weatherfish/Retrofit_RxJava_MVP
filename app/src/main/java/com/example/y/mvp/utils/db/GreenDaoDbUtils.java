package com.example.y.mvp.utils.db;

import com.example.y.mvp.ImageDetailInfoDao;
import com.example.y.mvp.ImageListInfoDao;
import com.example.y.mvp.ImageTabNameInfoDao;
import com.example.y.mvp.JokePicInfoDao;
import com.example.y.mvp.JokeTextInfoDao;
import com.example.y.mvp.NewsDetailInfoDao;
import com.example.y.mvp.NewsListInfoDao;
import com.example.y.mvp.NewsTabNameInfo;
import com.example.y.mvp.NewsTabNameInfoDao;
import com.example.y.mvp.data.Constant;

/**
 * by y on 2016/7/11.
 */
public class GreenDaoDbUtils {


    public static void addNewsTabName(int id, String name) {
        if (searchNewsTabName(id)) {
            getNewsTabNameDb().insert(new NewsTabNameInfo(id, name));
        }
    }

    public static void deleteSql(String sqlName) {
        switch (sqlName) {
            case Constant.NEWS_TAB_NAME_INFO:
                getNewsTabNameDb().deleteAll();
                break;
            case Constant.NEWS_LIST_INFO:
                getNewsListInfoDb().deleteAll();
                break;
            case Constant.NEWS_DETAIL_INFO:
                getNewsDetailDb().deleteAll();
                break;
            case Constant.IMAGE_TAB_NAME_INFO:
                getImageTabNameDb().deleteAll();
                break;
            case Constant.IMAGE_LIST_INFO:
                getImageListInfoDb().deleteAll();
                break;
            case Constant.IMAGE_DETAIL_INFO:
                getImageDetailDb().deleteAll();
                break;
            case Constant.JOKE_PIC_INFO:
                getJokePicDb().deleteAll();
                break;
            case Constant.JOKE_TEXT_INFO:
                getJokeTextDb().deleteAll();
                break;
        }
    }

    public static boolean searchNewsTabName(int id) {
        return getNewsTabNameDb().queryBuilder().where(NewsTabNameInfoDao.Properties.Id.eq(id)).unique() == null;
    }


    public static void clearAll() {
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
