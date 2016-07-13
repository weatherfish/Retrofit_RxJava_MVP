package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.utils.RxBusUtils;

/**
 * by y on 2016/5/27.
 */
public abstract class BasePresenterImpls<T> implements RxBusUtils.RxBusNetWork {

    protected final T view;

    public BasePresenterImpls(T view) {
        RxBusUtils.rxNetWork(this);
        this.view = view;
    }

    @Override
    public void onNext(Object o) {
        //noinspection unchecked
        onNetWorkSuccess(o);
    }

    @Override
    public void onError() {
        onNetWorkError();
    }

    protected abstract void onNetWorkSuccess(Object o);

    protected abstract void onNetWorkError();

}
