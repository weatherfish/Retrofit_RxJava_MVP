package com.example.y.mvp.utils;

import com.example.y.mvp.data.Constant;
import com.example.y.mvp.data.IsNightMode;
import com.example.y.mvp.network.RxBus;
import com.socks.library.KLog;

import rx.functions.Action1;

/**
 * by y on 2016/6/22.
 */
public class RxBusUtils {


    public static void rxTheme(final RxBusTheme rxBusTheme) {
        RxBus.getInstance().toObserverable(IsNightMode.class).subscribe(new Action1<IsNightMode>() {
            @Override
            public void call(IsNightMode isNightMode) {
                if (isNightMode.isNightMode()) {
                    rxBusTheme.setDay();
                } else {
                    rxBusTheme.setNight();
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                KLog.i(throwable.getMessage());
            }
        });
    }

    public static void rxNetWork(final RxBusNetWork rxBusNetWork) {
        RxBus.getInstance().toObserverable(Object.class).subscribe(new Action1<Object>() {
            @Override
            public void call(Object o) {
                if (!Constant.ON_ERROR.equals(o)) {
                    rxBusNetWork.onNext(o);
                } else {
                    rxBusNetWork.onError();
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                KLog.i(throwable.getMessage());
            }
        });

    }


    public interface RxBusTheme {
        void setDay();

        void setNight();
    }

    public interface RxBusNetWork {
        void onNext(Object o);

        void onError();
    }
}
