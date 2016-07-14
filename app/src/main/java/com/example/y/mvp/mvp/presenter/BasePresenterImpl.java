package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.utils.RxBusUtils;
import com.socks.library.KLog;

/**
 * by y on 2016/5/27.
 */
public abstract class BasePresenterImpl<V, M>
        implements RxBusUtils.RxBusNetWork {

    final V view;

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
    public void onNext(Object o) {
        try {
            onNetWorkSuccess((M) o);
        } catch (Exception e) {
            KLog.i(e.getMessage());
        }
    }

    @Override
    public void onError() {
        onNetWorkError();
    }

    void onNetWorkStart() {
    }

    protected abstract void onNetWorkSuccess(M m);

    void onNetWorkCompleted() {
    }

    protected abstract void onNetWorkError();

}
