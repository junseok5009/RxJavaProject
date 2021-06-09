package com.example.testapp.Adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.testapp.Fragment.FragmentMainMember;
import com.example.testapp.Fragment.FragmentMainNotice;
import com.example.testapp.Fragment.FragmentMainPfo;
import com.example.testapp.Http.IHttpHandler;

import org.jetbrains.annotations.NotNull;

import java.util.PropertyPermission;

public class MainVpAdapter extends FragmentStateAdapter {

    public MainVpAdapter(FragmentActivity fm){
        super(fm);
    }

    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0 : return new FragmentMainMember();
            case 1 : return new FragmentMainPfo();
            case 2 : return new FragmentMainNotice();
            default: return null;
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
