package com.example.player.a1610aplayerdemo.ui.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.adapter.viewpager_adapter.ItemClickPagerAdapter;
import com.example.player.a1610aplayerdemo.base.BaseActivity;
import com.example.player.a1610aplayerdemo.base.BasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.bean.DetailBean2;
import com.example.player.a1610aplayerdemo.presenter.ItemClickPresenter;
import com.example.player.a1610aplayerdemo.ui.fragment.ItemClickFragment.KnowledgeFragment;
import com.example.player.a1610aplayerdemo.ui.fragment.ItemClickFragment.ListFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ItemClickActivity extends BaseActivity implements IBaseView<String> {

    BasePresenter presenter;
    private ImageView return_img;
    private ImageView click_Img;
    private TextView click_title;
    private SimpleDraweeView click_writerImg;
    private TextView click_writer;
    private TextView click_writerdata;
    private TextView click_className;
    private TabLayout click_tab;
    private ViewPager click_vp;
    private String dateType;
    private TextView vipprice;
    private TextView price;
    private Button bo;
    private List<String> strlist;
    private List<Fragment> frglist;

    @Override
    public int getLayoutId() {
        return R.layout.activity_itemclick;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public void initData() {
        return_img = findViewById(R.id.toolbar_img);
        click_title = findViewById(R.id.toolbar_title);
        click_writerImg = findViewById(R.id.click_writerImg);
        click_writer = findViewById(R.id.click_writer);
        click_writerdata = findViewById(R.id.click_writerdata);
        click_className = findViewById(R.id.click_className);
        click_Img = findViewById(R.id.click_img);
        click_vp = findViewById(R.id.click_vp);
        click_tab = findViewById(R.id.click_tab);
        vipprice = findViewById(R.id.click_vipprice);
        price = findViewById(R.id.click_price);
        bo =  findViewById(R.id.click_btn);
        Intent intent = getIntent();
        String dateId = intent.getStringExtra("dateId");
        dateType = intent.getStringExtra("dateType");
        presenter = new ItemClickPresenter(dateId, Integer.valueOf(dateType));
        presenter.attachView(this);
        presenter.getData();
    }

    @Override
    public void initListener() {
        return_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        bo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemClickActivity.this,VideoActivity.class);
                intent.putExtra("mp4url","http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f30.mp4");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onLoadDataBean(String data) {
        Gson gson = new Gson();
        DetailBean2 bean2 = gson.fromJson(data, DetailBean2.class);
        DetailBean2.DataBean data1 = bean2.getData();
        click_title.setText(data1.getName());
        Glide.with(this).load(data1.getImage()).into(click_Img);
        click_writerImg.setImageURI(data1.getTeacherAvatar());
        click_writer.setText(data1.getTeacherName());
        click_className.setText(data1.getCourseName());
        click_writerdata.setText(data1.getTeacherTitle());
        vipprice.setText("会员价"+data1.getCourseVipPrice()+"元(原价"+data1.getPriceText()+")");
        price.setText("原价"+data1.getPriceText());
        ItemClickPagerAdapter adapter = null;
        if (dateType.equals("2")){
            strlist  = new ArrayList<>();
            frglist  = new ArrayList<>();
            click_tab.addTab(click_tab.newTab().setText("本课知识"));
            click_tab.addTab(click_tab.newTab().setText("课时列表"));
            strlist.add("本课知识");
            strlist.add("课时列表");
            KnowledgeFragment knowledgeFragment = new KnowledgeFragment();
            knowledgeFragment.setDataBean(data1);
            frglist.add(knowledgeFragment);
            ListFragment listFragment = new ListFragment();
            listFragment.setDataBean(data1);
            frglist.add(listFragment);
            adapter  = new ItemClickPagerAdapter(getSupportFragmentManager(),strlist,frglist);
        }
        click_vp.setAdapter(adapter);
        click_tab.setupWithViewPager(click_vp);
    }

    @Override
    public void onLoadError(int code, String message) {

    }


}
