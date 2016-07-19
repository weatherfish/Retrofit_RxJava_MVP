package com.example.y.mvp.mvp.presenter;


import com.example.y.mvp.NewsDetailInfo;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;

/**
 * by 12406 on 2016/5/30.
 */
public class NewsDetailPresenterImpl extends BasePresenterImpl<BaseView.NewsDetailView>
        implements Presenter.NewsDetailPresenter {


    public NewsDetailPresenterImpl(BaseView.NewsDetailView view) {
        super(view);
    }


    @Override
    public void requestNetWork(int id) {
        NetWorkRequest.newsDetail(id, new MySubscriber<NewsDetailInfo>() {
            @Override
            public void onNext(NewsDetailInfo newsDetailInfo) {
                super.onNext(newsDetailInfo);
                view.setData(newsDetailInfo);
            }
        });
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
