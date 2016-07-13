package com.example.y.mvp.utils.theme;

import android.animation.Animator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;

import com.example.y.mvp.R;
import com.example.y.mvp.data.Constant;
import com.example.y.mvp.data.IsNightMode;
import com.example.y.mvp.network.RxBus;
import com.socks.library.KLog;

/**
 * by y on 2016/6/16.
 */
public class ReplaceThemeUtils {

    public static void theme(final Activity activity) {

        if (SharedPreferencesMgr.getInt() == 1) {

            SharedPreferencesMgr.setInt(Constant.THEME, 0);
            activity.setTheme(R.style.Theme_Day);

            RxBus.getInstance().sendTheme(new IsNightMode(true));

            SharedPreferencesMgr.setIsNight(true);

            KLog.i("colorUIUtils", "白天");
        } else {

            SharedPreferencesMgr.setInt(Constant.THEME, 1);
            activity.setTheme(R.style.Theme_Night);

            RxBus.getInstance().sendTheme(new IsNightMode(false));

            SharedPreferencesMgr.setIsNight(false);

            KLog.i("colorUIUtils", "夜晚");
        }
        final View rootView = activity.getWindow().getDecorView();
        rootView.setDrawingCacheEnabled(true);
        rootView.buildDrawingCache(true);
        final Bitmap localBitmap = Bitmap.createBitmap(rootView.getDrawingCache());
        rootView.setDrawingCacheEnabled(false);
        if (null != localBitmap && rootView instanceof ViewGroup) {
            final View localView2 = new View(activity);
            //noinspection deprecation
            localView2.setBackgroundDrawable(new BitmapDrawable(activity.getResources(), localBitmap));
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            ((ViewGroup) rootView).addView(localView2, params);
            localView2.animate().alpha(0).setDuration(400).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    ThemeUIUtils.changeTheme(rootView, activity.getTheme());
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    ((ViewGroup) rootView).removeView(localView2);
                    localBitmap.recycle();
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            }).start();
        } else {
            ThemeUIUtils.changeTheme(rootView, activity.getTheme());
        }
    }


}
