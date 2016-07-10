package com.example.y.mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.y.mvp.NewsTabNameInfo;
import com.example.y.mvp.fragment.NewsMainFragment;
import com.example.y.mvp.utils.db.NewsTabNameDbUtils;

import java.util.List;

/**
 * by 12406 on 2016/5/14.
 */
public class TabNewsAdapter extends BaseFragmentPagerAdapter<NewsTabNameInfo> {


    public TabNewsAdapter(FragmentManager fm, List<NewsTabNameInfo> mDatas) {
        super(fm, mDatas);
    }

    @Override
    protected Fragment getFragmentItem(int position) {
        return NewsMainFragment.newInstance(position);
    }

    @Override
    protected CharSequence getTitle(NewsTabNameInfo data) {
        NewsTabNameDbUtils.addNewsTabName(data.getId(),data.getName());
        return data.getName();
    }
}

