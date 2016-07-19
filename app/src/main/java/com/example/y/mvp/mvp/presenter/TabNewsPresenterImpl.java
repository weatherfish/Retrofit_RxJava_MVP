package com.example.y.mvp.mvp.presenter;


import com.example.y.mvp.mvp.model.BaseBean;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;

/**
 * by 12406 on 2016/5/14.
 */
public class TabNewsPresenterImpl extends BasePresenterImpl<BaseView.TabNewsView>
        implements Presenter.TabNewsPresenter {


    public TabNewsPresenterImpl(BaseView.TabNewsView view) {
        super(view);
    }

    @Override
    public void requestNetWork() {
        NetWorkRequest.tabNews(new MySubscriber<BaseBean.TabNewsBean>() {
            @Override
            public void onNext(BaseBean.TabNewsBean tabNewsBean) {
                super.onNext(tabNewsBean);
                //noinspection unchecked
                view.setData(tabNewsBean.getTngou());
            }
        });
    }

    @Override
    protected void onNetWorkError() {
        view.netWorkError();
    }

}
