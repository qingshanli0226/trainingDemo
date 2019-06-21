package com.example.player.a1610aplayerdemo.secondUI.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseView;
import com.example.player.a1610aplayerdemo.secondUI.adapter.MusicClassAdapter;
import com.example.player.a1610aplayerdemo.secondUI.bean.MusicClassBean;
import com.example.player.a1610aplayerdemo.secondUI.persenter.MusicClassPersenter;

import java.util.ArrayList;
import java.util.List;

public class MusicClassActivity extends AppCompatActivity implements BaseView<MusicClassBean> {

    private ImageView back;
    private RecyclerView rv;
    private List<MusicClassBean.DataBean> data=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_class);
        initView();
        new MusicClassPersenter(this).getMusicData("1");
    }

    private void initView() {
        back = (ImageView) findViewById(R.id.back);
        rv = (RecyclerView) findViewById(R.id.rv);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(gridLayoutManager);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void onLoadData(MusicClassBean datalist) {
        data = datalist.getData();
        MusicClassAdapter musicClassAdapter = new MusicClassAdapter(data, this);
        rv.setAdapter(musicClassAdapter);
       // musicClassAdapter.refresh(data);
    }

    @Override
    public void onLoadError(int code, String str) {
        Log.d("errorrrrr音乐课堂",str+"");
    }

}
