package com.example.y.mvp.mvp.model;


import com.example.y.mvp.mvp.Bean.BaseBean;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;
import com.example.y.mvp.network.RxBus;
import com.socks.library.KLog;

/**
 * by y on 2016/4/28.
 */
public class ImageListModelImpl implements Model.ImageListModel {

    @Override
    public void netWorkList(int id, final int page) {

        NetWorkRequest.imageList(id, page, new MySubscriber<BaseBean.ImageListBean>() {
            @Override
            public void onNext(BaseBean.ImageListBean imageListBean) {
                RxBus.getInstance().sendNetWork(imageListBean.getInfo());
            }
        });
    }


}
