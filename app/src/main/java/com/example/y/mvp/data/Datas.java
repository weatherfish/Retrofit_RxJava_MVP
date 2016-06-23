package com.example.y.mvp.data;

import com.example.y.mvp.R;
import com.example.y.mvp.utils.UIUtils;

import java.util.List;

/**
 * by y on 2016/6/22.
 */
public class Datas {


    public static void setMenuData(List<String> menuItem) {
        menuItem.add(UIUtils.getString(R.string.list_menu_news));
        menuItem.add(UIUtils.getString(R.string.list_menu_image));
        menuItem.add(UIUtils.getString(R.string.list_menu_new_image));
        menuItem.add(UIUtils.getString(R.string.list_menu_joke));
        menuItem.add(UIUtils.getString(R.string.list_menu_about));
    }

}
