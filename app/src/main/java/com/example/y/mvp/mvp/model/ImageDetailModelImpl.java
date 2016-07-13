package com.example.y.mvp.mvp.model;


import com.example.y.mvp.mvp.Bean.BaseBean;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;
import com.example.y.mvp.network.RxBus;

/**
 * by y on 2016/4/29.
 */
public class ImageDetailModelImpl implements Model.ImageDetailModel {


    @Override
    public void netWorkDetail(final int id) {

        NetWorkRequest.imageDetail(id, new MySubscriber<BaseBean.ImageDetailBean>() {
            @Override
            public void onNext(BaseBean.ImageDetailBean imageDetailBean) {
                super.onNext(imageDetailBean);
                RxBus.getInstance().sendNetWork(imageDetailBean.getList());
            }
        });
    }


}
