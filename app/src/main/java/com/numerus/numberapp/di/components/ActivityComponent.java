package com.numerus.numberapp.di.components;

import com.numerus.numberapp.di.PerActivity;
import com.numerus.numberapp.di.modules.ActivityModule;
import com.numerus.numberapp.di.modules.NumerusModule;
import com.numerus.numberapp.ui.activity.NumerusActivity;

import dagger.Subcomponent;

/**
 * Created by kiran.kumar on 10/11/17.
 */

@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent extends InjectableComponent{

    /*NumerusActivityComponent plus();*/

    void inject(NumerusActivity numerusActivity);

    NumerusComponent plus(NumerusModule numerusModule);
}
