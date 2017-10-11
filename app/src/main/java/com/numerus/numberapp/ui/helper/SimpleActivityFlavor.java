package com.numerus.numberapp.ui.helper;

import android.support.annotation.LayoutRes;

import com.numerus.numberapp.R;

/**
 * Created by kiran.kumar on 10/11/17.
 */

public class SimpleActivityFlavor extends ActivityFlavor {

    public static SimpleActivityFlavor basic(@LayoutRes int layoutId) {
        return new SimpleActivityFlavor(layoutId)
                .setFragmentId(R.id.fl_content);
    }

    protected SimpleActivityFlavor(@LayoutRes int layoutId) {
        super(layoutId);
    }

    public SimpleActivityFlavor setFragmentId(int containerId) {
        this.fragmentId = containerId;
        return this;
    }

    public int getFragmentId() {
        return fragmentId;
    }

    private int fragmentId;
}
