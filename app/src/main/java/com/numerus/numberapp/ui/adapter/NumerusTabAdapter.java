package com.numerus.numberapp.ui.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;

import com.numerus.numberapp.R;

/**
 * Created by kiran.kumar on 10/11/17.
 */

public class NumerusTabAdapter extends BaseTabAdapter {

    public NumerusTabAdapter(FragmentManager fm, Context context){
        super(fm, context, R.array.tabs);
        tabsValues = context.getResources().getStringArray(R.array.tabs);
    }

    @Override
    public Fragment getItem(int position) {
        return new Fragment();
    }

    private final String[] tabsValues;
}
