package com.example.y.mvp.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.y.mvp.BuildConfig;
import com.example.y.mvp.R;
import com.example.y.mvp.data.Constant;
import com.example.y.mvp.utils.ActivityCollector;
import com.example.y.mvp.utils.theme.SharedPreferencesMgr;
import com.socks.library.KLog;

import butterknife.ButterKnife;
import rx.Subscription;

/**
 * by y on 2016/4/28.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private static Context context;
    private static Activity activity;
    protected Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        KLog.i(getClass().getSimpleName());
        ActivityCollector.addActivity(this);
    }

    private void init() {
        context = getApplicationContext();
        activity = this;
        SharedPreferencesMgr.init(context);
        if (SharedPreferencesMgr.getInt() == 1) {
            setTheme(R.style.Theme_Night);
        } else {
            setTheme(R.style.Theme_Day);
        }
        KLog.init(BuildConfig.LOG_DEBUG, Constant.K_LOG);
    }

    public static Context getContext() {
        return context;
    }

    public static Activity getActivity() {
        return activity;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unsubscribe();
    }

    protected void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    protected abstract int getLayoutId();


}
