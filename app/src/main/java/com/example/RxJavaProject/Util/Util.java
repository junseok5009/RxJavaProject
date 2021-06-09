package com.example.RxJavaProject.Util;

import com.example.RxJavaProject.ModelRxJava.ApiBase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Response;


public class Util {

    public static String pfoSelectDivToKorea(String stockDivCode){
        String result = "";
        switch (stockDivCode){
            case "ALL": result = "전체 종목";
                break;
            case "HOLD": result = "보유 종목";
                break;
            case "WAIT": result = "관망 종목";
                break;
            case "EXC": result = "제외 종목";
                break;
        }

        return result;
    }

    public static String stockTradeFlagToKorea(String stockTradeFlag){
        String result = "";
        switch (stockTradeFlag){
            case "B": result = "보유중";
                break;
            case "S": result = "관망중";
                break;
            default: {
                result = "stockTradeFlag UnFounded";
                break;
            }
        }

        return result;
    }

    public static String changeSystemToYYYYMMDD(){
        String result = "";

        long now = System.currentTimeMillis();
        Date mdate = new Date(now);
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        result = simpleDate.format(mdate);

        return result;
    }

    public static <T>Boolean retrofitCheck(Response<ApiBase<T>> response){

        // 1. body null check
        if(response == null)
            return false;
        if(response.body()==null)
            return false;
        if(response.body().getRetData() == null)
            return false;

        // 2. response retCode, retMsg check
        if(response.body().getRetCode().equals("0000") && response.body().getRetMsg().equals("success")){
            return true;
        }else{
            return false;
        }
    }

}
