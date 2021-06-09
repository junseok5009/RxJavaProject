package com.example.RxJavaProject.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.RxJavaProject.Activity.MainActivity;
import com.example.RxJavaProject.Adapter.FragmentMainPfoRcvAdapter;
import com.example.RxJavaProject.Http.IHttpHandler;
import com.example.RxJavaProject.R;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

public class FragmentMainPfo extends Fragment {

    private Activity fragActivity;
    private Context fragContext;
    private RecyclerView rcv;
    private FragmentMainPfoRcvAdapter adapter;
    private IHttpHandler onResponseHandler = new IHttpHandler() {
        @Override
        public void onHttpResponse(String response) {
            try{
                if(response != null){

                    JSONObject json = new JSONObject(response);
                    String retCode = json.get("retCode").toString();

                    if(retCode.equals("0000")){
                        Log.d("junseok log", "JSONObject : "+json);
                        Log.d("junseok log", "JSONObject to String : "+json.toString());

                        JSONArray retData = json.getJSONArray("retData");
                        Log.d("junseok log", "JSONArray retData : "+retData);
                        Log.d("junseok log", "JSONArray retData to string : "+retData.toString());

                    }


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public FragmentMainPfo() {}

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        Log.d(MainActivity.logName, "FragmentMainPfo onAttach");
        if(context instanceof Activity){
            fragActivity = (Activity) context;
        }
        fragContext = context;
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(MainActivity.logName, "FragmentMainPfo onCreate");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(MainActivity.logName, "FragmentMainPfo onResume");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(MainActivity.logName, "FragmentMainPfo onCreateView");
        View view = inflater.inflate(R.layout.fragment_main_pfo, container, false);
        setView(view);
        return view;
    }



    private void setView(View view){
        rcv = view.findViewById(R.id.fm_main_pfo_rcv);
        adapter = new FragmentMainPfoRcvAdapter();
    }





}


