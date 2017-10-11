package com.numerus.numberapp.di.modules;

import android.app.Application;
import android.content.Context;

import com.numerus.numberapp.NumerusApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kiran.kumar on 10/11/17.
 */

@Module
public class ApplicationModule {

    public ApplicationModule(NumerusApp app){
        this.app = app;
    }

    @Provides
    @Singleton
    Context provideAppContext() {
        return this.app;
    }


    private final NumerusApp app;
}
