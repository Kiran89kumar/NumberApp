package com.numerus.numberapp.data.api;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by kiran.kumar on 10/10/17.
 */

public interface NumberApi {

    @GET("{path}/{category}")
    Observable<ResponseBody> getFats(@Path(value = "path", encoded = true) String path,
                                     @Path(value = "category", encoded = true) String category);

}
