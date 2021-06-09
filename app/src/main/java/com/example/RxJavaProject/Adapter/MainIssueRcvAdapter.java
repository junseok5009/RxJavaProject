package com.example.RxJavaProject.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.RxJavaProject.Interface.OnItemClickListener;
import com.example.RxJavaProject.Model.Stock;
import com.example.RxJavaProject.R;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

public class MainIssueRcvAdapter extends RecyclerView.Adapter<MainIssueRcvAdapter.ViewHolder> {

    private ArrayList<Stock> al_stock = new ArrayList<>();
    private OnItemClickListener<Stock> onItemClickListener;

    public MainIssueRcvAdapter(ArrayList<Stock> al_stock) {
        this.al_stock = al_stock;
    }

    public void setOnItemClickListener(OnItemClickListener<Stock> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public @NotNull ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_issue_rcv, parent, false));
    }

    @Override
    public void onBindViewHolder(MainIssueRcvAdapter.@NotNull ViewHolder holder, int position) {
        holder.onBind(al_stock.get(position));
        holder.itemView.setOnClickListener(v ->{
            if(onItemClickListener != null){
                onItemClickListener.onItemClick(position, al_stock.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return al_stock.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_text;

        public ViewHolder(View itemView){
            super(itemView);
            tv_text = itemView.findViewById(R.id.item_main_issue_rcv_tv);
        }

        private void onBind(Stock stock){
            tv_text.setText(stock.getStockName());
        }

    }

}
