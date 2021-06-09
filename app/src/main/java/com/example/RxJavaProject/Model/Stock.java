package com.example.RxJavaProject.Model;

public class Stock {

    public Stock(String stockCode, String stockName){
        this.stockCode = stockCode;
        this.stockName = stockName;
    }

    public Stock(String selectDiv, String stockCode, String stockName, String tradeFlag, String tradeDate, String tradeTime, String tradePrice, String profitRate,
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
    }

    private String selectDiv = "";
    private String stockCode = "";
    private String stockName = "";
    private String tradeFlag = "";
    private String tradeDate = "";
    private String tradeTime = "";
    private String tradePrice = "";
    private String profitRate = "";
    private String fluctuationRate = "";
    private String elapsedDays = "";
    private String includeDttm = "";
    private String excluded = "";
    private String analCount = "";
    private String hasNewAnalYn = "";
    private String qnaCount = "";
    private String hasNewQnaYn = "";

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
