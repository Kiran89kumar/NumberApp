package com.numerus.numberapp.data.rest.http;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by kiran.kumar on 10/10/17.
 */

public class HeaderInterceptor implements Interceptor {

    public HeaderInterceptor() {

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(chain.request());
    }
}
