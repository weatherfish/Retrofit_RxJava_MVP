package com.example.y.mvp.network;

import com.socks.library.KLog;

import rx.Subscriber;

/**
 * by y on 2016/5/6.
 */
public class MySubscriber<T> extends Subscriber<T> {


    @Override
    public void onStart() {
        super.onStart();
        KLog.i("MySubscriber", "onStart被调用了");
    }

    @Override
    public void onCompleted() {
        KLog.i("MySubscriber", "onCompleted被调用了");
    }

    @Override
    public void onError(Throwable e) {
        KLog.i("Throwable", e.getMessage());
        KLog.i("MySubscriber", "onError被调用了");
    }

    @Override
    public void onNext(T t) {
        KLog.i("MySubscriber", "onNext被调用了");
    }


}
