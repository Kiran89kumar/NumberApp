package com.numerus.numberapp.di.modules;

import java.io.IOException;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by kiran.kumar on 10/12/17.
 */

@Module
public class HttpModule {

    @Provides
    Interceptor provideNetworkInterceptor() {
        //For Debug
        //return new StethoInterceptor();
        return NOOP;
    }

    @Provides
    @Named("LOGGING")
    Interceptor provideLoggingInterceptor() {
        //For Debug
        /*HttpLoggingInterceptor httpLoggingInterceptor =
                new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        Ln.d("HTTP", message);
                    }
                });
        httpLoggingInterceptor.setLevel(BuildConfig.DEBUG ? HEADERS : NONE);
        return httpLoggingInterceptor;*/

        return NOOP;
    }

    private static class NoOpInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            return chain.proceed(chain.request());
        }
    }

    private static NoOpInterceptor NOOP = new NoOpInterceptor();
}
