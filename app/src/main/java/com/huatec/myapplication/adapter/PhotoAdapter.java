package com.huatec.myapplication.adapter;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huatec.myapplication.R;
import com.huatec.myapplication.utils.ImageUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 图片列表适配器
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {
    private List<String> dataList = new ArrayList<>();
    private Context context;
    private OnItemClickListener onItemClickListener;

    public PhotoAdapter(Context context){
        this.context = context;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =  LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.adapter_item_photo,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.binData(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    /**
     * 传入列表数据
     * @param list
     */
    public void setData(List<String> list) {
    dataList.addAll(list);
    }

    /**
     * 获取列表数据
     * @return
     */
    public List<String> getData(){
        return dataList;
}

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivPhoto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.findViewById(R.id.iv_photo);
            ivPhoto = itemView.findViewById(R.id.iv_photo);
        }

        public void binData(int position) {
            String  url = dataList.get(position);
            ImageUtil.showByScale((Activity) context, ivPhoto, url );
        }
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;

    }

    /**
     * 点击接口
     */
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
}
