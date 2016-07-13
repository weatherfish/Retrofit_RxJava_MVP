package com.example.y.mvp.mvp.presenter;


import com.example.y.mvp.NewsTabNameInfo;
import com.example.y.mvp.mvp.model.Model;
import com.example.y.mvp.mvp.model.TabNewsModelImpl;
import com.example.y.mvp.mvp.view.BaseView;

import java.util.List;

/**
 * by 12406 on 2016/5/14.
 */
public class TabNewsPresenterImpl extends BasePresenterImpl<BaseView.TabNewsView, NewsTabNameInfo>
        implements Presenter.TabNewsPresenter {


    private final Model.TabNewsModel tabNewsModel;

    public TabNewsPresenterImpl(BaseView.TabNewsView view) {
        super(view);
        this.tabNewsModel = new TabNewsModelImpl();
    }

    @Override
    public void requestNetWork() {
        tabNewsModel.netWork();
    }

    @Override
    protected void onNetWorkSuccess(List<NewsTabNameInfo> data) {
        view.setData(data);
    }


    @Override
    protected void onNetWorkError() {
        view.netWorkError();
    }

}
