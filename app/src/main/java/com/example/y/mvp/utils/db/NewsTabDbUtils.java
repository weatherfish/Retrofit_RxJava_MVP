package com.example.y.mvp.utils.db;

import com.example.y.mvp.NewsTabDao;
import com.example.y.mvp.mvp.Bean.TabNewsInfo;

import java.util.List;

/**
 * by y on 2016/7/8.
 */
public class NewsTabDbUtils {


    public static void addNews(int id, String name) {
        if (searchNewsTab(id)) {
            getNewsTabDb().insert(new TabNewsInfo(null, id, name));
        }
    }

    public static void deleteNews() {
        getNewsTabDb().deleteAll();
    }

    public static List<TabNewsInfo> getNews() {
        return getNewsTabDb().loadAll();
    }

    public static boolean searchNewsTab(int id) {
        return getNewsTabDb().queryBuilder().where(NewsTabDao.Properties.MId.eq(id)).unique() == null;
    }

    public static NewsTabDao getNewsTabDb() {
        return GreenDaoUtils.getSession().getNewsTabDao();
    }


}
