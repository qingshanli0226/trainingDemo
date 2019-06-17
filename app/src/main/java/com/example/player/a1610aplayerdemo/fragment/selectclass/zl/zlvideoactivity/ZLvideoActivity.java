package com.example.player.a1610aplayerdemo.fragment.selectclass.zl.zlvideoactivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.fragment.selectclass.zl.zlvideoactivity.adapter.SecondeVpAdapter;
import com.example.player.a1610aplayerdemo.fragment.selectclass.zl.zlvideoactivity.bean.ZlintroduceBean;
import com.example.player.a1610aplayerdemo.fragment.selectclass.zl.zlvideoactivity.bean.ZlvideoBean;
import com.example.player.a1610aplayerdemo.fragment.selectclass.zl.zlvideoactivity.secondfragment.onefragment.One_Fragment;
import com.example.player.a1610aplayerdemo.fragment.selectclass.zl.zlvideoactivity.secondfragment.twofragment.TwoFragment;
import com.example.player.a1610aplayerdemo.net.*;
import com.example.player.a1610aplayerdemo.token.SpUtils;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZLvideoActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tb_video_title;
    private TextView tb_back_tv;
    private ImageView zltitle_img;
    private TabLayout zl_tablayout;
    private ViewPager zl_vp;
private String id;
private ZlintroduceBean.DataBean data;
private List<ZlvideoBean.DataBean> videoList = new ArrayList<>();
int c = 0;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zlvideo);

        Intent intent = getIntent();
       id = intent.getStringExtra("id");
        Toast.makeText(this, ""+id, Toast.LENGTH_SHORT).show();

        initView();
        fragments.add(new One_Fragment());
        fragments.add(new TwoFragment());

        initData();

    }

    private void initAdapter() {

        zl_tablayout.setupWithViewPager(zl_vp);

        SecondeVpAdapter secondeVpAdapter = new SecondeVpAdapter(getSupportFragmentManager(),fragments);
        zl_vp.setAdapter(secondeVpAdapter);

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
                        data = dataBean;
                        Log.i("aaa", "onNext: zldata"+dataBean.getBarTitle());
                         initIntro(dataBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(ZLvideoActivity.this, ""+e.toString(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });


        Map<String,String> vHeadMap = new HashMap<>();
        vHeadMap.put(Contance.CH_TOKEN,token);
        Map<String,String> queryMap = new HashMap<>();
      //  zlId=20&page=1&size=20
        queryMap.put("zlId",id);
        queryMap.put("page","1");
        queryMap.put("size","20");
        RetrofitCreator.getInstance().getRetrofitApiService()
                .getVideoList(vHeadMap,queryMap)
                .subscribeOn(Schedulers.io())
                .map(new NetFunction<ResEntity<List<ZlvideoBean.DataBean>>,List<ZlvideoBean.DataBean>>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ZlvideoBean.DataBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<ZlvideoBean.DataBean> dataBeanList) {
                         dataBeanList.size();
                         videoList.clear();
                         videoList.addAll( dataBeanList);
                         initVideo();

                        Log.i("aaa", "onNext: videolist"+dataBeanList.size());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("aaa", "onError: videolist"+e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void initVideo() {
        TwoFragment twoFragment = (TwoFragment) fragments.get(1);
        Bundle videobundle = new Bundle();
        videobundle.putParcelableArrayList("videodata", (ArrayList<ZlvideoBean.DataBean>) videoList);
        Log.i("rrr", "initIntro: "+videoList.size());
        twoFragment.setArguments(videobundle);
        handler.sendEmptyMessage(1);
    }

    private void initIntro(ZlintroduceBean.DataBean dataBean) {
        tb_video_title.setText(dataBean.getBarTitle());
        Glide.with(this).load(dataBean.getImage()).placeholder(R.drawable.gray_radius).into(zltitle_img);

        One_Fragment one_fragment = (One_Fragment) fragments.get(0);
        Bundle bundle = new Bundle();
        bundle.putParcelable("data",data);
        one_fragment.setArguments(bundle);
        handler.sendEmptyMessage(1);
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if ( msg.what == 1){
                c+=1;
            }
            if (c == 2){
                initAdapter();
                c = 0;
            }

        }
    };

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
