package com.example.y.mvp.mvp.model;

import com.example.y.mvp.mvp.Bean.JokePicBean;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;
import com.example.y.mvp.network.RxBus;

/**
 * by y on 2016/5/30.
 */
public class JokePicModeImpl implements Model.JokePicListModel {

    @Override
    public void netWorkJoke(int page) {
        NetWorkRequest.jokePicList(page, new MySubscriber<JokePicBean>() {
            @Override
            public void onNext(JokePicBean jokePicBean) {
                super.onNext(jokePicBean);
                RxBus.getInstance().sendNetWork(jokePicBean.getShowapi_res_body().getContentlist());
            }
        });
    }
}
