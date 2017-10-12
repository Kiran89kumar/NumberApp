package com.numerus.numberapp.di.components;

import android.content.Context;

import com.numerus.numberapp.di.modules.ActivityModule;
import com.numerus.numberapp.di.modules.ApplicationModule;
import com.numerus.numberapp.di.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by kiran.kumar on 10/11/17.
 */

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    Context context();

    final class Initializer {
        public static ApplicationComponent build(ApplicationModule applicationModule){
            return DaggerApplicationComponent.builder()
                    .applicationModule(applicationModule)
                    .build();
        }
    }

    ActivityComponent plus(ActivityModule activityModule);
}
