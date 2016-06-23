package com.example.y.mvp.utils.theme;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;

/**
 * by y on 2016/6/16.
 */
@SuppressWarnings("ALL")
public class ThemeUIUtils {

    /**
     * 切换应用主题
     */
    public static void changeTheme(View rootView, Resources.Theme theme) {
        if (rootView instanceof ThemeUIInterface) {
            ((ThemeUIInterface) rootView).setTheme(theme);
            if (rootView instanceof ViewGroup) {
                int count = ((ViewGroup) rootView).getChildCount();
                for (int i = 0; i < count; i++) {
                    changeTheme(((ViewGroup) rootView).getChildAt(i), theme);
                }
            }
        } else {
            if (rootView instanceof ViewGroup) {
                int count = ((ViewGroup) rootView).getChildCount();
                for (int i = 0; i < count; i++) {
                    changeTheme(((ViewGroup) rootView).getChildAt(i), theme);
                }
            }
        }
    }

}
