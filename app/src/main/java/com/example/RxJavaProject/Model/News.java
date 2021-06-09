package com.example.RxJavaProject.Model;

public class News {

    public News(String issueDttm, String content){
        this.issueDttm = issueDttm;
        this.content = content;
    }

    private String issueDttm = "";
    private String content = "";

    public void setIssueDttm(String issueDttm) {
        this.issueDttm = issueDttm;
    }

    public String getIssueDttm() {
        return issueDttm;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
