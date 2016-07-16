package com.example.y.mvp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.y.mvp.R;

import java.io.File;

/**
 * by y on 2016/4/29.
 */
@SuppressWarnings("ALL")
public class ActivityUtils {

    public static void startActivity(Class<?> clz) {
        Intent intent;
        intent = new Intent(UIUtils.getContext(), clz);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        UIUtils.getContext().startActivity(intent);
    }

    public static void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent(UIUtils.getContext(), clz);
        intent.putExtras(bundle);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        UIUtils.getContext().startActivity(intent);
    }


    //隐藏状态栏
    public static void hideStatusBar() {
        WindowManager.LayoutParams attrs = UIUtils.getActivity().getWindow().getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        UIUtils.getActivity().getWindow().setAttributes(attrs);
    }

    //显示状态栏
    public static void showStatusBar() {
        WindowManager.LayoutParams attrs = UIUtils.getActivity().getWindow().getAttributes();
        attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
        UIUtils.getActivity().getWindow().setAttributes(attrs);
    }

    private void initWindow() {
        //默认全屏显示
        UIUtils.getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        //不全屏显示
        UIUtils.getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        //全屏显示
        UIUtils.getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
    }

    public static void Toast(Object object) {
        Toast.makeText(UIUtils.getContext(), object + "", Toast.LENGTH_LONG).show();
    }


    // 收起软键盘
    public static void closeSyskeyBroad() {
        if (UIUtils.getContext() != null) {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) UIUtils.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(UIUtils.getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            } catch (Exception e) {
                Toast(UIUtils.getString(R.string.closeSyskeyBroad));
            }

        }
    }

    //检测键盘的状态
    public static boolean syskeyBroadStatus() {
        InputMethodManager imm = (InputMethodManager) UIUtils.getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        return imm.isActive();
    }

    //屏幕高度
    public static int getTop() {
        WindowManager windowManager = UIUtils.getActivity().getWindowManager();
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        return height;
    }

    //toolbar高度
    public static int getToolBarTop(Toolbar toolbar) {
        return toolbar.getTop();
    }


    //状态栏高度
    public static int getRectTop() {
        Rect outRect = new Rect();
        UIUtils.getActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(outRect);
        int i = outRect.top;
        return i;
    }

    //获取图库路径
    public static File ImagePath() {
        String sdcard = Environment.getExternalStorageDirectory().toString();
        File file = new File(sdcard + "/DCIM");
        if (!file.exists()) {
            file.mkdirs();
        }
        File mFile = new File(file + "/Demo");
        if (!mFile.exists()) {
            mFile.mkdirs();
        }
        return mFile.getAbsoluteFile();
    }

    //获取整个屏幕的截图
    public static Bitmap captureContent(ViewGroup viewGroup) {
        viewGroup.setDrawingCacheEnabled(false);
        viewGroup.setDrawingCacheEnabled(true);
        return viewGroup.getDrawingCache();
    }

    /**
     * 获得屏幕高度
     */
    public static int getScreenWidth() {
        WindowManager wm = (WindowManager) UIUtils.getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    /**
     * 获得屏幕宽度
     */
    public static int getScreenHeight() {
        WindowManager wm = (WindowManager) UIUtils.getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }


    /**
     * 获取当前屏幕截图，包含状态栏
     */
    public static Bitmap snapShotWithStatusBar() {
        View view = UIUtils.getActivity().getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, 0, getScreenWidth(), getScreenHeight());
        view.destroyDrawingCache();
        return bp;

    }


    /**
     * 截图
     */
    public static Bitmap captureContent(Activity activity) {
        //View是你需要截图的View
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap b1 = view.getDrawingCache();
        // 获取状态栏高度 /
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        // 获取屏幕长和高
        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        int height = activity.getWindowManager().getDefaultDisplay().getHeight();
        // 去掉标题栏
        Bitmap b = Bitmap.createBitmap(b1, 0, statusBarHeight, width, height - statusBarHeight);
        view.destroyDrawingCache();
        return b;
    }


    /**
     * 获取当前屏幕截图，不包含状态栏
     */
    public static Bitmap snapShotWithoutStatusBar() {
        View view = UIUtils.getActivity().getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        Rect frame = new Rect();
        UIUtils.getActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        Bitmap bp = null;
        bp = Bitmap.createBitmap(bmp, 0, statusBarHeight, getScreenWidth(), getScreenHeight() - statusBarHeight);
        view.destroyDrawingCache();
        return bp;
    }

    public static void share(String message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        UIUtils.getActivity().startActivity(Intent.createChooser(intent, UIUtils.getString(R.string.share)));
    }


}
