package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.JokePicInfo;
import com.example.y.mvp.mvp.model.JokePicModeImpl;
import com.example.y.mvp.mvp.model.Model;
import com.example.y.mvp.mvp.view.BaseView;

import java.util.List;

/**
 * by y on 2016/5/30.
 */
public class JokePicPresenterImpl extends BasePresenterImpl<BaseView.JokePicView, JokePicInfo>
        implements Presenter.JokePicPresenter {

    private final Model.JokePicListModel jokePicListModel;


    public JokePicPresenterImpl(BaseView.JokePicView view) {
        super(view);
        this.jokePicListModel = new JokePicModeImpl();
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
        jokePicListModel.netWorkJoke(page);
    }

    @Override
    protected void onNetWorkSuccess(List<JokePicInfo> data) {
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
