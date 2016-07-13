package com.example.y.mvp.mvp.presenter;


import com.example.y.mvp.NewsDetailInfo;
import com.example.y.mvp.mvp.model.Model;
import com.example.y.mvp.mvp.model.NewsDetailModelImpl;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.utils.RxBusUtils;

/**
 * by 12406 on 2016/5/30.
 */
public class NewsDetailPresenterImpl
        implements Presenter.NewsDetailPresenter, RxBusUtils.RxBusNetWork {

    private final Model.NewsDetailModel newsDetailModel;
    private final BaseView.NewsDetailView newsDetailView;

    public NewsDetailPresenterImpl(BaseView.NewsDetailView view) {
        RxBusUtils.rxNetWork(this);
        this.newsDetailView = view;
        this.newsDetailModel = new NewsDetailModelImpl();
    }

    @Override
    public void requestNetWork(int id) {
        newsDetailView.showProgress();
        newsDetailModel.netWorkNewsDetail(id);
    }

    @Override
    public void onNext(Object o) {
        newsDetailView.setData((NewsDetailInfo) o);
        newsDetailView.hideProgress();
    }

    @Override
    public void onError() {
        newsDetailView.hideProgress();
        newsDetailView.netWorkError();
    }
}
