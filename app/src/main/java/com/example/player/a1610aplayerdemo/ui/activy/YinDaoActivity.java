package com.example.player.a1610aplayerdemo.ui.activy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.player.a1610aplayerdemo.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class YinDaoActivity extends AppCompatActivity {

    SimpleDraweeView sm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yin_dao);
        sm = findViewById(R.id.yd_img);
        sm.setImageURI("http://ali-files.yooshow.com/2019/03/20/ecccd992-f2a7-4d33-a414-5348c34d28ab.png");

    }


    public void jump(View view) {

       // startActivity(new Intent(YinDaoActivity.this,MainActivity.class));
        startActivity(new Intent(YinDaoActivity.this,LoodingActivity.class));
    }
}
