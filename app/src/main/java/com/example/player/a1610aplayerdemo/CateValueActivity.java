package com.example.player.a1610aplayerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import com.example.player.a1610aplayerdemo.cateactivity.fragment.MusicClassFragment;

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
        int flag = intent.getIntExtra(Content.CATE_FLAG, 0);
        Fragment currentFragment = new BlankFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.cateFragment,currentFragment).commit();
        if(flag == 0){
            currentFragment = new MusicClassFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.cateFragment,currentFragment).commit();
    }
}
