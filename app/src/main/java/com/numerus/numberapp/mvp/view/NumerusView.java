package com.numerus.numberapp.mvp.view;

import android.util.Log;

/**
 * Created by kiran.kumar on 10/12/17.
 */

public interface NumerusView extends LoadDataView{

    void render(String facts);

    void toggleBasicOrAdvaceView(boolean isBasic);

    void toggleDigitOrDatePicker(boolean isDigit);

    void clearFacts();
}
