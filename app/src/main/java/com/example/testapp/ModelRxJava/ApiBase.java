package com.example.testapp.ModelRxJava;

import com.google.gson.annotations.SerializedName;

public class ApiBase<T> {

    /*{
        "trCode": "string",
        "retData": {
            데이터 { ~ } or [ ~ ]
        },
        "retCode": "0000",
        "retMsg": "success"
    }*/

    @SerializedName("trCode")
    private String trCode;

    @SerializedName("retData")
    private T retData;

    @SerializedName("retCode")
    private String retCode;

    @SerializedName("retMsg")
    private String retMsg;

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetData(T retData) {
        this.retData = retData;
    }

    public T getRetData() {
        return retData;
    }

    public void setTrCode(String trCode) {
        this.trCode = trCode;
    }

    public String getTrCode() {
        return trCode;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public String getRetMsg() {
        return retMsg;
    }

}
