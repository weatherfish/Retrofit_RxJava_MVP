package com.example.y.mvp.adapter;

import android.text.Html;

import com.example.y.mvp.R;
import com.example.y.mvp.mvp.Bean.JokeTextBean;
import com.example.y.mvp.utils.UIUtils;

import java.util.List;

/**
 * by y on 2016/5/30.
 */
public class JokeTextAdapter extends BaseRecyclerViewAdapter<JokeTextBean.JokeTextInfo> {


    public JokeTextAdapter(List<JokeTextBean.JokeTextInfo> datas) {
        super(datas);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.joke_text_list_item;
    }

    @Override
    protected void onBind(ViewHolder holder, int position, JokeTextBean.JokeTextInfo data) {
        holder.setTextView(R.id.tv_time,UIUtils.getString(R.string.news_time) + data.getCt());
        holder.setTextView(R.id.tv_text,Html.fromHtml(data.getText()));
    }

}
