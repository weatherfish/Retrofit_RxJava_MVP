package com.example.y.mvp.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.y.mvp.BuildConfig;
import com.example.y.mvp.data.Constant;
import com.example.y.mvp.utils.ActivityCollector;
import com.example.y.mvp.utils.RxUtil;
import com.example.y.mvp.utils.SpfUtils;
import com.example.y.mvp.utils.swipeback.SwipeBackActivity;
import com.example.y.mvp.utils.swipeback.SwipeBackLayout;
import com.socks.library.KLog;

/**
 * by y on 2016/4/28.
 */
public abstract class BaseActivity extends SwipeBackActivity {

    private static Activity activity;
    private static Context context;
    protected SwipeBackLayout swipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTheme();
        setContentView(getLayoutId());
        init();
        initById();
        setStatusBar();
        swipeBackLayout = getSwipeBackLayout();
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        ActivityCollector.addActivity(this);
//        KLog.i(getClass().getSimpleName());
    }

    private void init() {
        activity = this;
        context = getApplicationContext();
        SpfUtils.init(context);
        KLog.init(BuildConfig.LOG_DEBUG, Constant.K_LOG);
    }

    protected void initTheme() {
        if (SpfUtils.isTheme(Constant.DAY)) {
            setTheme(Constant.DAY_STYLES);
        } else {
            setTheme(Constant.NIGHT_STYLES);
        }
    }

    protected void setStatusBar() {
    }

    public static Activity getActivity() {
        return activity;
    }

    public static Context getContext() {
        return context;
    }

    <T extends View> T getView(int id) {
        //noinspection unchecked
        return (T) findViewById(id);
    }

    protected abstract void initById();

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxUtil.unsubscribe();
    }
}
