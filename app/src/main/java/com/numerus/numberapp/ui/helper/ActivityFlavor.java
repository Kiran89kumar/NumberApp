package com.numerus.numberapp.ui.helper;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.text.TextUtils;

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

    @CallSuper
    public ActivityFlavor setTitleId(@StringRes int titleId) {
        if (titleId > -1) {
            this.titleId = titleId;
            this.titleDesc = null;
        }
        return this;
    }

    @CallSuper
    public ActivityFlavor setTitle(@NonNull String title) {
        this.titleDesc = title;
        this.titleId = -1;
        return this;
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

    public String getTitle(@NonNull Context context) {
        String title;
        if (titleId > -1) {
            try {
                title = context.getResources().getString(titleId);
            } catch (Resources.NotFoundException ex) {
                title = "";
            }
        } else {
            title = TextUtils.isEmpty(titleDesc)? "" : titleDesc;
        }
        return title;
    }

    @StringRes private int titleId;
    private String titleDesc;
    @LayoutRes
    private final int layoutId;
    private boolean hasTabs;
}
