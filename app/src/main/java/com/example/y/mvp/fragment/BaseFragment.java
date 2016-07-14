package com.example.y.mvp.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.y.mvp.utils.RxUtil;
import com.socks.library.KLog;

/**
 * by y on 2016/4/28.
 */
public abstract class BaseFragment extends Fragment {

    boolean isVisible;
    static final String FRAGMENT_INDEX = "fragment_index";
    int index = 0;
    int page = 1;
    boolean isNull = false;
    View view;


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
        view = initView();
//        KLog.i(getClass().getSimpleName());
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

    protected abstract View initView();

    protected abstract void initById();

    protected abstract void initData();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        RxUtil.unsubscribe();
    }
}
