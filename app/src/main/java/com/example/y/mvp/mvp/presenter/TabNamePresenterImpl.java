package com.example.y.mvp.mvp.presenter;


import com.example.y.mvp.ImageTabNameInfo;
import com.example.y.mvp.mvp.model.Model;
import com.example.y.mvp.mvp.model.TabNameModelImpl;
import com.example.y.mvp.mvp.view.BaseView;

import java.util.List;

/**
 * by y on 2016/4/29.
 */
public class TabNamePresenterImpl extends BasePresenterImpl<BaseView.TabNameView, ImageTabNameInfo>
        implements Presenter.TabNamePresenter {

    private final Model.TabNameModel tabNameModel;

    public TabNamePresenterImpl(BaseView.TabNameView view) {
        super(view);
        this.tabNameModel = new TabNameModelImpl();
    }

    @Override
    public void requestNetWork() {
        tabNameModel.netWork();
    }

    @Override
    protected void onNetWorkSuccess(List<ImageTabNameInfo> data) {
        view.setData(data);
    }


    @Override
    protected void onNetWorkError() {
        view.netWorkError();
    }

}
