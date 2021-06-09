package com.example.testapp.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testapp.Http.IHttpHandler;
import com.example.testapp.R;

import org.jetbrains.annotations.NotNull;

public class FragmentMainMember extends Fragment {

    private Activity fragActivity;
    private Context fragContext;

    public FragmentMainMember() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        if(context instanceof Activity){
            fragActivity = (Activity) context;
        }
        fragContext = context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //View view = inflater.inflate(R.layout.fragment_main_member, container, false);
//        return inflater.inflate(R.layout.fragment_main_issue, container, false);
        return null;
    }



}

