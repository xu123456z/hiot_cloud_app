package com.huatec.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.huatec.myapplication.R;
import com.huatec.myapplication.adapter.EquimentAdapter;
import com.huatec.myapplication.model.EquimentBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 以下为实验1.3的内容
 */
public class EquiqmentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equiqment_list);
        //recycleView 初始化
        RecyclerView rvEquiment = findViewById(R.id.rv_equiment);
        rvEquiment.setHasFixedSize(true);
        rvEquiment.setLayoutManager(new LinearLayoutManager(this));
        //


        //初始化列表数据，找到适配器
        List<EquimentBean> list = new ArrayList<>();
        for (int i = 0;i < 20; i++ )
        {
            EquimentBean equimentBean = new EquimentBean();
            equimentBean.setTitle("第" + (i + 1) +"个设备标题");
            equimentBean.setDescription("由于温度与湿度不管是从物理量本身还是在实际人们的生活中都有密切关系，所以温湿度一体的传感器就会相应产生。温湿度传感器是指能将温度量和湿度量转换成容易被测量处理的电信号的设备或装置。 市场上的温湿度传感器一般是测量温度量和相对湿度量。");
            if (i%2 == 1){
                equimentBean.setImgId(R.drawable.led);
            }
            else{
                equimentBean.setImgId(R.drawable.watch);
            }

            list.add(equimentBean);

        }
        //设置适配器
        EquimentAdapter equimentAdapter = new EquimentAdapter(this);
        equimentAdapter.setData(list);
       equimentAdapter.setOnItemClickListener(new EquimentAdapter.OnItemClickListener() {
           @Override
           public void onClickLisener(EquimentBean bean) {
               Toast.makeText(EquiqmentListActivity.this, bean.getTitle() + bean.getDescription(), Toast.LENGTH_SHORT).show();
           }
       });
       rvEquiment.setAdapter(equimentAdapter);
    }
}
