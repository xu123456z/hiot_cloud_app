package com.huatec.myapplication.activity;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.os.Bundle;
        import android.widget.BaseAdapter;
        import android.widget.LinearLayout;

        import com.huatec.myapplication.R;
        import com.huatec.myapplication.adapter.BasicAdapter;

        import java.util.ArrayList;
        import java.util.List;

public class BasicListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_list);
        //实验1.3开始

        //RecycleView
        RecyclerView rvBasic_List = findViewById(R.id.rv_basic_list);
        rvBasic_List.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvBasic_List.setLayoutManager(linearLayoutManager);

        //初始化列表数据，设置适配器
        List<String> srcList = new ArrayList<>();
        for (int i =0; i<100; i++){
            srcList.add("第" + (i + 1) + "行");
        }
        BasicAdapter basicAdapter = new BasicAdapter(this,srcList);
        rvBasic_List.setAdapter(basicAdapter);

    //实验1.3结束

    }
}
