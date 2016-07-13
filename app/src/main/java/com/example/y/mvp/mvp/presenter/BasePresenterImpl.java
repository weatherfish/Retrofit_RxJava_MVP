package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.utils.RxBusUtils;

import java.util.List;

/**
 * by y on 2016/5/27.
 */
public abstract class BasePresenterImpl<T, M> implements RxBusUtils.RxBusNetWork {

    final T view;

    public BasePresenterImpl(T view) {
        RxBusUtils.rxNetWork(this);
        this.view = view;
    }

    @Override
    public void onNext(Object o) {
        //noinspection unchecked
        onNetWorkSuccess((List<M>) o);
    }

    @Override
    public void onError() {
        onNetWorkError();
    }

    protected abstract void onNetWorkSuccess(List<M> data);

    protected abstract void onNetWorkError();

}
