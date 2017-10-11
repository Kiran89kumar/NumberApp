package com.numerus.numberapp.ui.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.numerus.numberapp.NumerusApp;
import com.numerus.numberapp.di.HasComponent;
import com.numerus.numberapp.di.components.ActivityComponent;
import com.numerus.numberapp.di.components.ApplicationComponent;
import com.numerus.numberapp.di.components.InjectableComponent;
import com.numerus.numberapp.di.modules.ActivityModule;

/**
 * Created by kiran.kumar on 10/11/17.
 */

public abstract class BaseActivity<C extends InjectableComponent> extends AppCompatActivity implements HasComponent<C> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initiateComponent();
    }

    final void initiateComponent() {
        activityComponent =
                createComponent(getApplicationComponent()
                        .plus(new ActivityModule(this)));
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((NumerusApp) getApplication()).getAppComponent();
    }

    protected abstract C createComponent(ActivityComponent activityComponent);

    @Override
    public final C getComponent() {
        return activityComponent;
    }

    private C activityComponent;
}

