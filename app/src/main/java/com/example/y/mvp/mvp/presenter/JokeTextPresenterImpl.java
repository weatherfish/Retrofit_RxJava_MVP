package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.JokeTextInfo;
import com.example.y.mvp.mvp.model.JokeTextModeImpl;
import com.example.y.mvp.mvp.model.Model;
import com.example.y.mvp.mvp.view.BaseView;

import java.util.List;

/**
 * by y on 2016/5/30.
 */
public class JokeTextPresenterImpl extends BasePresenterImpl<BaseView.JokeTextView, JokeTextInfo>
        implements Presenter.JokeTextPresenter {

    private final Model.JokeTextListModel jokeListModel;

    public JokeTextPresenterImpl(BaseView.JokeTextView view) {
        super(view);
        this.jokeListModel = new JokeTextModeImpl();
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
        jokeListModel.netWorkJoke(page);
    }

    @Override
    protected void onNetWorkSuccess(List<JokeTextInfo> data) {
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
