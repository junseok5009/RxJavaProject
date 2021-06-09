package com.example.testapp.Model;

import java.util.ArrayList;

public class PortFolio {

    public PortFolio(String portSn, String portName, String viewSeq){
        this.portSn = portSn;
        this.portName = portName;
        this.viewSeq = viewSeq;
    }

    public PortFolio(String portSn, String portName, String viewSeq, String operDate, String updateDttm,
                     String holdCount, String waitCount, String groupList, ArrayList<News> list_News, ArrayList<Stock> list_Stock){
        this.portSn = portSn;
        this.portName = portName;
        this.viewSeq = viewSeq;
        this.operDate = operDate;
        this.updateDttm = updateDttm;
        this.holdCount = holdCount;
        this.waitCount = waitCount;
        this.groupList = groupList;
        this.list_News = list_News;
        this.list_Stock = list_Stock;
    }

    private String portSn = "";
    private String portName = "";
    private String viewSeq = "";
    private String operDate = "";
    private String updateDttm = "";
    private String holdCount = "";
    private String waitCount = "";
    private String groupList = "";
    private ArrayList<News> list_News = new ArrayList<>();
    private ArrayList<Stock> list_Stock = new ArrayList<>();

    public String getPortSn() {
        return portSn;
    }

    public void setPortSn(String portSn) {
        this.portSn = portSn;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getViewSeq() {
        return viewSeq;
    }

    public void setViewSeq(String viewSeq) {
        this.viewSeq = viewSeq;
    }

    public String getOperDate() {
        return operDate;
    }

    public void setOperDate(String operDate) {
        this.operDate = operDate;
    }

    public String getUpdateDttm() {
        return updateDttm;
    }

    public void setUpdateDttm(String updateDttm) {
        this.updateDttm = updateDttm;
    }

    public String getHoldCount() {
        return holdCount;
    }

    public void setHoldCount(String holdCount) {
        this.holdCount = holdCount;
    }

    public String getWaitCount() {
        return waitCount;
    }

    public void setWaitCount(String waitCount) {
        this.waitCount = waitCount;
    }

    public String getGroupList() {
        return groupList;
    }

    public void setGroupList(String groupList) {
        this.groupList = groupList;
    }

    public void setList_News(ArrayList<News> list_News) {
        this.list_News = list_News;
    }

    public ArrayList<News> getList_News() {
        return list_News;
    }

    public void setList_Stock(ArrayList<Stock> list_Stock) {
        this.list_Stock = list_Stock;
    }

    public ArrayList<Stock> getList_Stock() {
        return list_Stock;
    }
}
