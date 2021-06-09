package com.example.testapp.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Issue {

    private String newsSn;
    private String issueDttm;
    private String title;
    private String content;
    private String issueSn;
    private String keyword;
    private String imageUrl;
    private ArrayList<Stock> listStock = null;

    //public Issue() { }

    public Issue(String newsSn, String issueDttm, String title, String content, String issueSn,
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
    }

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

    public ArrayList<Stock> getListStock() {
        return listStock;
    }

    public void setListStock(ArrayList<Stock> listStock) {
        this.listStock = listStock;
    }

}
