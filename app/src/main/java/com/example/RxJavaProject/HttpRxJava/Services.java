package com.example.RxJavaProject.HttpRxJava;

import com.example.RxJavaProject.ModelRxJava.ApiBase;
import com.example.RxJavaProject.ModelRxJava.TR_ISSUEO3_RxJava;
import com.google.gson.JsonObject;

import org.json.JSONObject;


import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Services {

    String API_BASE = "https:/rassiappdev.thinkpool.com:56620/rassi_and/";

    @POST("TR_ISSUE03")
    Call<ApiBase<TR_ISSUEO3_RxJava>> getCallIssue03(@Body JSONObject jsonObject);

    @Headers({"Content-type: application/json"})
    @POST("TR_ISSUE03")
    Observable<ApiBase<TR_ISSUEO3_RxJava>> getObIssue03(@Body JsonObject jsonObject);


}
