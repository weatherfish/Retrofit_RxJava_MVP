package com.example.y.mvp.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.y.mvp.BuildConfig;
import com.example.y.mvp.R;
import com.example.y.mvp.data.Constant;
import com.example.y.mvp.utils.ActivityCollector;
import com.example.y.mvp.utils.RxUtil;
import com.example.y.mvp.utils.theme.SharedPreferencesMgr;
import com.socks.library.KLog;

/**
 * by y on 2016/4/28.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private static Context context;
    private static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(getLayoutId());
        initById();
        setStatusBar();
//        KLog.i(getClass().getSimpleName());
        ActivityCollector.addActivity(this);
    }

    protected void setStatusBar() {
    }

    protected abstract void initById();


    private void init() {
        context = getApplicationContext();
        activity = this;
        SharedPreferencesMgr.init(context);
        if (SharedPreferencesMgr.getInt() == Constant.DAY) {
            setTheme(R.style.Theme_Day);
        } else {
            setTheme(R.style.Theme_Night);
        }
        KLog.init(BuildConfig.LOG_DEBUG, Constant.K_LOG);
    }

    public static Context getContext() {
        return context;
    }

    public static Activity getActivity() {
        return activity;
    }

    <T extends View> T getView(int id) {
        //noinspection unchecked
        return (T) findViewById(id);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxUtil.unsubscribe();
    }

    protected abstract int getLayoutId();
}
