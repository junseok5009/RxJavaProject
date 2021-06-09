package com.example.testapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.Model.PortFolio;
import com.example.testapp.Model.Stock;
import com.example.testapp.R;
import com.example.testapp.Util.Util;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MainVpRcvAdapter extends RecyclerView.Adapter<MainVpRcvAdapter.ViewHolder> {

    private Activity activity;
    private ArrayList<PortFolio> al_portFolio = new ArrayList<>();

    public MainVpRcvAdapter(Activity activity, ArrayList<PortFolio> al_portFolio){
        this.activity = activity;
        this.al_portFolio = al_portFolio;
        Log.d("junseok Log", "MainVpRcvAdapter 생성자 al_pfo size : "+al_portFolio.size());
    }

    @Override
    public @NotNull ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_pfo_rcv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(holder != null){
            Log.d("junseok Log","onBindViewHolder "+holder.getItemId());
            holder.onBind(activity, al_portFolio.get(position));
        }

    }

    @Override
    public void onViewRecycled(@NonNull @NotNull MainVpRcvAdapter.ViewHolder holder) {
        super.onViewRecycled(holder);
        Log.d("junseok Log","onViewRecycled "+holder.getItemId());
    }

    @Override
    public int getItemCount() {
        return al_portFolio.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_title, tv_message;
        LinearLayout ly;

        ViewHolder(View itemView){
            super(itemView);
            tv_title = itemView.findViewById(R.id.item_main_pfo_rcv_tv_title);
            tv_message = itemView.findViewById(R.id.item_main_pfo_rcv_tv_message);
            ly = itemView.findViewById(R.id.item_main_pfo_rcv_ly);
        }

        private void onBind(Activity activity, PortFolio portFolio){
            ly.removeAllViews();
            tv_title.setText(portFolio.getPortName());
            if(portFolio.getList_News().size() != 0){
                if(!portFolio.getList_News().get(0).getIssueDttm().equals("") && !portFolio.getList_News().get(0).getContent().equals("")){
                    tv_message.setText(portFolio.getList_News().get(0).getIssueDttm() + portFolio.getList_News().get(0).getContent());
                    tv_message.setVisibility(View.VISIBLE);
                }else{
                    tv_message.setVisibility(View.GONE);
                }
            }else{
                tv_message.setVisibility(View.GONE);
            }


            int count = portFolio.getList_Stock().size();

            if(count>5){
                count = 5;
            }

            for(int i = 0; i<count; i++){

                Stock stock = portFolio.getList_Stock().get(i);
                View view = LayoutInflater.from(activity).inflate(R.layout.item_main_pfo_rcv_contents, null, false);

                ((TextView)view.findViewById(R.id.item_main_pfo_rcv_contents_tv_title)).setText(stock.getStockName());

                ((TextView)view.findViewById(R.id.item_main_pfo_rcv_contents_tv_contents1))
                        .setText(activity.getString(R.string.str_split_slash_three, stock.getTradeDate(), stock.getTradeTime(), stock.getFluctuationRate()));

                ((TextView)view.findViewById(R.id.item_main_pfo_rcv_contents_tv_contents2))
                        .setText(activity.getString(R.string.str_split_slash_two, Util.stockTradeFlagToKorea(stock.getTradeFlag()), stock.getProfitRate()));

                ly.addView(view);
            }

        }


    }

}
