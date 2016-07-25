package com.example.y.mvp.fragment;


import android.os.Bundle;
import android.view.View;

import com.example.y.mvp.R;
import com.example.y.mvp.utils.UIUtils;

/**
 * by 12406 on 2016/5/2.
 */
public class AboutFragment extends BaseFragment {

    @Override
    public View initView(Bundle savedInstanceState) {
        return View.inflate(UIUtils.getActivity(), R.layout.fragment_about, null);
    }


    @Override
    protected void initById() {
    }

    @Override
    public void initData() {
    }
}
