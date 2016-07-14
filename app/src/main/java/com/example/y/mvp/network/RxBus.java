package com.example.y.mvp.network;

import rx.Observable;
import rx.functions.Func1;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * by y on 2016/6/16.
 * 单例模式
 * 可以参考这篇博文：http://www.race604.com/java-double-checked-singleton/
 */
public class RxBus {

    private final Subject rxBus;

    private RxBus() {
        rxBus = new SerializedSubject<>(PublishSubject.create());
    }

    public static RxBus getInstance() {
        return RxbusHolder.rxBus;
    }

    public static class RxbusHolder {
        private static final RxBus rxBus = new RxBus();
    }

    public void sendNetWork(Object data) {
        //noinspection unchecked
        rxBus.onNext(data);
    }

    public <T> Observable<T> toObserverable(final Class<T> eventType) {
        //noinspection unchecked
        return rxBus.filter(new Func1<Object, Boolean>() {
            @Override
            public Boolean call(Object object) {
                return eventType.isInstance(object);
            }
        }).cast(eventType);
    }

}
