package com.example.RxJavaProject.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.RxJavaProject.R;


public class FragmentMainPfoRcvAdapter extends RecyclerView.Adapter<FragmentMainPfoRcvAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_pfo_rcv, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentMainPfoRcvAdapter.ViewHolder holder, int position) {
        holder.onBind();
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name, tv_Option, tv_manage;

        ViewHolder(View view){
            super(view);

            /*tv_name = view.findViewById(R.id.item_main_pfo_rcv_tv_name);
            tv_Option = view.findViewById(R.id.item_main_pfo_rcv_tv_option);
            tv_manage = view.findViewById(R.id.item_main_pfo_rcv_tv_manage);*/

        }

        private void onBind(){
            //setText
        }

    }

}
