package com.numerus.numberapp;

import android.app.Application;

import com.numerus.numberapp.di.components.ApplicationComponent;
import com.numerus.numberapp.di.components.DaggerApplicationComponent;
import com.numerus.numberapp.di.modules.ApplicationModule;

/**
 * Created by kiran.kumar on 10/10/17.
 */

public class NumerusApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        buildComponents();
    }

    private void buildComponents() {
        this.appComponent = DaggerApplicationComponent.Initializer
                                .build(getApplicationModule());
    }

    public ApplicationComponent getAppComponent(){
        return appComponent;
    }

    ApplicationModule getApplicationModule() {
        if (applicationModule == null) {
            applicationModule = new ApplicationModule(this);
        }
        return applicationModule;
    }

    private ApplicationComponent appComponent;
    private ApplicationModule applicationModule;
}
