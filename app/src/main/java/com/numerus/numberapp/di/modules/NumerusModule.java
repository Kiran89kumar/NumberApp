package com.numerus.numberapp.di.modules;

import com.numerus.numberapp.data.api.NumberApi;
import com.numerus.numberapp.di.PerActivity;
import com.numerus.numberapp.di.PerFragment;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

import static com.numerus.numberapp.util.Constant.BASE_URL;

/**
 * Created by kiran.kumar on 10/11/17.
 */

@Module
public class NumerusModule {

    @Provides
    @PerFragment
    NumberApi providesRestNumberApi(OkHttpClient client){
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(NumberApi.class);
    }
}
