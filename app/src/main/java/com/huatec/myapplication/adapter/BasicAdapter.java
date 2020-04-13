package com.huatec.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


/**
 * 以下都是实验1.3的内容
 */
public class BasicAdapter extends RecyclerView.Adapter<BasicAdapter.ViewHolder> {

    private Context context;
    private List<String> dataList = new ArrayList<>();
    public BasicAdapter(Context context, List<String> dataList) {
        this.context = context;
        this.dataList.addAll(dataList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //创建ItemView
       LayoutInflater inflater = LayoutInflater.from(context);
       View itemView = inflater.inflate(android.R.layout.simple_list_item_1,parent, false);

       //创建ViewHolder
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.binData(position);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private  TextView tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv =  itemView.findViewById(android.R.id.text1);
        }

        public void binData(int position) {
            String text = dataList.get(position);
            tv.setText(text);
        }
    }
}
