package com.numerus.numberapp.data.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by kiran.kumar on 10/10/17.
 */

@Singleton
public class NetworkUtil {
    @Inject
    NetworkUtil(Context context){
        this.connectivity = new Connectivity(context);
    }

    public boolean Update() {
        connectionFast = connectivity.isConnectedFast();
        return isConnectionFast();
    }

    public boolean isConnectionFast() {
        return connectionFast;
    }

    public boolean isConnected() {
        return connectivity.isConnected();
    }

    public static boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
        return (netInfo != null && netInfo.isConnected());
    }

    private final Connectivity connectivity;
    private boolean connectionFast = false;
}
