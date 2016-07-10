package com.example.y.mvp.utils.db;

import com.example.y.mvp.NewsTabNameInfo;
import com.example.y.mvp.NewsTabNameInfoDao;

import java.util.List;

/**
 * by y on 2016/7/8.
 */
public class NewsTabNameDbUtils {


    public static void addNewsTabName(int id, String name) {
        if (searchNewsTabName(id)) {
            GreenDaoUtils.getNewsTabNameDb().insert(new NewsTabNameInfo(id, name));
        }
    }

    public static void deleteNewsTabName() {
        GreenDaoUtils.getNewsTabNameDb().deleteAll();
    }

    public static List<NewsTabNameInfo> getNewsTabName() {
        return GreenDaoUtils.getNewsTabNameDb().loadAll();
    }

    public static String getNewsTabName(int position) {
        return GreenDaoUtils.getNewsTabNameDb().loadAll().get(position).getName();
    }

    public static boolean searchNewsTabName(int id) {
        return GreenDaoUtils.getNewsTabNameDb().queryBuilder().where(NewsTabNameInfoDao.Properties.Id.eq(id)).unique() == null;
    }

}
