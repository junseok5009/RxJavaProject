package com.example.testapp.HttpRxJava;

import com.example.testapp.ModelRxJava.ApiBase;
import com.example.testapp.ModelRxJava.TR_ISSUEO3_RxJava;

import org.json.JSONObject;


import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Services {

    String API_BASE = "https:/rassiappdev.thinkpool.com:56620/rassi_and/";

    @POST("TR_ISSUE03")
    Call<ApiBase<TR_ISSUEO3_RxJava>> getCallIssue03(@Body JSONObject jsonObject);

    @POST("TR_ISSUE03")
    Observable<ApiBase<TR_ISSUEO3_RxJava>> getObIssue03(@Body JSONObject jsonObject);

}
