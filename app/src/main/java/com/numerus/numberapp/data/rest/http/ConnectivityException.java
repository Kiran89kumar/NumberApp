package com.numerus.numberapp.data.rest.http;

import java.io.IOException;

/**
 * Created by kiran.kumar on 10/10/17.
 */

public class ConnectivityException extends IOException {

    @Override
    public String getMessage() {
        return "No Internet Connection";
    }
}
