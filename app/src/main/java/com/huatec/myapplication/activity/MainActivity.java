package com.huatec.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.huatec.myapplication.R;
import com.huatec.myapplication.adapter.PhotoAdapter;
import com.huatec.myapplication.utils.Constants;
import com.huatec.myapplication.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


//        private TextView tvTest;

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //实验1.3开始

//            Button btBasicList = findViewById(R.id.bt_basic_list);
//            Button btEquimentList = findViewById(R.id.bt_equiment_list);
//            btBasicList.setOnClickListener(new View.OnClickListener() {
//               @Override
//               public void onClick(View v) {
//                    Intent intent = new Intent(MainActivity.this,BasicListActivity.class);
//                    startActivity(intent);
//               }
//           });
//           //设置设备列表点击事件
//         btEquimentList.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,EquiqmentListActivity.class);
//                startActivity(intent);
//            }
//        });
            //实验1.3结束

            //实验1.4开始

            Button btnLogout = findViewById(R.id.btn_logout);

            btnLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //保存状态
                    SharedPreferencesUtil.getInstance(MainActivity.this).setLogin(false);
                    //打开登录界面，关闭本界面
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            });

            //Recycleview的编写
            RecyclerView rvPhoto = findViewById(R.id.rv_photo);
            rvPhoto.setHasFixedSize(true);
            StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
            rvPhoto.setLayoutManager(layoutManager);

            //初始化模拟图片数据
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 30; i++ )
            {
                list.add(String.format("http://dev-courses-misuc.ixuea.com/detail-recyclerview/%d.jpg",i));
            }

            //创建adapter适配器
            final PhotoAdapter photoAdapter = new PhotoAdapter(this);
            photoAdapter.setData(list);
            photoAdapter.setOnItemClickListener(new PhotoAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    Intent intent = new Intent(MainActivity.this, PhotoDetailActivity.class);
                    String url = photoAdapter.getData().get(position);
                    intent.putExtra(Constants.INSET_EXTRAL_PHOTO_URL, url);
                    startActivity(intent);
                }
            });
            rvPhoto.setAdapter(photoAdapter);

            //实验1.4结束




//            try{
//        tvTest = findViewById(R.id.tv_test);
//        Button btTest = findViewById(R.id.bt_test);
////        final EditText etTest = findViewById(R.id.et_test);
//        final TextView tvTest1 = findViewById(R.id.tv_test1);
//        final TextView tvTest2 = findViewById(R.id.tv_test2);
//
//
//
//        btTest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                tvTest.setText("邱敏");
//                tvTest.setTextColor(Color.parseColor("#FF6600"));
//                tvTest.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);
//                tvTest1.setText("17物联网工程一班");
//                tvTest1.setTextColor(Color.parseColor("#00FF00"));
//                tvTest1.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);
//                tvTest2.setText("09");
//                tvTest2.setTextColor(Color.parseColor("#0000FF"));
//                tvTest2.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);
//            }
//        });
//        //复选框
//        CheckBox cbBlue = findViewById(R.id.cb_blue);
//        CheckBox cbRed = findViewById(R.id.cb_red);
//        //单选框
//        RadioGroup rgTest = findViewById(R.id.rg_test);
//        RadioButton rbWomen = findViewById(R.id.rb_man);
//        RadioButton rbMan = findViewById(R.id.rb_women);
//
//        //switch and togglebutton
//
//        Switch swTest = findViewById(R.id.sw_test);
//        ToggleButton tbTest = findViewById(R.id.tb_test);

        //log.d  logca日志

//        Log.d("tag1", "degug1");
//        Log.d("tag2", "debug2");
////        View.OnClickListener testListener = new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
////                startActivity(intent);
////                tvTest.setText("我喜欢安卓");
////                Toast.makeText(MainActivity.this, etTest.getText().toString(), Toast.LENGTH_SHORT).show();
////            }
////        };
//
//        //添加复选框事件
//        //复选框--红色 监听器
//        cbBlue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Toast.makeText(MainActivity.this, buttonView.getText().toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        //复选框--红色 监听器
//        cbRed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Toast.makeText(MainActivity.this, buttonView.getText().toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
////        btTest.setOnClickListener(testListener);
//        //单选框--男生 监听器
//        rgTest.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                Toast.makeText(MainActivity.this, "test RadioButton man", Toast.LENGTH_SHORT).show();
//            }
//        });
//        //单选框--女生 监听器
//        rgTest.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                Toast.makeText(MainActivity.this, "test RadioButton women", Toast.LENGTH_SHORT).show();
//            }
//        });
//        //switch监听器
//        swTest.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Toast.makeText(MainActivity.this, buttonView.getText(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        //toggleButton 监听器
//        tbTest.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Toast.makeText(MainActivity.this, buttonView.getText(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }catch (Exception e){
//                Log.e("tag", e.getMessage());
//            }
    }



//    public void onClick(View v){
//            tvTest.setText("学号");
//    }
//    public  void onClick2(View v){
//        tvTest.setText("我也喜欢安卓！" );
//        test1();
//        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
//        startActivity(intent);
//    }

           ;
    }




