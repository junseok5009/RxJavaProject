package com.example.testapp.ModelRxJava;

import com.google.gson.annotations.SerializedName;

public class Stock_RxJava {

    public Stock_RxJava(String stockCode, String stockName){
        this.stockCode = stockCode;
        this.stockName = stockName;
    }

    /*public Stock(String selectDiv, String stockCode, String stockName, String tradeFlag, String tradeDate, String tradeTime, String tradePrice, String profitRate,
                 String fluctuationRate, String elapsedDays, String includeDttm, String excluded, String analCount, String hasNewAnalYn, String qnaCount, String hasNewQnaYn){
        this.selectDiv = selectDiv;
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.tradeFlag = tradeFlag;
        this.tradeDate = tradeDate;
        this.tradeTime = tradeTime;
        this.tradePrice = tradePrice;
        this.profitRate = profitRate;
        this.fluctuationRate = fluctuationRate;
        this.elapsedDays = elapsedDays;
        this.includeDttm = includeDttm;
        this.excluded = excluded;
        this.analCount = analCount;
        this.hasNewAnalYn = hasNewAnalYn;
        this.qnaCount = qnaCount;
        this.hasNewQnaYn = hasNewQnaYn;
    }*/

    @SerializedName("selectDiv")
    private String selectDiv;
    @SerializedName("stockCode")
    private String stockCode;
    @SerializedName("stockName")
    private String stockName;
    @SerializedName("tradeFlag")
    private String tradeFlag;
    @SerializedName("tradeDate")
    private String tradeDate;
    @SerializedName("tradeTime")
    private String tradeTime;
    @SerializedName("tradePrice")
    private String tradePrice;
    @SerializedName("profitRate")
    private String profitRate;
    @SerializedName("fluctuationRate")
    private String fluctuationRate;
    @SerializedName("elapsedDays")
    private String elapsedDays;
    @SerializedName("includeDttm")
    private String includeDttm;
    @SerializedName("excluded")
    private String excluded;
    @SerializedName("analCount")
    private String analCount;
    @SerializedName("hasNewAnalYn")
    private String hasNewAnalYn;
    @SerializedName("qnaCount")
    private String qnaCount;
    @SerializedName("hasNewQnaYn")
    private String hasNewQnaYn;

    public String getSelectDiv() {
        return selectDiv;
    }

    public void setSelectDiv(String selectDiv) {
        this.selectDiv = selectDiv;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getTradeFlag() {
        return tradeFlag;
    }

    public void setTradeFlag(String tradeFlag) {
        this.tradeFlag = tradeFlag;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(String tradePrice) {
        this.tradePrice = tradePrice;
    }

    public String getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(String profitRate) {
        this.profitRate = profitRate;
    }

    public String getFluctuationRate() {
        return fluctuationRate;
    }

    public void setFluctuationRate(String fluctuationRate) {
        this.fluctuationRate = fluctuationRate;
    }

    public String getElapsedDays() {
        return elapsedDays;
    }

    public void setElapsedDays(String elapsedDays) {
        this.elapsedDays = elapsedDays;
    }

    public String getIncludeDttm() {
        return includeDttm;
    }

    public void setIncludeDttm(String includeDttm) {
        this.includeDttm = includeDttm;
    }

    public String getExcluded() {
        return excluded;
    }

    public void setExcluded(String excluded) {
        this.excluded = excluded;
    }

    public String getAnalCount() {
        return analCount;
    }

    public void setAnalCount(String analCount) {
        this.analCount = analCount;
    }

    public String getHasNewAnalYn() {
        return hasNewAnalYn;
    }

    public void setHasNewAnalYn(String hasNewAnalYn) {
        this.hasNewAnalYn = hasNewAnalYn;
    }

    public String getQnaCount() {
        return qnaCount;
    }

    public void setQnaCount(String qnaCount) {
        this.qnaCount = qnaCount;
    }

    public String getHasNewQnaYn() {
        return hasNewQnaYn;
    }

    public void setHasNewQnaYn(String hasNewQnaYn) {
        this.hasNewQnaYn = hasNewQnaYn;
    }

}
