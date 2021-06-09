package com.example.RxJavaProject.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.RxJavaProject.Adapter.MainIssueRcvAdapter;
import com.example.RxJavaProject.Adapter.MainVpRcvAdapter;
import com.example.RxJavaProject.Http.AsyncRequest;
import com.example.RxJavaProject.Http.IHttpHandler;
import com.example.RxJavaProject.Http.NetManager;
import com.example.RxJavaProject.Http.RHttpRequest;
import com.example.RxJavaProject.HttpRxJava.NetManager_RxJava;
import com.example.RxJavaProject.HttpRxJava.Services;
import com.example.RxJavaProject.Interface.INet;
import com.example.RxJavaProject.Model.Invest;
import com.example.RxJavaProject.Model.Issue;
import com.example.RxJavaProject.Model.News;
import com.example.RxJavaProject.Model.PortFolio;
import com.example.RxJavaProject.Model.Stock;
import com.example.RxJavaProject.ModelRxJava.ApiBase;
import com.example.RxJavaProject.ModelRxJava.Issue_RxJava;
import com.example.RxJavaProject.ModelRxJava.TR_ISSUEO3_RxJava;
import com.example.RxJavaProject.R;
import com.example.RxJavaProject.Util.Util;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static String logName = "junseok";

    private TextView tv_invest_title, tv_invest_more, tv_pfo_more,
            tv_invest_user_title, tv_invest_user_contents, tv_invest_user_date,
            tv_app_title, tv_issue_count;
    private ViewPager2 pfo_vp2;
    private HorizontalScrollView hs_issue;
    private LinearLayout ly_invest, ly_issue;

    private ArrayList<Invest> al_invest;
    private ArrayList<PortFolio> al_portfolio01;
    private ArrayList<PortFolio> al_portfolio05;
    private ArrayList<Issue> al_issue;

    private MainVpRcvAdapter mainVpRcvAdapter;

    private int pfo05_for_loop_count = 0, title_count = 0;

    private String strTR = "";
    private IHttpHandler onRespHandler = new IHttpHandler() {
        @Override
        public void onHttpResponse(String response) {

            try{

                Log.d("junseok Log", "onRespHandler onHttpResponse()");

                if(response!=null){

                    Log.d("junseok Log", "onRespHandler response!=null");
                    Log.d("junseok Log", "onRespHandler response : "+response);

                    JSONObject json = new JSONObject(response);
                    String retcode = json.get("retCode").toString();
                    String retMsg = json.get("retMsg").toString();

                    switch (strTR){

                        case INet.AD_INVEST01: {

                            Log.d("junseok Log", "onRespHandler AD_INVEST01");

                            if( retcode.equals("0000") && retMsg.equals("success") ){
                                init_AD_INVEST_01(json);
                                request_AD_PORT01();
                            }else{

                            }

                            break;
                        }

                        case INet.AD_PORT01: {
                            if( retcode.equals("0000") && retMsg.equals("success") ){
                                init_AD_PORT_01(json);
                                //request_AD_PORT05();
                            }else{

                            }

                            break;
                        }

                        case INet.AD_PORT05: {
                            if( retcode.equals("0000") && retMsg.equals("success") ){
                                init_AD_PORT_05(json);
                                pfo05_for_loop_count++;
                                if(pfo05_for_loop_count<al_portfolio01.size()){
                                    request_AD_PORT05(pfo05_for_loop_count);
                                }

                            }else{

                            }

                            break;
                        }

                        case INet.TR_ISSUE03: {

                            if(retcode.equals("0000") && retMsg.equals("success")){
                                init_ISSUE03(json);
                            }else{

                            }

                            break;
                        }

                    }

                }else{

                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        request_ISSUE03_RxJava();

        //request_AD_INVEST01_RXJAVA();

        AsyncRequest.init(this);

        setView();
        setAdapter();
        init();
        //setAdapter();

        SwipeRefreshLayout srl = findViewById(R.id.main_srl);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                new Handler().postDelayed(new Runnable() {// 1 초 후에 실행
                    @Override
                    public void run() {
                        // 실행할 동작 코딩

                        request_AD_INVEST01();
                        request_ISSUE03_RxJava();
                        srl.setRefreshing(false);

                    }
                }, 3000);
            }
        });



    }

    private void request_ISSUE03_RxJava(){
        Log.d("junseok Log", "request_ISSUE03_RxJava() start");
        JsonObject jsonObject = new JsonObject();
        try {
            jsonObject.addProperty("userId", "first_expert");
            jsonObject.addProperty("issueDate", "20210601");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Services services = NetManager_RxJava.getRxJavaRetrofit().create(Services.class);
        /*HttpRequestBodyRxJava requestBodyRxJava = new HttpRequestBodyRxJava();
        Observable<ApiBase<TR_ISSUEO3_RxJava>> observable = services.getObIssue03(requestBodyRxJava);*/

        Observable<ApiBase<TR_ISSUEO3_RxJava>> observable = services.getObIssue03(jsonObject);
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<ApiBase<TR_ISSUEO3_RxJava>>() {
                    @Override
                    public void onNext(ApiBase<TR_ISSUEO3_RxJava> issues) {

                        Log.d("junseok Log", "request_ISSUE03_RxJava() end");
                        TR_ISSUEO3_RxJava a = issues.getRetData();
                        ArrayList<Issue_RxJava> al_issue = a.getList_Issue();
                        Toast.makeText(getApplicationContext(), "RxJava issue title 0 : "+al_issue.get(0).getTitle(),Toast.LENGTH_SHORT).show();
                        for(Issue_RxJava item : al_issue){
                            Log.d("junseok Log", "request_ISSUE03_RxJava() item title : "+item.getTitle());
                        }
                    }

                    @Override
                    public void onError(@NotNull Throwable e) {
                        Log.d("junseok Log", "request_ISSUE03_RxJava() error e : "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("junseok Log", "request_ISSUE03_RxJava() onComplete");
                    }
                }));

    }

    private void setView(){
        tv_invest_title = findViewById(R.id.main_tv_invest_title);
        tv_invest_more = findViewById(R.id.main_tv_invest_more);
        tv_pfo_more = findViewById(R.id.main_tv_pfo_more);
        tv_invest_user_title = findViewById(R.id.main_tv_invest_user_title);
        tv_invest_user_contents = findViewById(R.id.main_tv_invest_user_contents);
        tv_invest_user_date = findViewById(R.id.main_tv_invest_user_date);
        tv_app_title = findViewById(R.id.main_tv_title);
        tv_issue_count = findViewById(R.id.main_tv_issue_count);

        pfo_vp2 = findViewById(R.id.main_pfo_vp2);

        hs_issue = findViewById(R.id.main_issue_hs);

        ly_invest = findViewById(R.id.main_ly_invest);
        ly_issue = findViewById(R.id.main_issue_ly);
    }

    private void init(){
        request_AD_INVEST01();
    }

    private void setAdapter(){

        tv_app_title.setOnClickListener(v -> {
            title_count ++;
            if(title_count == 5){
                title_count = 0;
                startActivity(new Intent(this, Test1Activity.class));
            }
        });

    }

    private void request_AD_INVEST01_RXJAVA(){

        JSONObject jsonObj = new JSONObject();

        Observable.fromCallable( ()-> {

            try{

                jsonObj.put("userId","first_expert");
                jsonObj.put("pageNo","0");
                jsonObj.put("pageItemSize", "3");

                strTR = INet.AD_INVEST01;

                NetManager manager = NetManager.getInstance();

                RHttpRequest httpRequest = new RHttpRequest(INet.API_BASE + strTR ,jsonObj.toString());

                Response response = manager.sendRequest(httpRequest.getmServiceUrl(), httpRequest.getmRequestData());
                if(response != null){

                    Log.d("junseok Log !!!!!! ", "request_AD_INVEST01_RXJAVA response1 : "+response.body().string());
                    return response;
                }else{
                    Log.d("junseok Log !!!!!! ", "request_AD_INVEST01_RXJAVA response is null ㅠㅠㅠㅠㅠㅠㅠㅠㅠ : ");
                }

            }catch (Exception e){
                e.printStackTrace();
            }
            return false;
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((response)->{
                    Log.d("junseok Log !!!!!! ", "request_AD_INVEST01_RXJAVA response2 : "+response.toString());
                });

    }

    private void request_AD_INVEST01(){
        JSONObject jsonObj = new JSONObject();
        try{

            jsonObj.put("userId","first_expert");
            jsonObj.put("pageNo","0");
            jsonObj.put("pageItemSize", "3");

            strTR = INet.AD_INVEST01;
            new AsyncRequest(onRespHandler).execute(new RHttpRequest( INet.API_BASE + strTR ,jsonObj.toString()));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void init_AD_INVEST_01(JSONObject jsonData) {
        Log.d("junseok Log", "init_AD_INVEST_05() ");
        try{

            if(al_invest==null) al_invest = new ArrayList<>();
            else al_invest.clear();
            ly_invest.removeAllViews();

            JSONArray retData = jsonData.getJSONArray("retData");
            for(int i=0; i<retData.length(); i++){
                JSONObject obj = retData.getJSONObject(i);
                al_invest.add(new Invest(
                        obj.optString("investSn"),
                        obj.optString("expertId"),
                        obj.optString("subject"),
                        obj.optString("content"),
                        obj.optString("regDttm")
                ));
            }

            Log.d("junseok Log", "init_AD_INVEST_05() al_invest size : "+al_invest.size());

            for(int i=0; i<al_invest.size(); i++){

                if(i==0){
                    Invest firstInvest = al_invest.get(i);
                    tv_invest_title.setText(getString(R.string.str_main_user_invest_title,firstInvest.getExpertId()));
                    tv_invest_user_title.setText(firstInvest.getSubject());
                    tv_invest_user_contents.setText(firstInvest.getContent());
                    tv_invest_user_date.setText(firstInvest.getRegDttm());
                }else{
                    Invest invest = al_invest.get(i);
                    View view = LayoutInflater.from(this).inflate(R.layout.item_main_invest_rest, null, false);
                    ((TextView)view.findViewById(R.id.item_main_invest_tv_time)).setText(invest.getRegDttm());
                    ((TextView)view.findViewById(R.id.item_main_invest_tv_contents)).setText(invest.getSubject());
                    ly_invest.addView(view);
                }
            }

        }catch (JSONException e){
            e.printStackTrace();
        }

    }

    private void request_AD_PORT01(){
        JSONObject jsonObj = new JSONObject();
        try{

            jsonObj.put("userId","first_expert");

            strTR = INet.AD_PORT01;
            new AsyncRequest(onRespHandler).execute(new RHttpRequest( INet.API_BASE + strTR ,jsonObj.toString()));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void init_AD_PORT_01(JSONObject jsonData) {
        Log.d("junseok Log", "init_AD_PORT_01() ");
        try{

            if(al_portfolio01==null) al_portfolio01 = new ArrayList<>();
            else al_portfolio01.clear();

            JSONArray retData = jsonData.getJSONArray("retData");
            for(int i=0; i<retData.length(); i++){
                JSONObject obj = retData.getJSONObject(i);
                al_portfolio01.add(new PortFolio(
                        obj.optString("portSn"),
                        obj.optString("portName"),
                        obj.optString("viewSeq")
                ));
            }

            finish_init_AD_PORT_01();

        }catch (JSONException e){
            e.printStackTrace();
        }

    }

    private void finish_init_AD_PORT_01(){
        request_AD_PORT05(pfo05_for_loop_count);
    }

    private void request_AD_PORT05(int i){

        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("userId", "first_expert");
            jsonObj.put("expertId", "first_expert");
            jsonObj.put("portSn", al_portfolio01.get(i).getPortSn());
            jsonObj.put("selectDiv", "ALL");
            strTR = INet.AD_PORT05;
            new AsyncRequest(onRespHandler).execute(new RHttpRequest(INet.API_BASE + strTR, jsonObj.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init_AD_PORT_05(JSONObject jsonData) {

        try{

            if(al_portfolio05==null) al_portfolio05 = new ArrayList<>();

            JSONObject retData = jsonData.getJSONObject("retData");

            ArrayList<News> al_inner_news = new ArrayList<>();
            JSONArray listNews = retData.optJSONArray("list_News");
            if(listNews != null){
                for(int i=0; i<listNews.length(); i++){
                    JSONObject obj = listNews.getJSONObject(i);
                    String str_issueDttm = obj.optString("issueDttm");
                    String str_content =  obj.optString("content");
                    if(str_issueDttm.equals("")){
                        str_issueDttm = "empty issueDttm ";
                    }
                    if (str_content.equals("")){
                        str_content = "empty content ";
                    }
                    al_inner_news.add(new News(str_issueDttm, str_content));
                }
                if(listNews.length()==0){
                    String str_issueDttm = "empty issueDttm ";
                    String str_content = "empty content ";
                    al_inner_news.add(new News(str_issueDttm, str_content));
                }
            }

            JSONArray listStock = retData.optJSONArray("list_Stock");
            ArrayList<Stock> al_inner_stock = new ArrayList<>();
            if(listStock != null){
                for(int i=0; i<listStock.length(); i++){
                    JSONObject objStock = listStock.getJSONObject(i);
                    al_inner_stock.add(new Stock(
                            objStock.optString("selectDiv"),
                            objStock.optString("stockCode"),
                            objStock.optString("stockName"),
                            objStock.optString("tradeFlag"),
                            objStock.optString("tradeDate"),
                            objStock.optString("tradeTime"),
                            objStock.optString("tradePrice"),
                            objStock.optString("profitRate"),
                            objStock.optString("fluctuationRate"),
                            objStock.optString("elapsedDays"),
                            objStock.optString("includeDttm"),
                            objStock.optString("excluded"),
                            objStock.optString("analCount"),
                            objStock.optString("hasNewAnalYn"),
                            objStock.optString("qnaCount"),
                            objStock.optString("hasNewQnaYn")
                    ));
                }
            }

            al_portfolio05.add(new PortFolio(
                    retData.optString("portSn"),
                    retData.optString("portName"),
                    retData.optString("viewSeq"),
                    retData.optString("operDate"),
                    retData.optString("updateDttm"),
                    retData.optString("holdCount"),
                    retData.optString("waitCount"),
                    retData.optString("groupList"),
                    al_inner_news,
                    al_inner_stock
            ));

        }catch (JSONException e){
            e.printStackTrace();
        }

        if(pfo05_for_loop_count == al_portfolio01.size()-1){
            mainVpRcvAdapter = new MainVpRcvAdapter(this, al_portfolio05);
            pfo_vp2.setAdapter(mainVpRcvAdapter);
            finish_Port05();
        }

    }

    private void finish_Port05(){
        request_ISSUE03();
    }

    private void request_ISSUE03(){
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("userId", "first_expert");
            jsonObj.put("issueDate", Util.changeSystemToYYYYMMDD()
            );
            strTR = INet.TR_ISSUE03;
            new AsyncRequest(onRespHandler).execute(new RHttpRequest(INet.API_BASE + strTR, jsonObj.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init_ISSUE03(JSONObject jsonData){

        try {

            if(al_issue==null) al_issue = new ArrayList<>();
            else al_issue.clear();

            JSONObject retData = jsonData.getJSONObject("retData");
            JSONArray json_listIssue = retData.getJSONArray("list_Issue");
            for(int i=0; i<json_listIssue.length();i++){
                JSONObject json_issue = json_listIssue.getJSONObject(i);
                JSONArray json_listStock = json_issue.getJSONArray("list_Stock");

                ArrayList<Stock> al_stock = new ArrayList<>();
                for(int k=0; k<json_listStock.length(); k++) {
                    JSONObject json_stock = json_listStock.getJSONObject(k);
                    al_stock.add(new Stock(
                            json_stock.optString("stockCode"),
                            json_stock.optString("stockName")
                    ));
                }

                al_issue.add(new Issue(
                    json_issue.optString("newsSn"),
                        json_issue.optString("issueDttm"),
                        json_issue.optString("title"),
                        json_issue.optString("content"),
                        json_issue.optString("issueSn"),
                        json_issue.optString("keyword"),
                        json_issue.optString("imageUrl"),
                        al_stock
                ));

                View view = LayoutInflater.from(this).inflate(R.layout.item_main_issue, null, false);
                ((TextView)view.findViewById(R.id.fm_main_issue_tv_keyword)).setText(json_issue.optString("keyword"));
                ((TextView)view.findViewById(R.id.fm_main_issue_tv_title)).setText(json_issue.optString("title"));
                ((TextView)view.findViewById(R.id.fm_main_issue_tv_contents)).setText(json_issue.optString("content"));
                RecyclerView issue_rcv = view.findViewById(R.id.fm_main_issue_tv_rcv);
                MainIssueRcvAdapter adapter = new MainIssueRcvAdapter(al_stock);
                adapter.setOnItemClickListener((position, stock) -> {
                    Toast.makeText(this, "p : "+position+" / name : "+stock.getStockName(), Toast.LENGTH_SHORT).show();
                });
                issue_rcv.setAdapter(adapter);
                ly_issue.addView(view);
            }

            tv_issue_count.setText(getString(R.string.str_main_issue_count,al_issue.size()));

        }catch (Exception e){
            e.printStackTrace();
        }


    }

}