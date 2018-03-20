package com.karbyshev.pixagallary.api;

import com.karbyshev.pixagallary.model.PostModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by vilen on 20.03.2018.
 */

public interface PixabayApi {

    @GET("api")
    Call<PostModel> data(@QueryMap Map<String, String> parameter);
}
