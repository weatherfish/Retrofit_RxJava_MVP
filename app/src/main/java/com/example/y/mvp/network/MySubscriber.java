package com.example.y.mvp.network;

import com.example.y.mvp.data.Constant;
import com.socks.library.KLog;

import rx.Subscriber;

/**
 * by y on 2016/5/6.
 */
public class MySubscriber<T> extends Subscriber<T> {


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
        KLog.i(e.getMessage());
        RxBus.getInstance().sendNetWork(Constant.ON_ERROR);
    }

    @Override
    public void onNext(T t) {
    }


}
