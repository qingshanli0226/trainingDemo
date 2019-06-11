package com.example.player.a1610aplayerdemo.ui.activy;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.ui.adapter.PageAdp;

import java.util.ArrayList;

public class LoodingActivity extends AppCompatActivity {

    Button button;
    RadioGroup rg;
    PageAdp adp;
    ViewPager viewPager;
    ArrayList<ImageView> list = new ArrayList<>();
    RadioButton rb1,rb2,rb3,rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looding);

        button = findViewById(R.id.xw);
        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        rb3=findViewById(R.id.rb3);
        rb4=findViewById(R.id.rb4);
        rg =findViewById(R.id.gp);

        viewPager = findViewById(R.id.loodvpg);
        addTp();


        adp = new PageAdp(LoodingActivity.this,list);
        viewPager.setAdapter(adp);


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                if (position==0){
                    button.setVisibility(View.GONE);
                    rb1.setChecked(true);
                }else if (position==1){
                    button.setVisibility(View.GONE);
                    rb2.setChecked(true);
                }else if (position==2){
                    button.setVisibility(View.GONE);
                    rb3.setChecked(true);
                }else if (position==3){
                    button.setVisibility(View.VISIBLE);
                    rb4.setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addTp() {

        ImageView i1 = new ImageView(LoodingActivity.this);
        ImageView i2 = new ImageView(LoodingActivity.this);
        ImageView i3 = new ImageView(LoodingActivity.this);
        ImageView i4 = new ImageView(LoodingActivity.this);

        i1.setImageResource(R.mipmap.tu2);
        i2.setImageResource(R.mipmap.tu3);
        i3.setImageResource(R.mipmap.tu4);
        i4.setImageResource(R.mipmap.zjgq1);

        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);

    }

    public void jinru(View view) {
        startActivity(new Intent(LoodingActivity.this,MainActivity.class));
    }
}
