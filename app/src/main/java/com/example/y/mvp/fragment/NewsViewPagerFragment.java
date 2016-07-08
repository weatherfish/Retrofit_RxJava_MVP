package com.example.y.mvp.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.y.mvp.R;
import com.example.y.mvp.adapter.TabNewsAdapter;
import com.example.y.mvp.mvp.Bean.TabNewsInfo;
import com.example.y.mvp.mvp.presenter.BasePresenter;
import com.example.y.mvp.mvp.presenter.TabNewsPresenterImpl;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.utils.ActivityUtils;
import com.example.y.mvp.utils.UIUtils;
import com.example.y.mvp.utils.db.NewsTabDbUtils;
import com.example.y.mvp.utils.theme.widget.ThemeTabLayout;

import java.util.LinkedList;
import java.util.List;

/**
 * by 12406 on 2016/5/14.
 */
public class NewsViewPagerFragment extends BaseFragment implements BaseView.TabNewsView {

    private ThemeTabLayout tabLayout;
    private ViewPager viewPager;

    private List<TabNewsInfo> data;
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

        BasePresenter.TabNewsPresenter tabNewsPresenter = new TabNewsPresenterImpl(this);

        data = new LinkedList<>();

        if (NewsTabDbUtils.getNews().isEmpty()) {
            tabNewsPresenter.requestNetWork();
        } else {
            data.addAll(NewsTabDbUtils.getNews());
        }

        tabNewsAdapter = new TabNewsAdapter(getChildFragmentManager(), data);
        viewPager.setAdapter(tabNewsAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void setData(List<TabNewsInfo> datas) {
        if (!datas.isEmpty()) {
            data.addAll(datas);
            tabNewsAdapter.notifyDataSetChanged();
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
