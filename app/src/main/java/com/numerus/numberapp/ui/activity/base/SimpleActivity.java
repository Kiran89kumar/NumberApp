package com.numerus.numberapp.ui.activity.base;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

import com.numerus.numberapp.R;
import com.numerus.numberapp.di.components.InjectableComponent;
import com.numerus.numberapp.ui.helper.SimpleActivityFlavor;

/**
 * Created by kiran.kumar on 10/11/17.
 */

public abstract class SimpleActivity<C extends InjectableComponent> extends BorrowingActivity<SimpleActivityFlavor, C> {

    protected SimpleActivity(SimpleActivityFlavor flavor) {
        super(flavor);
    }

    protected SimpleActivity(@StringRes int titleId) {
        this(SimpleActivityFlavor
                .basic(R.layout.view_framelayout));
    }

    protected SimpleActivity() {
        this(SimpleActivityFlavor.basic(R.layout.view_framelayout));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState !=null)
            return;

        Fragment fragment = getFragment();
        if(fragment!=null){
            startFragment(fragment);
        }
    }

    protected abstract @NonNull Fragment getFragment();

    protected final void startFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .add(getFlavor().getFragmentId(), fragment)
                .commit();
    }

}
