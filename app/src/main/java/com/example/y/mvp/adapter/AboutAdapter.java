package com.example.y.mvp.adapter;


import com.example.y.mvp.R;

import java.util.List;

/**
 * by y on 2016/5/3.
 */
public class AboutAdapter extends BaseRecyclerViewAdapter<String> {

    public AboutAdapter(List<String> datas) {
        super(datas);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.about_item;
    }

    @Override
    protected void onBind(BaseRecyclerViewAdapter.ViewHolder holder, int position, String data) {
            holder.setTextView(R.id.tv_about,data);
    }

}
