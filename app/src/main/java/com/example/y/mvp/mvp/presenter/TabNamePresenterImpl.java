package com.example.y.mvp.mvp.presenter;


import com.example.y.mvp.mvp.model.BaseBean;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;

/**
 * by y on 2016/4/29.
 */
public class TabNamePresenterImpl extends BasePresenterImpl<BaseView.TabNameView, BaseBean.TabNameBean>
        implements Presenter.TabNamePresenter {


    public TabNamePresenterImpl(BaseView.TabNameView view) {
        super(view);
    }

    @Override
    public void requestNetWork() {
        NetWorkRequest.tabName(new MySubscriber<BaseBean.TabNameBean>());
    }


    @Override
    protected void onNetWorkSuccess(BaseBean.TabNameBean tabNameBean) {
        //noinspection unchecked
        view.setData(tabNameBean.getTngou());
    }


    @Override
    protected void onNetWorkError() {
        view.netWorkError();
    }

}
