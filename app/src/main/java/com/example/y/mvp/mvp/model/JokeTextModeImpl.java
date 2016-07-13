package com.example.y.mvp.mvp.model;

import com.example.y.mvp.mvp.Bean.JokeTextBean;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;
import com.example.y.mvp.network.RxBus;

/**
 * by y on 2016/5/30.
 */
public class JokeTextModeImpl implements Model.JokeTextListModel {

    @Override
    public void netWorkJoke(int page) {

        NetWorkRequest.jokeTextList(page, new MySubscriber<JokeTextBean>() {
            @Override
            public void onNext(JokeTextBean jokeTextBean) {
                super.onNext(jokeTextBean);
                RxBus.getInstance().sendNetWork(jokeTextBean.getShowapi_res_body().getContentlist());
            }
        });

    }
}
