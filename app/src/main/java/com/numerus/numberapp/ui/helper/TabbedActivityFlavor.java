package com.numerus.numberapp.ui.helper;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.view.ViewPager;

/**
 * Created by kiran.kumar on 10/11/17.
 */

public class TabbedActivityFlavor extends ActivityFlavor {

    public static TabbedActivityFlavor basic(@LayoutRes int layoutId) {
        TabbedActivityFlavor tabbedActivityFlavor = new TabbedActivityFlavor(layoutId);
        tabbedActivityFlavor.setTabs(true);
        return tabbedActivityFlavor;
    }

    public static TabbedActivityFlavor without_tabs(@LayoutRes int layoutId) {
        TabbedActivityFlavor tabbedActivityFlavor = new TabbedActivityFlavor(layoutId);
        return tabbedActivityFlavor;
    }

    public TabbedActivityFlavor setTitleId(@StringRes int titleId) {
        super.setTitleId(titleId);
        return this;
    }

    protected TabbedActivityFlavor(@LayoutRes int layoutId) {
        super(layoutId);
    }

    public TabbedActivityFlavor setViewPagerListener(@NonNull ViewPager.OnPageChangeListener listener) {
        this.viewPagerListener = listener;
        return this;
    }

    @Nullable
    public ViewPager.OnPageChangeListener getViewPagerListener() {
        return viewPagerListener;
    }

    private ViewPager.OnPageChangeListener viewPagerListener;
}
