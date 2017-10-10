package com.numerus.numberapp.data.api;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by kiran.kumar on 10/10/17.
 */

public interface NumberApi {

    @GET("random/{category}")
    Observable<Response<String>> getRandomCategory(@Path(value = "category", encoded = true) String category);

    @GET("{digitOrDate}/{category}")
    Observable<Response<String>> getDigitOrDateCategory(@Path(value = "digitOrDate", encoded = true) String digitOrDate,
                                                  @Path(value = "category", encoded = true) String category);
}
