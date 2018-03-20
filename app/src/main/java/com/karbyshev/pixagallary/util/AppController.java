package com.karbyshev.pixagallary.util;

import android.app.Application;

import com.karbyshev.pixagallary.api.PixabayApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vilen on 20.03.2018.
 */

public class AppController extends Application{
    private Retrofit retrofit;
    private static PixabayApi pixabayApi;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://pixabay.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        pixabayApi = retrofit.create(PixabayApi.class);
    }

    public static PixabayApi getApi(){
        return pixabayApi;
    }
}
