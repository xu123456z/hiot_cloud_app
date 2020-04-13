package com.huatec.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.huatec.myapplication.R;
import com.huatec.myapplication.utils.Constants;
import com.huatec.myapplication.utils.ImageUtil;

public class PhotoDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);
        //接受传递过来的图片URL，并显示
        String url = getIntent().getStringExtra(Constants.INSET_EXTRAL_PHOTO_URL);
        ImageView pvPhotodetail =findViewById(R.id.pv_photo_detail);
        ImageUtil.show(this, pvPhotodetail, url);
    }
}
