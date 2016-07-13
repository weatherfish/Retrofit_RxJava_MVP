package com.example.y.mvp.mvp.presenter;


import android.widget.Toast;

import com.example.y.mvp.R;
import com.example.y.mvp.activity.ImageDetailActivity;
import com.example.y.mvp.mvp.Bean.ImageNewInfo;
import com.example.y.mvp.mvp.model.ImageNewModelImpl;
import com.example.y.mvp.mvp.model.Model;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.utils.ActivityUtils;
import com.example.y.mvp.utils.UIUtils;

import java.util.List;

/**
 * by y on 2016/4/29.
 */
public class ImageNewPresenterImpl extends BasePresenterImpl<BaseView.ImageNewView, ImageNewInfo>
        implements Presenter.ImageNewPresenter {

    private final Model.ImageNewModel imageNewModel;


    public ImageNewPresenterImpl(BaseView.ImageNewView view) {
        super(view);
        this.imageNewModel = new ImageNewModelImpl();
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
            view.showProgress();
            imageNewModel.netWorkNew(Integer.valueOf(id), Integer.valueOf(rows));
        }
    }

    @Override
    public void onClick(ImageNewInfo info) {
        ImageDetailActivity.startIntent(info.getId(), info.getTitle());
    }

    @Override
    protected void onNetWorkSuccess(List<ImageNewInfo> data) {
        view.setData(data);
        view.hideProgress();
    }


    @Override
    protected void onNetWorkError() {
        view.hideProgress();
        view.netWorkError();
    }
}
