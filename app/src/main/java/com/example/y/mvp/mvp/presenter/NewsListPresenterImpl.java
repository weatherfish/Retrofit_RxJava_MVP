package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.NewsListInfo;
import com.example.y.mvp.activity.NewsDetailActivity;
import com.example.y.mvp.mvp.model.Model;
import com.example.y.mvp.mvp.model.NewsListModelImpl;
import com.example.y.mvp.mvp.view.BaseView;

import java.util.List;

/**
 * by 12406 on 2016/5/15.
 */
public class NewsListPresenterImpl extends BasePresenterImpl<BaseView.NewsListView, NewsListInfo>
        implements Presenter.NewsListPresenter {

    private final Model.NewsListModel newsListModel;

    public NewsListPresenterImpl(BaseView.NewsListView view) {
        super(view);
        this.newsListModel = new NewsListModelImpl();
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
        newsListModel.netWorkNewList(id, page);
    }

    @Override
    public void onClick(NewsListInfo info) {
        NewsDetailActivity.startIntent(info.getId());
    }

    @Override
    protected void onNetWorkSuccess(List<NewsListInfo> data) {
        view.setData(data);
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
