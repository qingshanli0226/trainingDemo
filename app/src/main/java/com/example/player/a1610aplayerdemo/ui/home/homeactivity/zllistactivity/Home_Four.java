package com.example.player.a1610aplayerdemo.ui.home.homeactivity.zllistactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.ui.home.homeactivity.zllistactivity.adapter.Home_Four_TabAdapter;
import com.example.player.a1610aplayerdemo.ui.home.homeactivity.zllistactivity.bean.ZlListBean;
import com.example.player.a1610aplayerdemo.ui.home.homeactivity.zllistactivity.fragment.Left_Fragment;
import com.example.player.a1610aplayerdemo.ui.home.homeactivity.zllistactivity.fragment.Right_Framgent;
import com.example.player.a1610aplayerdemo.ui.home.homeactivity.zllistactivity.presenter.HomeFourPeresenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Home_Four extends AppCompatActivity implements IBaseView {
    private IBasePresenter iBasePresenter;
    private TextView homefourtv;
    private ImageView homefourImage;
    private TabLayout homefourTb;
    private ViewPager homefourVp;
    private List<ZlListBean.DataBean> listdata = new ArrayList<>();
    private Home_Four_TabAdapter adapter;
    private List<Fragment> list = new ArrayList<>();
    private List<String> list1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home_four);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        iBasePresenter = new HomeFourPeresenter(id);
        iBasePresenter.attachView(this);
        iBasePresenter.getData();
        initView();
        data();
        adapter();
    }

        private void data(){
        list1.add("简介");
        list1.add("视频");
        list.add(new Left_Fragment());
        list.add(new Right_Framgent());
    }

    private void adapter(){
        adapter = new Home_Four_TabAdapter(getSupportFragmentManager(),list,list1);
        homefourTb.setupWithViewPager(homefourVp);
        homefourVp.setAdapter(adapter);

    }

    private void initView() {
        homefourtv = (TextView) findViewById(R.id.homefour_tv);
        homefourImage = (ImageView) findViewById(R.id.homefour_image);
        homefourTb = (TabLayout) findViewById(R.id.homefour_tb);
        homefourVp = (ViewPager) findViewById(R.id.homefour_vp);
    }

        @Override
        public void onLoadData(List data) {
            listdata.addAll(data);
            Picasso.get().load(listdata.get(0).getImage()).into(homefourImage);
            homefourtv.setText(listdata.get(0).getBarTitle());
        }

        @Override
        public void onLoadError(int code, String message) {
        }

    @Override
    public void onLoadObject(Object data) {

    }

    @Override
        protected void onDestroy() {
            super.onDestroy();
            iBasePresenter.detachView();
        }
}