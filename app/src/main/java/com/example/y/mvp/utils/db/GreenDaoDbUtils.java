package com.example.y.mvp.utils.db;

import com.example.y.mvp.ImageDetailInfo;
import com.example.y.mvp.ImageDetailInfoDao;
import com.example.y.mvp.ImageListInfo;
import com.example.y.mvp.ImageListInfoDao;
import com.example.y.mvp.ImageTabNameInfo;
import com.example.y.mvp.ImageTabNameInfoDao;
import com.example.y.mvp.JokePicInfo;
import com.example.y.mvp.JokePicInfoDao;
import com.example.y.mvp.JokeTextInfo;
import com.example.y.mvp.JokeTextInfoDao;
import com.example.y.mvp.NewsDetailInfo;
import com.example.y.mvp.NewsDetailInfoDao;
import com.example.y.mvp.NewsListInfo;
import com.example.y.mvp.NewsListInfoDao;
import com.example.y.mvp.NewsTabNameInfo;
import com.example.y.mvp.NewsTabNameInfoDao;
import com.example.y.mvp.data.Constant;

import java.util.List;

/**
 * by y on 2016/7/11.
 */
public class GreenDaoDbUtils {


    public static class GreenDaoDBHolder {
        public static final GreenDaoDbUtils greenDaoDbUtils = new GreenDaoDbUtils();
    }

    public static GreenDaoDbUtils getInstance() {
        return GreenDaoDBHolder.greenDaoDbUtils;
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

    public static void deleteSql(String sqlName, int id) {
        switch (sqlName) {
            case Constant.NEWS_TAB_NAME_INFO:
                getNewsTabNameDb().deleteByKey(id);
                break;
            case Constant.NEWS_LIST_INFO:
                getNewsListInfoDb().deleteByKey(id);
                break;
            case Constant.NEWS_DETAIL_INFO:
                getNewsDetailDb().deleteByKey(id);
                break;
            case Constant.IMAGE_TAB_NAME_INFO:
                getImageTabNameDb().deleteByKey(id);
                break;
            case Constant.IMAGE_LIST_INFO:
                getImageListInfoDb().deleteByKey(id);
                break;
            case Constant.IMAGE_DETAIL_INFO:
                getImageDetailDb().deleteByKey(id);
                break;
        }
    }

    public static boolean isEmpty(String sqlName, int id) {
        switch (sqlName) {
            case Constant.NEWS_TAB_NAME_INFO:
                return getNewsTabNameDb().queryBuilder().where(NewsTabNameInfoDao.Properties.Id.eq(id)).unique() == null;
            case Constant.NEWS_LIST_INFO:
                return getNewsListInfoDb().queryBuilder().where(NewsListInfoDao.Properties.Id.eq(id)).unique() == null;
            case Constant.NEWS_DETAIL_INFO:
                return getNewsDetailDb().queryBuilder().where(NewsDetailInfoDao.Properties.Id.eq(id)).unique() == null;
            case Constant.IMAGE_TAB_NAME_INFO:
                return getImageTabNameDb().queryBuilder().where(ImageTabNameInfoDao.Properties.Id.eq(id)).unique() == null;
            case Constant.IMAGE_LIST_INFO:
                return getImageListInfoDb().queryBuilder().where(ImageListInfoDao.Properties.Id.eq(id)).unique() == null;
            case Constant.IMAGE_DETAIL_INFO:
                return getImageDetailDb().queryBuilder().where(ImageDetailInfoDao.Properties.Id.eq(id)).unique() == null;
        }
        return false;
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


    public static List<NewsTabNameInfo> getNewsTabName() {
        return getNewsTabNameDb().loadAll();
    }

    public static List<NewsListInfo> getNewsList() {
        return getNewsListInfoDb().loadAll();
    }

    public static List<NewsDetailInfo> getNewsDetail() {
        return getNewsDetailDb().loadAll();
    }

    public static List<ImageTabNameInfo> getImageTabName() {
        return getImageTabNameDb().loadAll();
    }

    public static List<ImageListInfo> getImageList() {
        return getImageListInfoDb().loadAll();
    }

    public static List<ImageDetailInfo> getImageDetail() {
        return getImageDetailDb().loadAll();
    }

    public static List<JokePicInfo> getJokePic() {
        return getJokePicDb().loadAll();
    }

    public static List<JokeTextInfo> getJokeText() {
        return getJokeTextDb().loadAll();
    }
}
