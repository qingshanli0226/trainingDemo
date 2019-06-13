package com.example.player.a1610aplayerdemo.fragment.selectclass.zl.zlvideoactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.fragment.selectclass.zl.zlvideoactivity.bean.ZlintroduceBean;
import com.example.player.a1610aplayerdemo.net.Contance;
import com.example.player.a1610aplayerdemo.net.NetFunction;
import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.token.SpUtils;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class ZLvideoActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tb_video_title;
    private TextView tb_back_tv;
    private ImageView zltitle_img;
    private TabLayout zl_tablayout;
    private ViewPager zl_vp;
private String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zlvideo);

        Intent intent = getIntent();
       id = intent.getStringExtra("id");
        Toast.makeText(this, ""+id, Toast.LENGTH_SHORT).show();

        initView();
        initData();
    }

    private void initData() {
        Map<String,String> headMap = new HashMap<>();
        String token = SpUtils.getSpUtils().getToken();
        if (token ==null){
            return;
        }
        headMap.put(Contance.CH_TOKEN,token);
        RetrofitCreator.getInstance().getRetrofitApiService()
                .getZlIntroDuce(headMap,id)
                .subscribeOn(Schedulers.io())
                .map(new NetFunction<ResEntity<ZlintroduceBean.DataBean>,ZlintroduceBean.DataBean>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZlintroduceBean.DataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ZlintroduceBean.DataBean dataBean) {
                        Log.i("aaa", "onNext: zldata"+dataBean.getBarTitle());
                         init(dataBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(ZLvideoActivity.this, ""+e.toString(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void init(ZlintroduceBean.DataBean dataBean) {
        tb_video_title.setText(dataBean.getBarTitle());
        Glide.with(this).load(dataBean.getImage()).placeholder(R.drawable.gray_radius).into(zltitle_img);
    }

    private void initView() {
        tb_video_title = (TextView) findViewById(R.id.tb_video_title);
        tb_back_tv = (TextView) findViewById(R.id.tb_back_tv);
        zltitle_img = (ImageView) findViewById(R.id.zltitle_img);
        zl_tablayout = (TabLayout) findViewById(R.id.zl_tablayout);
        zl_vp = (ViewPager) findViewById(R.id.zl_vp);

        tb_back_tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
