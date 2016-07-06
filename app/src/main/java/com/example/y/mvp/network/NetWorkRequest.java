package com.example.y.mvp.network;

import com.example.y.mvp.mvp.Bean.BaseBean;
import com.example.y.mvp.mvp.Bean.JokePicBean;
import com.example.y.mvp.mvp.Bean.JokeTextBean;
import com.example.y.mvp.mvp.Bean.NewsDetailInfo;
import com.example.y.mvp.utils.RxUtil;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * by y on 2016/5/6.
 */
public class NetWorkRequest {


    @SuppressWarnings("unused")
    public static void newsDetail(int id, Subscriber<NewsDetailInfo> subscriber) {
        RxUtil.unsubscribe();
        RxUtil.subscription = Network.getTngouApi().getNewsDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void newsList(int id, int page, Subscriber<BaseBean.NewsListBean> subscriber) {
        RxUtil.unsubscribe();
        RxUtil.subscription = Network.getTngouApi().getNewsList(id, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void tabNews(Subscriber<BaseBean.TabNewsBean> subscriber) {
        RxUtil.unsubscribe();
        RxUtil.subscription = Network.getTngouApi().getTabNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void imageDetail(int id, Subscriber<BaseBean.ImageDetailBean> subscriber) {
        RxUtil.unsubscribe();
        RxUtil.subscription = Network.getTngouApi().getImageDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void imageList(int id, int page, Subscriber<BaseBean.ImageListBean> subscriber) {
        RxUtil.unsubscribe();
        RxUtil.subscription = Network.getTngouApi().getImageList(id, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void imageNew(int id, int rows, Subscriber<BaseBean.ImageNewBean> subscriber) {
        RxUtil.unsubscribe();
        RxUtil.subscription = Network.getTngouApi().getImageNews(id, rows)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void tabName(Subscriber<BaseBean.TabNameBean> subscriber) {
        RxUtil.unsubscribe();
        RxUtil.subscription = Network.getTngouApi().getTabName()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


    /////////////////////////////////////////////////////////////

    public static void jokeTextList(int page, Subscriber<JokeTextBean> subscriber) {
        RxUtil.unsubscribe();
        RxUtil.subscription = Network.getBaiDuApi().getJokeText(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void jokePicList(int page, Subscriber<JokePicBean> subscriber) {
        Network.getBaiDuApi().getJokePic(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


}
