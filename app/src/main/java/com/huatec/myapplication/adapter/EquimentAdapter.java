package com.huatec.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huatec.myapplication.R;
import com.huatec.myapplication.model.EquimentBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 一下都是实验1.3的内容
 */

/**
 * 设备适配器
 */
public class EquimentAdapter extends RecyclerView.Adapter<EquimentAdapter.ViewHolder> {

    private Context context;
    private List<EquimentBean> dataList = new ArrayList<>();
    private OnItemClickListener onItemClickListener;
    public EquimentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //创建ItemView
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.adapter_item_equiment ,parent, false);

        //创建ViewHolder
        return new EquimentAdapter.ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.binData(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EquimentBean bean = dataList.get(position);
                onItemClickListener.onClickLisener(bean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    /**
     * 设置列表
     * @param list
     */
    public void setData(List<EquimentBean> list) {
        dataList.addAll(list);
    }
//    public interface OnItemClickListener{
//        void onItemClick(EquimentBean bean);
//    }
    private TextView tvTitle;
    private TextView tvDesc;
    private ImageView ivTest;
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            ivTest = itemView.findViewById(R.id.iv_test);
        }

        /**
         * 修改列表项内容
         * @param position
         */
        public void binData(int position) {
           EquimentBean bean = dataList.get(position);
           tvTitle.setText(bean.getTitle());
           tvDesc.setText(bean.getDescription());
           ivTest.setImageResource(bean.getImgId());
        }
    }

    /**
     * 点击事件接口
     */
    public interface OnItemClickListener{
        void onClickLisener(EquimentBean bean);
    }

    /**
     * 提供点击事件相关接口
     * @param onItemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener)
    {
        this.onItemClickListener = onItemClickListener;

    }
}
