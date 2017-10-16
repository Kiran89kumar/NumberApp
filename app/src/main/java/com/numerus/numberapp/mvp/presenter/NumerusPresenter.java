package com.numerus.numberapp.mvp.presenter;

import android.util.Log;

import com.numerus.numberapp.data.api.NumberApi;
import com.numerus.numberapp.mvp.IPresenter;
import com.numerus.numberapp.mvp.view.NumerusView;
import com.numerus.numberapp.util.RxUtils;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by kiran.kumar on 10/12/17.
 */

public class NumerusPresenter implements IPresenter{

    @Inject
    NumerusPresenter(NumberApi numberApi){
        this.numberApi = numberApi;
    }

    public void init(NumerusView numerusView){
        this.numerusView = numerusView;
        if (subscriptions == null) {
            subscriptions = RxUtils.getNewCompositeSubscription(subscriptions);
        }
    }

    public void getFacts(String data, String category){
        Log.d("Presenter","Get facts: "+data+"---"+category);
        numerusView.showLoading();
        Observable<ResponseBody> factsObservable = numberApi.getFats(data,category);
        Subscription subscription = factsObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {
                        numerusView.hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("Presenter", "Error occured :"+e.getMessage());
                        numerusView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try{
                            if(numerusView!=null){
                                numerusView.render(responseBody.string());
                            }
                        }catch (IOException e){

                        }
                    }
                });
        subscriptions.add(subscription);
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.numerusView = null;
        if(subscriptions!=null && subscriptions.hasSubscriptions()){
            subscriptions.unsubscribe();
            subscriptions = null;
        }
    }

    private CompositeSubscription subscriptions = new CompositeSubscription();
    private NumberApi numberApi;
    private NumerusView numerusView;
}
