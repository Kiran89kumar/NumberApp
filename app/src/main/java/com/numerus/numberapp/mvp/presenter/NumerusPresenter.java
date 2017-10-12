package com.numerus.numberapp.mvp.presenter;

import com.numerus.numberapp.data.api.NumberApi;
import com.numerus.numberapp.mvp.view.NumerusView;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Response;
import okhttp3.ResponseBody;
import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by kiran.kumar on 10/12/17.
 */

public class NumerusPresenter {

    @Inject
    NumerusPresenter(NumberApi numberApi){
        this.numberApi = numberApi;
    }

    public void init(NumerusView numerusView){
        this.numerusView = numerusView;
    }

    public void getFacts(String category){
        Observable<ResponseBody> factsObservable = numberApi.getRandomCategory(category.toLowerCase());
        factsObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try{
                            if(numerusView!=null){
                                numerusView.render(responseBody.string());
                            }
                        }catch (IOException e){

                        }

                    }
                });
    }

    private NumberApi numberApi;
    private NumerusView numerusView;
}
