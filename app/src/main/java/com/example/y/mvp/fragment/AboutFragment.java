package com.example.y.mvp.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.y.mvp.R;
import com.example.y.mvp.adapter.AboutAdapter;
import com.example.y.mvp.data.Constant;
import com.example.y.mvp.utils.UIUtils;
import com.example.y.mvp.utils.theme.widget.ThemeRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * by 12406 on 2016/5/2.
 */
public class AboutFragment extends BaseFragment implements ThemeRecyclerView.LoadingData {


    private ThemeRecyclerView recyclerView;

    @Override
    public View initView() {
        return View.inflate(UIUtils.getActivity(), R.layout.fragment_about, null);
    }

    @Override
    protected void initById() {
        recyclerView = getView(R.id.recyclerView);
    }

    @Override
    public void initData() {

        List<String> list = new ArrayList<>();
        list.add(UIUtils.getString(R.string.about_text));
        AboutAdapter aboutAdapter = new AboutAdapter(list);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLoadingData(this);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(Constant.RECYCLERVIEW_LINEAR, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(aboutAdapter);
    }


    @Override
    public void onLoadMore() {

    }
}
