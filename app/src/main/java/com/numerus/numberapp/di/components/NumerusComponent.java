package com.numerus.numberapp.di.components;

import com.numerus.numberapp.di.PerActivity;
import com.numerus.numberapp.di.modules.NumerusModule;
import com.numerus.numberapp.ui.fragment.NumerusFragment;

import dagger.Subcomponent;

/**
 * Created by kiran.kumar on 11/17/17.
 */

@PerActivity
@Subcomponent(modules = {NumerusModule.class})
public interface NumerusComponent {

    void inject(NumerusFragment numerusFragment);

}
