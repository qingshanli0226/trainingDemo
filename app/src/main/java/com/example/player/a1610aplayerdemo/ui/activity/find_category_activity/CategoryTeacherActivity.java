package com.example.player.a1610aplayerdemo.ui.activity.find_category_activity;

import android.annotation.SuppressLint;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseActivity;
import com.example.player.a1610aplayerdemo.base.BasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.bean.TeacherTypeBean;
import com.example.player.a1610aplayerdemo.presenter.find_category_presenter.CategoryTeacherPresenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("Registered")
public class CategoryTeacherActivity extends BaseActivity implements IBaseView<String>{

    ImageView returnimg;
    TabLayout tabLayout;
    ViewPager viewPager;
    BasePresenter presenter;
    List<String> strlist;
    @Override
    public int getLayoutId() {
        return R.layout.category_teacher_activity;
    }

    @Override
    public void initData() {
        tabLayout = findViewById(R.id.teacher_tab);
        viewPager = findViewById(R.id.teacher_vp);
        returnimg = findViewById(R.id.return_img);
        presenter = new CategoryTeacherPresenter();
        presenter.attachView(this);
        presenter.getData();
    }

    @Override
    public void initListener() {
        returnimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onLoadDataBean(String data) {
        strlist = new ArrayList<>();
        Gson gson = new Gson();
        TeacherTypeBean teacherTypeBean = gson.fromJson(data, TeacherTypeBean.class);
        List<TeacherTypeBean.DataBean> data1 = teacherTypeBean.getData();
        tabLayout.addTab(new TabLayout.Tab().setText("综合"));
        tabLayout.addTab(new TabLayout.Tab().setText("证书查询"));
        strlist.add("综合");
        strlist.add("证书查询");
        for (int i = 0;i<data1.size();i++){
            tabLayout.addTab(new TabLayout.Tab().setText(data1.get(i).getShortName()));
            strlist.add(data1.get(i).getShortName());

        }
//        TeacherViewPagerAdapter adapter = new TeacherViewPagerAdapter(getSupportFragmentManager(),);


    }

    @Override
    public void onLoadError(int code, String message) {

    }
}
