package com.numerus.numberapp.ui.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by kiran.kumar on 10/11/17.
 */

public abstract class BaseTabAdapter extends FragmentStatePagerAdapter{

    protected BaseTabAdapter(FragmentManager fm,
                             Context context,
                             int tabsResourceId) {
        this(fm,
                context,
                context.getResources().getStringArray(tabsResourceId));
    }

    protected BaseTabAdapter(FragmentManager fm,
                             Context context,
                             String[] tabs) {
        this(fm, context, tabs, null);
    }

    private BaseTabAdapter(FragmentManager fm,
                           Context context,
                           String[] tabs,
                           @Nullable String[] tabValues) {
        super(fm);
        this.context = context;
        this.tabs = tabs;
        this.tabValues = tabValues;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    private final Context context;
    private final String[] tabs;
    private final String[] tabValues;
    private final String TAG = getClass().getSimpleName();
}
