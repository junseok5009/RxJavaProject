package com.example.testapp.Http;

import java.util.concurrent.TimeUnit;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NetManager {
    private static final MediaType TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
    private static final MediaType TYPE_TEXT = MediaType.parse("text/plain; charset=utf-8");

    private static NetManager instance;
    OkHttpClient client;

    private NetManager() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(10, TimeUnit.SECONDS);       //15초로 테스트 필요??
        builder.writeTimeout(10, TimeUnit.SECONDS);         //15초로 테스트 필요??
        builder.readTimeout(10, TimeUnit.SECONDS);          //30초 -> 10초 원복

        client = builder.build();
    }

    public static NetManager getInstance() {
        if(instance == null) {
            instance = new NetManager();
        }
        return instance;
    }

    public OkHttpClient getClient() {
        return client;
    }


    //POST & json
    public Response sendRequest(String serviceUrl, String json) throws Exception {

        Response response = null;
        RequestBody requestBody = RequestBody.create(TYPE_JSON, json);

        try {
            Request request = new Request.Builder()
                    .url(serviceUrl)
                    .post(requestBody)
                    .build();

            response = client.newCall(request).execute();

            Headers responseHeaders = response.headers();
            for (int i = 0; i < responseHeaders.size(); i++) {
                //TODO 헤더표시
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
}

