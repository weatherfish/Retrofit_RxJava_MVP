package com.example.y.mvp.mvp.presenter;


import android.widget.Toast;

import com.example.y.mvp.R;
import com.example.y.mvp.activity.ImageDetailActivity;
import com.example.y.mvp.mvp.model.BaseBean;
import com.example.y.mvp.mvp.model.ImageNewInfo;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;
import com.example.y.mvp.utils.ActivityUtils;
import com.example.y.mvp.utils.UIUtils;

/**
 * by y on 2016/4/29.
 */
public class ImageNewPresenterImpl extends BasePresenterImpl<BaseView.ImageNewView>
        implements Presenter.ImageNewPresenter {


    public ImageNewPresenterImpl(BaseView.ImageNewView view) {
        super(view);
    }

    @Override
    public void requestNetWork(String id, String rows) {

        if (id.isEmpty()) {
            view.hideProgress();
            Toast.makeText(UIUtils.getContext(), UIUtils.getString(R.string.image_new_id), Toast.LENGTH_LONG).show();
        } else {
            if (rows.isEmpty()) {
                rows = "20";
            }
            if (ActivityUtils.syskeyBroadStatus()) {
                ActivityUtils.closeSyskeyBroad();
            }
            NetWorkRequest.imageNew(Integer.valueOf(id), Integer.valueOf(rows), new MySubscriber<BaseBean.ImageNewBean>() {
                @Override
                public void onNext(BaseBean.ImageNewBean imageNewBean) {
                    super.onNext(imageNewBean);
                    //noinspection unchecked
                    view.setData(imageNewBean.getTngou());
                }
            });
        }
    }

    @Override
    public void onClick(ImageNewInfo info) {
        ImageDetailActivity.startIntent(info.getId(), info.getTitle());
    }

    @Override
    protected void onNetWorkStart() {
        view.showProgress();
    }

    @Override
    protected void onNetWorkCompleted() {
        view.hideProgress();
    }


    @Override
    protected void onNetWorkError() {
        view.hideProgress();
        view.netWorkError();
    }
}
