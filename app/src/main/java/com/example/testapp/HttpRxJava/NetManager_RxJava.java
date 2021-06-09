package com.example.testapp.HttpRxJava;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetManager_RxJava {

    private static OkHttpClient client;

    public static Retrofit getRetrofit(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .cache(null)
                .build();
        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder()
                .baseUrl(Services.API_BASE)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
    }

    public static Retrofit getRxJavaRetrofit(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .cache(null)
                .build();
        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .baseUrl(Services.API_BASE)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
    }

}
