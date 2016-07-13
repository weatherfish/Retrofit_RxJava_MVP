package com.example.y.mvp.mvp.model;


import com.example.y.mvp.mvp.Bean.BaseBean;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;
import com.example.y.mvp.network.RxBus;

/**
 * by y on 2016/4/28.
 */
public class TabNameModelImpl implements Model.TabNameModel {


    @Override
    public void netWork() {
        NetWorkRequest.tabName(new MySubscriber<BaseBean.TabNameBean>() {
            @Override
            public void onNext(BaseBean.TabNameBean tabNameBean) {
                RxBus.getInstance().sendNetWork(tabNameBean.getTngou());
            }
        });
    }


}
