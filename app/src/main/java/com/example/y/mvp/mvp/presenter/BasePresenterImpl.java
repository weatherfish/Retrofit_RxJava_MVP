package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.utils.RxBusUtils;

/**
 * by y on 2016/5/27.
 */
public abstract class BasePresenterImpl<V>
        implements RxBusUtils.RxBusNetWork {

    protected final V view;

    BasePresenterImpl(V view) {
        RxBusUtils.rxNetWork(this);
        this.view = view;
    }

    @Override
    public void onStart() {
        onNetWorkStart();
    }

    @Override
    public void onCompleted() {
        onNetWorkCompleted();
    }


    @Override
    public void onError() {
        onNetWorkError();
    }

    void onNetWorkStart() {
    }

    void onNetWorkCompleted() {
    }

    protected abstract void onNetWorkError();

}
