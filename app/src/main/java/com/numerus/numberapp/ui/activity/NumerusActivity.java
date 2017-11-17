package com.numerus.numberapp.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import com.numerus.numberapp.di.components.ActivityComponent;
import com.numerus.numberapp.di.components.NumerusActivityComponent;
import com.numerus.numberapp.ui.activity.base.SimpleActivity;
import com.numerus.numberapp.ui.fragment.NumerusFragment;

public class NumerusActivity extends SimpleActivity<ActivityComponent> {

    @Override
    protected ActivityComponent createComponent(ActivityComponent activityComponent) {
        /*NumerusActivityComponent component = activityComponent.plus();
        component.inject(this);*/
        activityComponent.inject(this);
        return activityComponent;
    }

    @NonNull
    @Override
    protected Fragment getFragment() {
        return NumerusFragment.newInstance();
    }

    @Override
    protected void readBundle(@NonNull Bundle args) {

    }
}
