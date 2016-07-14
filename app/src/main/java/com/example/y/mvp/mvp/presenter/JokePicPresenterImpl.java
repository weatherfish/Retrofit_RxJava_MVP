package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.mvp.model.JokePicBean;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;

/**
 * by y on 2016/5/30.
 */
public class JokePicPresenterImpl extends BasePresenterImpl<BaseView.JokePicView, JokePicBean>
        implements Presenter.JokePicPresenter {


    public JokePicPresenterImpl(BaseView.JokePicView view) {
        super(view);
    }

    @Override
    public void requestNetWork(int page, boolean isNull) {
        if (page == 1) {
            view.showProgress();
        } else {
            if (!isNull) {
                view.showFoot();
            }
        }
        NetWorkRequest.jokePicList(page, new MySubscriber<JokePicBean>());
    }

    @Override
    protected void onNetWorkSuccess(JokePicBean jokePicBean) {
        view.setData(jokePicBean.getShowapi_res_body().getContentlist());
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
