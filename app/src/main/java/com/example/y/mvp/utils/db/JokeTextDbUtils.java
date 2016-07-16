package com.example.y.mvp.utils.db;

import com.example.y.mvp.JokeTextInfo;
import com.example.y.mvp.JokeTextInfoDao;

/**
 * by y on 2016/7/15.
 */
public class JokeTextDbUtils {
    public static void insert(String id, String text, String ct) {
        if (isEmpty(id)) {
            GreenDaoDbUtils.getJokeTextDb().insert(new JokeTextInfo(null, id, ct, text, null, null));
        }
    }

    public static boolean isEmpty(String id) {
        return GreenDaoDbUtils.getJokeTextDb().queryBuilder().where(JokeTextInfoDao.Properties.Id.eq(id)).unique() == null;
    }
}
