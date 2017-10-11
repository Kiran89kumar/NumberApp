package com.numerus.numberapp.ui.activity;

import com.numerus.numberapp.R;
import com.numerus.numberapp.di.components.ActivityComponent;
import com.numerus.numberapp.di.components.NumerusActivityComponent;
import com.numerus.numberapp.ui.activity.base.TabbedActivity;
import com.numerus.numberapp.ui.adapter.BaseTabAdapter;
import com.numerus.numberapp.ui.adapter.NumerusTabAdapter;
import com.numerus.numberapp.ui.helper.TabbedActivityFlavor;

public class NumerusActivity extends TabbedActivity<NumerusActivityComponent> {

    public NumerusActivity() {
        super(TabbedActivityFlavor
                .basic(R.layout.activity_tab_fixed_with_viewpager)
                .setTitleId(R.string.app_name));
    }

    @Override
    protected NumerusActivityComponent createComponent(ActivityComponent activityComponent) {
        NumerusActivityComponent component = activityComponent.plus();
        component.inject(this);
        return component;
    }

    @Override
    protected BaseTabAdapter createAdapter() {
        return new NumerusTabAdapter(getSupportFragmentManager(), this);
    }
}
