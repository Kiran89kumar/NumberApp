package com.numerus.numberapp.di.components;

import com.numerus.numberapp.di.PerActivity;
import com.numerus.numberapp.di.modules.NumerusModule;
import com.numerus.numberapp.ui.activity.NumerusActivity;

import dagger.Subcomponent;

/**
 * Created by kiran.kumar on 10/11/17.
 */

@PerActivity
@Subcomponent(modules = NumerusModule.class)
public interface NumerusActivityComponent extends InjectableComponent{

    void inject(NumerusActivity numerusActivity);

}
