package com.example.y.mvp.mvp.model;


import com.example.y.mvp.mvp.Bean.BaseBean;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;
import com.example.y.mvp.network.RxBus;

/**
 * by 12406 on 2016/4/29.
 */
public class ImageNewModelImpl implements Model.ImageNewModel {


    @Override
    public void netWorkNew(int id, int rows) {

        NetWorkRequest.imageNew(id, rows, new MySubscriber<BaseBean.ImageNewBean>() {

            @Override
            public void onNext(BaseBean.ImageNewBean imageNewBean) {
                RxBus.getInstance().sendNetWork(imageNewBean.getTngou());
            }
        });
    }


}
