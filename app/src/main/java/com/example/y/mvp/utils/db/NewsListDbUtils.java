package com.example.y.mvp.utils.db;


import com.example.y.mvp.NewsListInfo;
import com.example.y.mvp.NewsListInfoDao;
import com.example.y.mvp.data.Constant;

import java.util.List;

/**
 * by 12406 on 2016/7/9.
 */
public class NewsListDbUtils {

    public static void insert(int id, int type, String title, String img, String fromurl, Long time) {
        if (GreenDaoDbUtils.isEmpty(Constant.NEWS_LIST_INFO, id)) {
            GreenDaoDbUtils.getNewsListInfoDb().insert(new NewsListInfo(null, id, type, null, null, null, null, title, img, fromurl, time, null));
        }
    }

    public static List<NewsListInfo> searchType(int type) {
        return GreenDaoDbUtils.getNewsListInfoDb().queryBuilder().where(NewsListInfoDao.Properties.Type.eq(type)).list();
    }
}
