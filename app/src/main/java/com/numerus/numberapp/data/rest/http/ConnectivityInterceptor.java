package com.numerus.numberapp.data.rest.http;

import android.content.Context;

import com.numerus.numberapp.data.util.NetworkUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by kiran.kumar on 10/10/17.
 */

public class ConnectivityInterceptor implements Interceptor{

    private Context context;

    public ConnectivityInterceptor(Context context){
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (!NetworkUtil.isConnected(context)) {
            throw new ConnectivityException();
        }

        Request.Builder builder = chain.request().newBuilder();
        return chain.proceed(builder.build());
    }
}
