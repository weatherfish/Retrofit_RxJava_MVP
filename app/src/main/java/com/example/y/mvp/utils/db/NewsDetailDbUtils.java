package com.example.y.mvp.utils.db;

import com.example.y.mvp.NewsDetailInfo;
import com.example.y.mvp.NewsDetailInfoDao;
import com.example.y.mvp.data.Constant;

/**
 * by y on 2016/7/11.
 */
public class NewsDetailDbUtils {

    public static void insert(int id, String title, String message, String img) {
        if (GreenDaoDbUtils.isEmpty(Constant.NEWS_DETAIL_INFO, id)) {
            GreenDaoDbUtils.getNewsDetailDb().insert(new NewsDetailInfo(null, id, null, null, null, null, img, null, message, null, title, null, null, null));
        }
    }

    public static NewsDetailInfo searchType(int id) {
        return GreenDaoDbUtils.getNewsDetailDb().queryBuilder().where(NewsDetailInfoDao.Properties.Id.eq(id)).unique();
    }

}
