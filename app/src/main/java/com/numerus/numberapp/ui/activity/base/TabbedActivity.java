package com.numerus.numberapp.ui.activity.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.numerus.numberapp.R;
import com.numerus.numberapp.di.components.InjectableComponent;
import com.numerus.numberapp.ui.adapter.BaseTabAdapter;
import com.numerus.numberapp.ui.helper.TabbedActivityFlavor;

import butterknife.BindView;

/**
 * Created by kiran.kumar on 10/11/17.
 */

public abstract class TabbedActivity<C extends InjectableComponent> extends BorrowingActivity<TabbedActivityFlavor, C> {

    protected TabbedActivity(TabbedActivityFlavor flavor) {
        super(flavor);
    }

    @CallSuper
    @Override
    protected void enhanceLayout() {
        super.enhanceLayout();
        baseTabAdapter = createAdapter();
        setupViewPager(baseTabAdapter);
    }

    @Override
    @CallSuper
    protected void readBundle(@NonNull Bundle args) {
        selectedTab = args.getInt(ARGS_SELECTED_TAB, 0);
    }

    protected abstract BaseTabAdapter createAdapter();

    private void setupViewPager(BaseTabAdapter adapter) {
        final TabbedActivityFlavor flavor = getFlavor();

        ViewPager.OnPageChangeListener listener = flavor.getViewPagerListener();
        if (null != listener) {
            viewPager.addOnPageChangeListener(listener);
        }

        viewPager.setOffscreenPageLimit(adapter.getCount());
        viewPager.setAdapter(adapter);
        if (flavor.hasTabs()) {
            tabLayout.setupWithViewPager(viewPager);
        }

        if (selectedTab > 0 && selectedTab < adapter.getCount()) {
            Log.d(TAG, "Navigating to tab: " + selectedTab);
            viewPager.setCurrentItem(selectedTab);
        }
    }

    public BaseTabAdapter getBaseTabAdapter() {
        return baseTabAdapter;
    }

    @Nullable
    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @BindView(R.id.vp_content)
    ViewPager viewPager;

    private BaseTabAdapter baseTabAdapter;
    private int selectedTab;
    public static final String ARGS_SELECTED_TAB = "args.tab.selected";
}
