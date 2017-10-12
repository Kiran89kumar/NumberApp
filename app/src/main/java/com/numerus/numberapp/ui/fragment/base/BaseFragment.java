package com.numerus.numberapp.ui.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.numerus.numberapp.di.HasComponent;

/**
 * Created by kiran.kumar on 10/12/17.
 */

public abstract class BaseFragment extends Fragment{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected final <T> T getComponent(Class<T> componenentType) {
        return componenentType.cast(((HasComponent<T>) getActivity()).getComponent());
    }
}
