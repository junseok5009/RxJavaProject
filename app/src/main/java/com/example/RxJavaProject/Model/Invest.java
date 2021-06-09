package com.example.RxJavaProject.Model;

public class Invest {

    public Invest(String investSn, String expertId, String subject, String content, String regDttm){
        this.investSn = investSn;
        this.expertId = expertId;
        this.subject = subject;
        this.content = content;
        this.regDttm = regDttm;
    }

    private String investSn = "";
    private String expertId = "";
    private String subject = "";
    private String content = "";
    private String regDttm = "";

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId;
    }

    public String getExpertId() {
        return expertId;
    }

    public void setInvestSn(String investSn) {
        this.investSn = investSn;
    }

    public String getInvestSn() {
        return investSn;
    }

    public void setRegDttm(String regDttm) {
        this.regDttm = regDttm;
    }

    public String getRegDttm() {
        return regDttm;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

}
