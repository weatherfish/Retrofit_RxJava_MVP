package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.NewsListInfo;
import com.example.y.mvp.activity.NewsDetailActivity;
import com.example.y.mvp.mvp.model.BaseBean;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;

/**
 * by 12406 on 2016/5/15.
 */
public class NewsListPresenterImpl extends BasePresenterImpl<BaseView.NewsListView, BaseBean.NewsListBean>
        implements Presenter.NewsListPresenter {


    public NewsListPresenterImpl(BaseView.NewsListView view) {
        super(view);
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
        NetWorkRequest.newsList(id, page, new MySubscriber<BaseBean.NewsListBean>());
    }

    @Override
    public void onClick(NewsListInfo info) {
        NewsDetailActivity.startIntent(info.getId());
    }

    @Override
    protected void onNetWorkSuccess(BaseBean.NewsListBean newsListBean) {
        view.setData(newsListBean.getTngou());
    }

    @Override
    protected void onNetWorkCompleted() {
        view.hideFoot();
        view.hideProgress();
    }

    @Override
    protected void onNetWorkError() {
        view.hideFoot();
        view.hideProgress();
        view.netWorkError();
    }

}
