package com.numerus.numberapp.mvp.view;

/**
 * Created by kiran.kumar on 10/16/17.
 */

public interface LoadDataView {

    void showLoading();

    void hideLoading();

    void showError(String message);

}
