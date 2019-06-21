package com.example.player.a1610aplayerdemo.ui.mastercourse;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.MasterDateBean;
import com.example.player.a1610aplayerdemo.net.MVPObserver;
import com.example.player.a1610aplayerdemo.net.MyNetFunction;
import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.ui.mastercourse.masterpresenter.MasterInterface;
import com.example.player.a1610aplayerdemo.util.DeviceKye;
import com.facebook.drawee.view.SimpleDraweeView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class MasterActivity extends AppCompatActivity {

    MasterInterface.IMasterPresenter presenter;
    private TextView tuijianTitle;
    private SimpleDraweeView dashikeTouxiang;
    private TextView dashikeRen;
    private TextView dashikeCourseName;
    private TabLayout dashikeTab;
    private ViewPager dashikeVpg;
    private TextView dashikeJiaqian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

        Intent intent = getIntent();
        String id = intent.getStringExtra("dashikeId");


        initView();

        getMasterData(id);

    }

    public void fanhui(View view) {
        finish();
    }





    private void  getMasterData(String s) {
        Map<String, String> map = new HashMap<>();
        map.put("liveId", s);

        Map headmap = new HashMap<>();
        headmap.put("deviceKey", DeviceKye.getDeviceKye());

        RetrofitCreator.getApiService().getMasterDate(headmap,map)
                .subscribeOn(Schedulers.io())
                .map(new MyNetFunction<ResEntity<MasterDateBean>,MasterDateBean>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MVPObserver<MasterDateBean>(){
                    @Override
                    public void onNext(MasterDateBean vipDateBean) {
                        super.onNext(vipDateBean);

                        iviv(vipDateBean);

                    }
                });
    }

    private void iviv(MasterDateBean vipDateBean) {
        tuijianTitle.setText(vipDateBean.getRoomTitle());

    }


    private void initView() {

        tuijianTitle = (TextView) findViewById(R.id.tuijian_title);
        dashikeTouxiang = (SimpleDraweeView) findViewById(R.id.dashike_touxiang);
        dashikeRen = (TextView) findViewById(R.id.dashike_ren);
        dashikeCourseName = (TextView) findViewById(R.id.dashike_courseName);
        dashikeTab = (TabLayout) findViewById(R.id.dashike_tab);
        dashikeVpg = (ViewPager) findViewById(R.id.dashike_vpg);
        dashikeJiaqian = (TextView) findViewById(R.id.dashike_jiaqian);
    }
}
