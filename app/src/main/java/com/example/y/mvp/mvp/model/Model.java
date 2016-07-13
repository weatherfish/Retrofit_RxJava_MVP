package com.example.y.mvp.mvp.model;

/**
 * by y on 2016/5/27.
 */
public interface Model {


    interface TabNewsModel {
        void netWork();
    }

    interface TabNameModel {
        void netWork();
    }

    interface NewsListModel {
        void netWorkNewList(int id, int page);
    }

    interface NewsDetailModel {
        void netWorkNewsDetail(int id);
    }

    interface ImageNewModel {
        void netWorkNew(int id, int rows);
    }

    interface ImageListModel {
        void netWorkList(int id, int page);
    }

    interface ImageDetailModel {
        void netWorkDetail(int id);
    }

    interface JokeTextListModel {
        void netWorkJoke(int paget);
    }

    interface JokePicListModel {
        void netWorkJoke(int page);
    }

}
