package com.example.y.mvp.mvp.model;

import com.example.y.mvp.mvp.Bean.BaseBean;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;
import com.example.y.mvp.network.RxBus;


/**
 * by 12406 on 2016/5/14.
 */
public class TabNewsModelImpl implements Model.TabNewsModel {


    @Override
    public void netWork() {

        NetWorkRequest.tabNews(new MySubscriber<BaseBean.TabNewsBean>() {
            @Override
            public void onNext(BaseBean.TabNewsBean tabNewsBean) {
                RxBus.getInstance().sendNetWork(tabNewsBean.getTngou());
            }
        });

    }

}
