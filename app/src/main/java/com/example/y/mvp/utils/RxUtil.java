package com.example.y.mvp.utils;

import android.view.View;

import com.jakewharton.rxbinding.view.RxView;
import com.socks.library.KLog;

import java.util.concurrent.TimeUnit;

import rx.Subscription;
import rx.functions.Action1;

/**
 * by y on 2016/7/6.
 */
public class RxUtil {

    public static Subscription subscription;

    public static void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
            KLog.i("unsubscribe");
        }
    }


    public static void clicks(View view, final RxBinding rxBinding) {
        if (view != null)
            RxView.clicks(view)
                    .throttleFirst(600, TimeUnit.MILLISECONDS)
                    .subscribe(new Action1<Void>() {
                        @Override
                        public void call(Void aVoid) {
                            rxBinding.clicks();
                        }
                    });

    }


    public interface RxBinding {
        void clicks();
    }

}
