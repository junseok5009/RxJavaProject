package com.example.RxJavaProject.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.RxJavaProject.Fragment.FragmentMainMember;
import com.example.RxJavaProject.Fragment.FragmentMainNotice;
import com.example.RxJavaProject.Fragment.FragmentMainPfo;

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
