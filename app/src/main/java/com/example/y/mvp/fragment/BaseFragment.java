package com.example.y.mvp.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.y.mvp.utils.RxUtil;

/**
 * by y on 2016/4/28.
 */
public abstract class BaseFragment extends Fragment {

    protected boolean isLoad;
    protected boolean isPrepared;
    protected boolean isVisible;
    protected static final String FRAGMENT_INDEX = "fragment_index";
    protected int index = 0;
    protected int page = 1;
    protected boolean isNull = false;
    protected View view;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            index = bundle.getInt(FRAGMENT_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = initView(savedInstanceState);
            isPrepared = true;
        }
        initById();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
        }
    }

    <T extends View> T getView(int id) {
        //noinspection unchecked
        return (T) view.findViewById(id);
    }

    private void onVisible() {
        initData();
    }

    protected abstract View initView(Bundle savedInstanceState);

    protected abstract void initById();

    protected abstract void initData();

    protected void setLoad() {
        isLoad = true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        RxUtil.unsubscribe();
    }
}
