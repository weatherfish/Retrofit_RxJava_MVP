package com.example.y.mvp.mvp.model;


import com.example.y.mvp.NewsDetailInfo;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;
import com.example.y.mvp.network.RxBus;

/**
 * by 12406 on 2016/5/30.
 */
public class NewsDetailModelImpl implements Model.NewsDetailModel {


    @Override
    public void netWorkNewsDetail(int id) {
        NetWorkRequest.newsDetail(id, new MySubscriber<NewsDetailInfo>() {
            @Override
            public void onNext(NewsDetailInfo newsDetailInfo) {
                super.onNext(newsDetailInfo);
                RxBus.getInstance().sendNetWork(newsDetailInfo);
            }
        });
    }
}
