package com.example.y.mvp.utils.db;

import com.example.y.mvp.NewsTabNameInfo;
import com.example.y.mvp.data.Constant;

/**
 * by y on 2016/7/8.
 */
public class NewsTabNameDbUtils {


    public static void insert(int id, String name) {
        if (GreenDaoDbUtils.isEmpty(Constant.NEWS_TAB_NAME_INFO, id)) {
            GreenDaoDbUtils.getNewsTabNameDb().insert(new NewsTabNameInfo(null, id, name));
        }
    }

    public static void upDateSql(int id, String name) {
        GreenDaoDbUtils.getNewsTabNameDb().update(new NewsTabNameInfo(null, id, name));
    }
}
