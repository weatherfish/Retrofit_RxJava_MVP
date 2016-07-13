package com.example.y.mvp.mvp.Bean;


import com.example.y.mvp.ImageDetailInfo;
import com.example.y.mvp.ImageListInfo;
import com.example.y.mvp.ImageTabNameInfo;
import com.example.y.mvp.NewsListInfo;
import com.example.y.mvp.NewsTabNameInfo;

import java.util.List;

/**
 * by y on 2016/5/27.
 */
@SuppressWarnings("ALL")
public class BaseBean<T> {

    private List<T> tngou;


    public List<T> getTngou() {
        return tngou;
    }

    public void setTngou(List<T> tngou) {
        this.tngou = tngou;
    }


    public class TabNewsBean extends BaseBean<NewsTabNameInfo> {
    }

    public class TabNameBean extends BaseBean<ImageTabNameInfo> {
    }

    public class ImageListBean extends BaseBean<ImageListInfo> {
    }

    public class ImageNewBean extends BaseBean<ImageNewInfo> {
    }

    public class NewsListBean extends BaseBean<NewsListInfo> {
    }

    public class ImageDetailBean {
        private List<ImageDetailInfo> list;

        public List<ImageDetailInfo> getList() {
            return list;
        }

        public void setList(List<ImageDetailInfo> list) {
            this.list = list;
        }

    }

}
