package com.example.y.mvp.mvp.presenter;


import com.example.y.mvp.ImageListInfo;
import com.example.y.mvp.activity.ImageDetailActivity;
import com.example.y.mvp.mvp.model.ImageListModelImpl;
import com.example.y.mvp.mvp.model.Model;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.utils.ActivityUtils;

import java.util.List;

/**
 * by y on 2016/4/29.
 */
public class ImageListPresenterImpl extends BasePresenterImpl<BaseView.ImageListView, ImageListInfo>
        implements Presenter.ImageListPresenter {

    private final Model.ImageListModel imageListModel;

    public ImageListPresenterImpl(BaseView.ImageListView view) {
        super(view);
        this.imageListModel = new ImageListModelImpl();
    }

    @Override
    public void requestNetWork(int id, int page, boolean isNull) {
        if (page == 1) {
            view.showProgress();
        } else {
            if (!isNull) {
                view.showFoot();
            }
        }
        imageListModel.netWorkList(id, page);
    }

    @Override
    public void onClick(ImageListInfo info) {
        ImageDetailActivity.startIntent(info.getId(), info.getTitle());
    }

    @Override
    protected void onNetWorkSuccess(List<ImageListInfo> data) {
        view.setData(data);
        view.hideProgress();
        view.hideFoot();
    }


    @Override
    protected void onNetWorkError() {
        view.hideFoot();
        view.hideProgress();
        view.netWorkError();
    }
}
