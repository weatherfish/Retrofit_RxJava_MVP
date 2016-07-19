package com.example.y.mvp.utils;

import com.example.y.mvp.data.Constant;
import com.example.y.mvp.network.RxBus;
import com.socks.library.KLog;

import rx.functions.Action1;

/**
 * by y on 2016/6/22.
 */
public class RxBusUtils {

    public static void rxNetWork(final RxBusNetWork rxBusNetWork) {
        RxBus.getInstance().toObserverable(Object.class).subscribe(new Action1<Object>() {
            @Override
            public void call(Object o) {
                switch (String.valueOf(o)) {
                    case Constant.ON_START:
                        rxBusNetWork.onStart();
                        break;
                    case Constant.ON_COMPLETED:
                        rxBusNetWork.onCompleted();
                        break;
                    case Constant.ON_ERROR:
                        rxBusNetWork.onError();
                        break;
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                KLog.i(throwable.getMessage());
            }
        });

    }

    public interface RxBusNetWork {
        void onStart();

        void onCompleted();

        void onError();
    }
}
