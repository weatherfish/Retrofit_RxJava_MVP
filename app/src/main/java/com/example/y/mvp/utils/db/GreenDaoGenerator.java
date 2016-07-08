package com.example.y.mvp.utils.db;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * by y on 2016/7/8.
 */
public class GreenDaoGenerator {

    private static Schema schema = new Schema(1, "com.example.y.mvp");

    public static void main(String[] args) throws Exception {
//        initNewsTab();
    }

    private static void initNewsTab() throws Exception {
        Entity newsTab = schema.addEntity("NewsTab");
        newsTab.addIdProperty().primaryKey();
        newsTab.addIntProperty("mId");
        newsTab.addStringProperty("name");
        new DaoGenerator().generateAll(schema, "../Retrofit_RxJava_MVP/app/src/main/java-gen");
    }
}
