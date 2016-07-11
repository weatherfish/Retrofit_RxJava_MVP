package com.example.y.mvp.mvp.model;


import com.example.y.mvp.ImageDetailInfo;
import com.example.y.mvp.ImageListInfo;
import com.example.y.mvp.ImageTabNameInfo;
import com.example.y.mvp.JokePicInfo;
import com.example.y.mvp.JokeTextInfo;
import com.example.y.mvp.NewsDetailInfo;
import com.example.y.mvp.NewsListInfo;
import com.example.y.mvp.NewsTabNameInfo;
import com.example.y.mvp.mvp.Bean.ImageNewInfo;

import java.util.List;

/**
 * by y on 2016/5/27.
 */
public interface BaseDataBridge<T> {

    void addData(List<T> datas);

    void error();




    interface ImageDetailData extends BaseDataBridge<ImageDetailInfo> {
    }

    interface ImageListData extends BaseDataBridge<ImageListInfo> {
    }

    interface ImageNewData extends BaseDataBridge<ImageNewInfo> {
    }

    interface NewsListData extends BaseDataBridge<NewsListInfo> {
    }

    interface NewsDetailData {
        void addData(NewsDetailInfo datas);
        void error();
    }

    interface TabNewsData extends BaseDataBridge<NewsTabNameInfo> {
    }

    interface TabNameData extends BaseDataBridge<ImageTabNameInfo> {
    }

    interface JokeTextList extends BaseDataBridge<JokeTextInfo> {
    }

    interface JokePicList extends BaseDataBridge<JokePicInfo> {
    }
}
