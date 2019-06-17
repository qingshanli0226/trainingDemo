package com.example.player.a1610aplayerdemo.cateactivity.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import com.example.player.a1610aplayerdemo.BlankFragment;
import com.example.player.a1610aplayerdemo.Content;
import com.example.player.a1610aplayerdemo.R;

public class CateValueActivity extends AppCompatActivity {

    private FrameLayout cateFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cate_value);
        initView();
    }

    private void initView() {
        Intent intent = getIntent();
        int flag = intent.getIntExtra(Content.CATE_FLAG_VALUE, 0);
        Fragment currentFragment = new BlankFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.cateFragment,currentFragment).commit();
        if(flag == 0){
            currentFragment = new MusicClassFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.cateFragment,currentFragment).commit();
    }
}
