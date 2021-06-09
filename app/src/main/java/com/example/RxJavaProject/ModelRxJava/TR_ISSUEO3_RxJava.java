package com.example.RxJavaProject.ModelRxJava;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TR_ISSUEO3_RxJava {

    @SerializedName("list_Issue")
    private ArrayList<Issue_RxJava> list_Issue;

    public ArrayList<Issue_RxJava> getList_Issue() {
        if(list_Issue==null) return new ArrayList<>();
        else return list_Issue;
    }

    public void setList_Issue(ArrayList<Issue_RxJava> list_Issue) {
        this.list_Issue = list_Issue;
    }
}
