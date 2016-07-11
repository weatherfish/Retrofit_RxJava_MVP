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
            GreenDaoDbUtils.getNewsTabNameDb().insert(new NewsTabNameInfo(id, name));
        }
    }

    public static void deleteNewsTabName() {
        GreenDaoDbUtils.getNewsTabNameDb().deleteAll();
    }

    public static List<NewsTabNameInfo> getNewsTabName() {
        return GreenDaoDbUtils.getNewsTabNameDb().loadAll();
    }

    public static String getNewsTabName(int position) {
        return GreenDaoDbUtils.getNewsTabNameDb().loadAll().get(position).getName();
    }

    public static boolean searchNewsTabName(int id) {
        return GreenDaoDbUtils.getNewsTabNameDb().queryBuilder().where(NewsTabNameInfoDao.Properties.Id.eq(id)).unique() == null;
    }

}
