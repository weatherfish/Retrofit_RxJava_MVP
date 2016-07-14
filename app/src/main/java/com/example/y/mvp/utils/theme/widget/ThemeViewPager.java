package com.example.y.mvp.utils.theme.widget;


import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.y.mvp.utils.theme.ThemeUIInterface;
import com.example.y.mvp.utils.theme.ViewAttributeUtils;

/**
 * by y on 2016/4/28.
 */
@SuppressWarnings("ALL")
public class ThemeViewPager extends ViewPager implements ThemeUIInterface {

    private boolean isScroll = true;
    private int attr_img = -1;

    public ThemeViewPager(Context context) {
        super(context);
    }

    public ThemeViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        attr_img = ViewAttributeUtils.getBackgroundAttibute(attrs);
    }


    public void setScanScroll(boolean isCanScroll) {
        this.isScroll = isCanScroll;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return isScroll && super.onTouchEvent(ev);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isScroll && super.onInterceptTouchEvent(ev);
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void setTheme(Resources.Theme themeId) {
        if (attr_img != -1) {
            ViewAttributeUtils.applyImageDrawable(this, themeId, attr_img);
        }
    }
}
