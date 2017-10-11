package com.numerus.numberapp.ui.helper;

import android.support.annotation.LayoutRes;

/**
 * Created by kiran.kumar on 10/11/17.
 */

public class ActivityFlavor {

    public static ActivityFlavor basic(@LayoutRes int layoutId) {
        return new ActivityFlavor(layoutId);
    }

    ActivityFlavor(@LayoutRes int layoutId) {
        this.layoutId = layoutId;
    }

    public @LayoutRes int getLayoutId() {
        return layoutId;
    }

    public boolean hasTabs() {
        return hasTabs;
    }

    public void setTabs(boolean hasTabs) {
        this.hasTabs = hasTabs;
    }

    @LayoutRes
    private final int layoutId;
    private boolean hasTabs;
}
