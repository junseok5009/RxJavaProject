package com.example.testapp.Http;

import android.content.Context;
import android.os.AsyncTask;

import okhttp3.Response;

public class AsyncRequest extends AsyncTask<RHttpRequest, Void, String> {
    final String TAG = "[AsyncSendRequest]";

    public static NetManager manager = null;
    private IHttpHandler onRecevier;
    private String result = "";

    public static void init(Context context) {
        if(manager == null)
            manager = NetManager.getInstance();
    }

    public AsyncRequest(IHttpHandler recevier) {
        onRecevier = recevier;
    }

    @Override
    protected String doInBackground(RHttpRequest[] objects) {
        RHttpRequest httpRequest = objects[0];

        try {
            Response response = manager.sendRequest(httpRequest.getmServiceUrl(), httpRequest.getmRequestData());
            if(response != null) {
                result = response.body().string();  //string() 은 한번만 사용가능
            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String out) {
        onRecevier.onHttpResponse(result);
    }

}
