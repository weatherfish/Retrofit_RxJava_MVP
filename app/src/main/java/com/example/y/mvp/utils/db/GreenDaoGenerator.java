package com.example.y.mvp.utils.db;

import com.example.y.mvp.data.Constant;

import java.io.IOException;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * by y on 2016/7/8.
 */
public class GreenDaoGenerator {

    private static Entity entity;
    private static DaoGenerator daoGenerator;
    private static final String PACKAGE = "com.example.y.mvp";
    private static final String ID = "id";
    //news tab name
    private static final String NEWS_TAB_NAME = "name";
    //news list
    private static final String NEWS_LIST_TYPE = "type";
    private static final String NEWS_LIST_COUNT = "count";
    private static final String NEWS_LIST_DESCRIPTION = "description";
    private static final String NEWS_LIST_FCOUNT = "fcount";
    private static final String NEWS_LIST_FROMNAME = "fromname";
    private static final String NEWS_LIST_TITLE = "title";
    private static final String NEWS_LIST_IMG = "img";
    private static final String NEWS_LIST_FROMURL = "fromurl";
    private static final String NEWS_LIST_TIME = "time";
    private static final String NEWS_LIST_KEYWORDS = "keywords";
    //news detail
    private static final String NEWS_DETAIL_TITLE = "title";
    private static final String NEWS_DETAIL_IMG = "img";
    private static final String NEWS_DETAIL_MESSAGE = "message";
    private static final String NEWS_DETAIL_COUNT = "count";
    private static final String NEWS_DETAIL_DESCRIPTION = "description";
    private static final String NEWS_DETAIL_FCOUNT = "fcount";
    private static final String NEWS_DETAIL_FROMNAME = "fromname";
    private static final String NEWS_DETAIL_KEYWORDS = "keywords";
    private static final String NEWS_DETAIL_RCOUNT = "rcount";
    private static final String NEWS_DETAIL_TOPCLASS = "topclass";
    private static final String NEWS_DETAIL_FROMURL = "fromurl";
    private static final String NEWS_DETAIL_TIME = "time";
    //image tab name
    private static final String IMAGE_TAB_NAME = "name";
    //image list
    private static final String IMAGE_LIST_GALLERY_CLASS = "galleryclass";
    private static final String IMAGE_LIST_TITLE = "title";
    private static final String IMAGE_LIST_IMG = "img";
    private static final String IMAGE_LIST_COUNT = "count";
    private static final String IMAGE_LIST_RCOUNT = "rcount";
    private static final String IMAGE_LIST_FCOUNT = "fcount";
    private static final String IMAGE_LIST_SIZE = "size";
    //image detail
    private static final String GALLERY = "gallery";
    private static final String IMAGE_DETAIL_SRC = "src";
    //joke pic
    private static final String JOKE_PIC_CT = "ct";
    private static final String JOKE_PIC_TITLE = "title";
    private static final String JOKE_PIC_TYPE = "type";
    private static final String JOKE_PIC_IMG = "img";
    //joke text
    private static final String JOKE_TEXT_CT = "ct";
    private static final String JOKE_TEXT_TITLE = "title";
    private static final String JOKE_TEXT_TYPE = "type";
    private static final String JOKE_TEXT_TEXT = "text";


    private static class SchemaHolder {
        public static final Schema schema = new Schema(1, PACKAGE);
    }

    private static Schema getSchema() {
        return SchemaHolder.schema;
    }

    private static Entity initEntity(String sqlName) {
        entity = getSchema().addEntity(sqlName);
        return entity;
    }

    private static DaoGenerator getDaoGenerator() throws IOException {
        if (daoGenerator == null) {
            daoGenerator = new DaoGenerator();
        }
        return daoGenerator;
    }

    private static void startGreenDao() throws Exception {
        getDaoGenerator().generateAll(getSchema(), "../Retrofit_RxJava_MVP/app/src/main/java-gen");
    }

    public static void main(String[] args) throws Exception {
        initNewsTab();
        initNewsList();
        initNewsDetail();
        initImageTab();
        initImageList();
        initImageDetail();
        initJokePic();
        initJokeText();
    }


    private static void initNewsTab() throws Exception {
        initEntity(Constant.NEWS_TAB_NAME_INFO);
        entity.addIntProperty(ID);
        entity.addStringProperty(NEWS_TAB_NAME);
        startGreenDao();
    }

    private static void initNewsList() throws Exception {
        initEntity(Constant.NEWS_LIST_INFO);
        entity.addIntProperty(ID);
        entity.addIntProperty(NEWS_LIST_TYPE);
        entity.addIntProperty(NEWS_LIST_COUNT);
        entity.addStringProperty(NEWS_LIST_DESCRIPTION);
        entity.addIntProperty(NEWS_LIST_FCOUNT);
        entity.addStringProperty(NEWS_LIST_FROMNAME);
        entity.addStringProperty(NEWS_LIST_TITLE);
        entity.addStringProperty(NEWS_LIST_IMG);
        entity.addStringProperty(NEWS_LIST_FROMURL);
        entity.addLongProperty(NEWS_LIST_TIME);
        entity.addStringProperty(NEWS_LIST_KEYWORDS);
        startGreenDao();
    }


    private static void initNewsDetail() throws Exception {
        initEntity(Constant.NEWS_DETAIL_INFO);
        entity.addIntProperty(ID);
        entity.addIntProperty(NEWS_DETAIL_COUNT);
        entity.addStringProperty(NEWS_DETAIL_DESCRIPTION);
        entity.addIntProperty(NEWS_DETAIL_FCOUNT);
        entity.addStringProperty(NEWS_DETAIL_FROMNAME);
        entity.addStringProperty(NEWS_DETAIL_IMG);
        entity.addStringProperty(NEWS_DETAIL_KEYWORDS);
        entity.addStringProperty(NEWS_DETAIL_MESSAGE);
        entity.addIntProperty(NEWS_DETAIL_RCOUNT);
        entity.addStringProperty(NEWS_DETAIL_TITLE);
        entity.addIntProperty(NEWS_DETAIL_TOPCLASS);
        entity.addStringProperty(NEWS_DETAIL_FROMURL);
        entity.addLongProperty(NEWS_DETAIL_TIME);
        startGreenDao();
    }


    private static void initImageTab() throws Exception {
        initEntity(Constant.IMAGE_TAB_NAME_INFO);
        entity.addIntProperty(ID);
        entity.addStringProperty(IMAGE_TAB_NAME);
        startGreenDao();
    }

    private static void initImageList() throws Exception {
        initEntity(Constant.IMAGE_LIST_INFO);
        entity.addIntProperty(ID);
        entity.addIntProperty(IMAGE_LIST_GALLERY_CLASS);
        entity.addStringProperty(IMAGE_LIST_TITLE);
        entity.addStringProperty(IMAGE_LIST_IMG);
        entity.addIntProperty(IMAGE_LIST_COUNT);
        entity.addIntProperty(IMAGE_LIST_RCOUNT);
        entity.addIntProperty(IMAGE_LIST_FCOUNT);
        entity.addIntProperty(IMAGE_LIST_SIZE);
        startGreenDao();
    }

    private static void initImageDetail() throws Exception {
        initEntity(Constant.IMAGE_DETAIL_INFO);
        entity.addIntProperty(ID);
        entity.addIntProperty(GALLERY);
        entity.addStringProperty(IMAGE_DETAIL_SRC);
        startGreenDao();
    }

    private static void initJokePic() throws Exception {
        initEntity(Constant.JOKE_PIC_INFO);
        entity.addStringProperty(JOKE_PIC_CT);
        entity.addStringProperty(ID);
        entity.addStringProperty(JOKE_PIC_TITLE);
        entity.addStringProperty(JOKE_PIC_TYPE);
        entity.addStringProperty(JOKE_PIC_IMG);
        startGreenDao();
    }

    private static void initJokeText() throws Exception {
        initEntity(Constant.JOKE_TEXT_INFO);
        entity.addStringProperty(ID);
        entity.addStringProperty(JOKE_TEXT_CT);
        entity.addStringProperty(JOKE_TEXT_TEXT);
        entity.addStringProperty(JOKE_TEXT_TITLE);
        entity.addStringProperty(JOKE_TEXT_TYPE);
        startGreenDao();
    }


}
