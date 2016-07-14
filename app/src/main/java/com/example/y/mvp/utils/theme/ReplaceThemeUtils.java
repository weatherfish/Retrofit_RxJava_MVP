package com.example.y.mvp.utils.theme;

import android.animation.Animator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;

import com.example.y.mvp.R;
import com.example.y.mvp.data.Constant;

/**
 * by y on 2016/6/16.
 */
public class ReplaceThemeUtils {


    private static View view;
    private static Bitmap localBitmap;
    private static View localView;

    public static void theme(final Activity activity, ThemeInterface themeInterface) {
        if (SharedPreferencesMgr.getInt() == Constant.NIGHT) {
            activity.setTheme(R.style.Theme_Day);
            themeInterface.setDay();
            SharedPreferencesMgr.setInt(Constant.DAY);
        } else {
            activity.setTheme(R.style.Theme_Night);
            themeInterface.setNight();
            SharedPreferencesMgr.setInt(Constant.NIGHT);
        }
        view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache(true);
        localBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);

        if (null != localBitmap && view instanceof ViewGroup) {
            localView = new View(activity);
            localView.setBackgroundDrawable(new BitmapDrawable(activity.getResources(), localBitmap));

            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            ((ViewGroup) view).addView(localView, params);

            localView.animate().alpha(0).setDuration(300).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    ThemeUIUtils.changeTheme(view, activity.getTheme());
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    ((ViewGroup) view).removeView(localView);
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
            ThemeUIUtils.changeTheme(view, activity.getTheme());
        }

    }

    public interface ThemeInterface {
        void setDay();

        void setNight();
    }
}
