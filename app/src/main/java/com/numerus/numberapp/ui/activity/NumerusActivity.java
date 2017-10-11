package com.numerus.numberapp.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.numerus.numberapp.di.components.ActivityComponent;
import com.numerus.numberapp.di.components.NumerusActivityComponent;
import com.numerus.numberapp.ui.activity.base.SimpleActivity;

public class NumerusActivity extends SimpleActivity<NumerusActivityComponent> {

    @Override
    protected NumerusActivityComponent createComponent(ActivityComponent activityComponent) {
        NumerusActivityComponent component = activityComponent.plus();
        component.inject(this);
        return component;
    }

    @NonNull
    @Override
    protected Fragment getFragment() {
        return new Fragment();
    }

    @Override
    protected void readBundle(@NonNull Bundle args) {

    }
}
