package com.example.RxJavaProject.Http;

import okhttp3.RequestBody;

public class RHttpRequest {

    private String mServiceUrl = "";
    private String mRequestData = "";
    private RequestBody mRequestBody;

    public RHttpRequest(String serviceUrl, String requestData) {
        mServiceUrl = serviceUrl;
        mRequestData = requestData;
    }

    public RHttpRequest(String serviceUrl, RequestBody requestBody) {
        mServiceUrl = serviceUrl;
        mRequestBody = requestBody;
    }

    public void setmServiceUrl(String mServiceUrl) {
        this.mServiceUrl = mServiceUrl;
    }

    public String getmServiceUrl() {
        return mServiceUrl;
    }

    public void setmRequestData(String mRequestData) {
        this.mRequestData = mRequestData;
    }

    public String getmRequestData() {
        return mRequestData;
    }

    public void setmRequestBody(RequestBody mRequestBody) {
        this.mRequestBody = mRequestBody;
    }

    public RequestBody getmRequestBody() {

        return mRequestBody;
    }

}
