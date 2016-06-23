package com.example.y.mvp.utils;

import android.view.View;

import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;

import rx.Subscription;
import rx.functions.Action1;

/**
 * by y on 2016/6/23.
 */
public class RxUtils {


    @SuppressWarnings("unused")
    public static void unsubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    //防手抖
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
