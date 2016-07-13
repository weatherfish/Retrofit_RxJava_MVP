package com.example.y.mvp.fragment;


import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.y.mvp.NewsTabNameInfo;
import com.example.y.mvp.R;
import com.example.y.mvp.adapter.TabNewsAdapter;
import com.example.y.mvp.mvp.presenter.Presenter;
import com.example.y.mvp.mvp.presenter.TabNewsPresenterImpl;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.utils.ActivityUtils;
import com.example.y.mvp.utils.UIUtils;
import com.example.y.mvp.utils.theme.widget.ThemeTabLayout;

import java.util.LinkedList;
import java.util.List;

/**
 * by 12406 on 2016/5/14.
 */
public class NewsViewPagerFragment extends BaseFragment implements BaseView.TabNewsView {

    private ThemeTabLayout tabLayout;
    private ViewPager viewPager;

    private List<NewsTabNameInfo> data;
    private TabNewsAdapter tabNewsAdapter;

    @Override
    protected View initView() {
        return View.inflate(UIUtils.getActivity(), R.layout.fragment_viewpager, null);
    }

    @Override
    protected void initById() {
        tabLayout = getView(R.id.tab_layout);
        viewPager = getView(R.id.viewPager);
    }

    @Override
    protected void initData() {
        data = new LinkedList<>();
        tabNewsAdapter = new TabNewsAdapter(getChildFragmentManager(), data);

        Presenter.TabNewsPresenter tabNewsPresenter = new TabNewsPresenterImpl(this);
        tabNewsPresenter.requestNetWork();

    }

    @Override
    public void setData(List<NewsTabNameInfo> datas) {
        if (!datas.isEmpty()) {
            data.addAll(datas);
            viewPager.setAdapter(tabNewsAdapter);
            tabLayout.setupWithViewPager(viewPager);
        }
    }

    @Override
    public void netWorkError() {
        ActivityUtils.Toast(UIUtils.getContext().getResources().getString(R.string.network_error));
    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void showFoot() {

    }

    @Override
    public void hideFoot() {

    }
}
