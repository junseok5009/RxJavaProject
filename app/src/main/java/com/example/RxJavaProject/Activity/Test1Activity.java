package com.example.RxJavaProject.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.RxJavaProject.HttpRxJava.NetManager_RxJava;
import com.example.RxJavaProject.HttpRxJava.Services;
import com.example.RxJavaProject.ModelRxJava.ApiBase;
import com.example.RxJavaProject.ModelRxJava.Issue_RxJava;
import com.example.RxJavaProject.ModelRxJava.TR_ISSUEO3_RxJava;
import com.example.RxJavaProject.R;
import com.example.RxJavaProject.Util.Util;
import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Test1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        request_ISSUE03_Retrofit_OkHttp();
        request_ISSUE03_RxJava();



    }

    private void request_ISSUE03_Retrofit_OkHttp(){
        Log.d("junseok Log", "request_ISSUE03_Retrofit_OkHttp() start");
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("userId", "first_expert");
            jsonObj.put("issueDate", "0");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Call<ApiBase<TR_ISSUEO3_RxJava>> result = NetManager_RxJava.getRetrofit().create(Services.class).getCallIssue03(jsonObj);

        result.enqueue(new Callback<ApiBase<TR_ISSUEO3_RxJava>>() {
            @Override
            public void onResponse(@NotNull Call<ApiBase<TR_ISSUEO3_RxJava>> call, retrofit2.@NotNull Response<ApiBase<TR_ISSUEO3_RxJava>> response) {
                if(response.isSuccessful() && Util.retrofitCheck(response)){
                    Log.d("junseok Log", "request_ISSUE03_Retrofit_OkHttp() end");
                    ArrayList<Issue_RxJava> al_issue_rj = response.body().getRetData().getList_Issue();
                    for(int i=0; i<al_issue_rj.size(); i++){
                        Log.d("junseok Log", "request_ISSUE03_Retrofit_OkHttp() i : "+i+" title : "+al_issue_rj.get(i).getTitle());
                    }

                }else{

                }
            }

            @Override
            public void onFailure(Call<ApiBase<TR_ISSUEO3_RxJava>> call, Throwable t) {

            }

        });
    }

    private void request_ISSUE03_RxJava(){
        Log.d("junseok Log", "request_ISSUE03_RxJava() start");
        JsonObject jsonObj = new JsonObject();
        try {
            jsonObj.addProperty("userId", "first_expert");
            jsonObj.addProperty("issueDate","20210601");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("junseok Log", "request_ISSUE03_RxJava() json : "+jsonObj.toString());
        Services services = NetManager_RxJava.getRxJavaRetrofit().create(Services.class);
        Observable<ApiBase<TR_ISSUEO3_RxJava>> observable = services.getObIssue03(jsonObj);

        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(new DisposableObserver<ApiBase<TR_ISSUEO3_RxJava>>() {
                @Override
                public void onNext(@NotNull ApiBase<TR_ISSUEO3_RxJava> issues) {
                    Log.d("junseok Log", "request_ISSUE03_RxJava() end");
                    TR_ISSUEO3_RxJava a = issues.getRetData();
                    ArrayList<Issue_RxJava> al_issue = a.getList_Issue();
                    for(Issue_RxJava item : al_issue){
                        Log.d("junseok Log", "request_ISSUE03_RxJava() item title : "+item.getTitle());
                    }
                }

                @Override
                public void onError(@NotNull Throwable e) {
                    Log.d("junseok Log", "request_ISSUE03_RxJava() error e : "+e.getMessage());
                }

                @Override
                public void onComplete() {
                    Log.d("junseok Log", "request_ISSUE03_RxJava() onComplete");
                }
            }));

    }

}