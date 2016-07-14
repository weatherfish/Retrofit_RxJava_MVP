package com.example.y.mvp.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.y.mvp.ImageTabNameInfo;
import com.example.y.mvp.fragment.ImageListFragment;

import java.util.List;

/**
 * by y on 2016/4/28.
 */
public class TabNameAdapter extends BaseFragmentPagerAdapter<ImageTabNameInfo> {


    public TabNameAdapter(FragmentManager fm, List<ImageTabNameInfo> mDatas) {
        super(fm, mDatas);
    }

    @Override
    protected Fragment getFragmentItem(int position) {
        return ImageListFragment.newInstance(position);
    }

    @Override
    protected CharSequence getTitle(ImageTabNameInfo data) {
        return data.getName();
    }

}
