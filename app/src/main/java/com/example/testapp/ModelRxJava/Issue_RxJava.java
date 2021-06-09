package com.example.testapp.ModelRxJava;

import com.example.testapp.Model.Stock;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Issue_RxJava {

    @SerializedName("newsSn")
    private String newsSn;
    @SerializedName("issueDttm")
    private String issueDttm;
    @SerializedName("title")
    private String title;
    @SerializedName("content")
    private String content;
    @SerializedName("issueSn")
    private String issueSn;
    @SerializedName("keyword")
    private String keyword;
    @SerializedName("imageUrl")
    private String imageUrl;
    @SerializedName("list_Stock")
    private ArrayList<Stock_RxJava> listStock;

    //public Issue() { }

    /*public Issue_RxJava(String newsSn, String issueDttm, String title, String content, String issueSn,
                             String keyword, String imageUrl, ArrayList<Stock> listStock) {
        super();
        this.newsSn = newsSn;
        this.issueDttm = issueDttm;
        this.title = title;
        this.content = content;
        this.issueSn = issueSn;
        this.keyword = keyword;
        this.imageUrl = imageUrl;
        this.listStock = listStock;
    }*/

    public String getNewsSn() {
        return newsSn;
    }

    public void setNewsSn(String newsSn) {
        this.newsSn = newsSn;
    }

    public String getIssueDttm() {
        return issueDttm;
    }

    public void setIssueDttm(String issueDttm) {
        this.issueDttm = issueDttm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIssueSn() {
        return issueSn;
    }

    public void setIssueSn(String issueSn) {
        this.issueSn = issueSn;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ArrayList<Stock_RxJava> getListStock() {
        if(listStock==null) return new ArrayList<>();
        else return listStock;
    }

    public void setListStock(ArrayList<Stock_RxJava> listStock) {
        this.listStock = listStock;
    }

}
