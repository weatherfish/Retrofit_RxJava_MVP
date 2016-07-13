package com.example.y.mvp.mvp.model;

import com.example.y.mvp.mvp.Bean.BaseBean;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;
import com.example.y.mvp.network.RxBus;

/**
 * by 12406 on 2016/5/15.
 */
public class NewsListModelImpl implements Model.NewsListModel {

    @Override
    public void netWorkNewList(final int id, int page) {


        NetWorkRequest.newsList(id, page, new MySubscriber<BaseBean.NewsListBean>() {
            @Override
            public void onNext(BaseBean.NewsListBean newsListBean) {
                RxBus.getInstance().sendNetWork(newsListBean.getInfo());
            }
        });
    }

}
