package com.numerus.numberapp.ui.activity.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.numerus.numberapp.R;
import com.numerus.numberapp.di.components.InjectableComponent;
import com.numerus.numberapp.ui.helper.ActivityFlavor;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by kiran.kumar on 10/11/17.
 */

public abstract class BorrowingActivity<F extends ActivityFlavor, C extends InjectableComponent>
        extends BaseActivity<C> {

    protected BorrowingActivity(F flavor){
        this.flavor = flavor;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(flavor.getLayoutId());
        unbinder = ButterKnife.bind(this);
        initActivity();
    }

    private void initActivity() {
        Bundle args = getIntent().getExtras();
        if (args != null) {
            readBundle(args);
        }
        enhanceLayout();
    }

    @CallSuper
    protected void enhanceLayout() {

    }

    @Override
    @CallSuper
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

    protected abstract void readBundle(@NonNull Bundle args);

    protected final F getFlavor() {
        return flavor;
    }

    protected final String TAG = getClass().getSimpleName();

    private Unbinder unbinder;
    private final F flavor;
}
