package com.numerus.numberapp.di.modules;

import android.content.Context;
import android.support.annotation.Nullable;

import com.numerus.numberapp.data.rest.http.HttpClientBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * Created by kiran.kumar on 10/12/17.
 */

@Module(includes = HttpModule.class)
public class NetworkModule {

    public NetworkModule(){

    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient(Context context, Interceptor networkInterceptor,
                                      @Named("LOGGING") Interceptor loggingInterceptor){
        return buildOkHttpClient(context, "NumApp", 50,networkInterceptor, loggingInterceptor);
    }

    private OkHttpClient buildOkHttpClient(Context context,
                                           String cacheName,
                                           int cacheSize,
                                           @Nullable Interceptor networkInterceptor,
                                           @Nullable Interceptor loggingInterceptor) {
        HttpClientBuilder builder =
                new HttpClientBuilder(context)
                        .setTimeouts(30)
                        .setCache(cacheName, cacheSize)
                        .setNetworkInterceptor(networkInterceptor)
                        .setLoggingInterceptor(loggingInterceptor)
                        .enableSocketLog(true);

        return builder.build();
    }
}
