package com.numerus.numberapp.ui.activity;

import android.os.Bundle;

import com.numerus.numberapp.R;
import com.numerus.numberapp.di.components.ActivityComponent;
import com.numerus.numberapp.di.components.NumerusActivityComponent;

public class NumerusActivity extends BaseActivity<NumerusActivityComponent> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numerus);
    }

    @Override
    protected NumerusActivityComponent createComponent(ActivityComponent activityComponent) {
        NumerusActivityComponent component = activityComponent.plus();
        component.inject(this);
        return component;
    }
}
