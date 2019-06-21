package com.example.player.a1610aplayerdemo.fragment.MusicClass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.fragment.MusicClass.adapter.MusciAdapter;
import com.example.player.a1610aplayerdemo.fragment.MusicClass.adapter.Music2Activity;
import com.example.player.a1610aplayerdemo.fragment.MusicClass.bean.MbBean;
import com.example.player.a1610aplayerdemo.fragment.MusicClass.present.MusicContact;
import com.example.player.a1610aplayerdemo.fragment.MusicClass.present.MusicPresenterCompl;

import java.util.ArrayList;
import java.util.List;

public class MusciClassActivity extends AppCompatActivity implements MusicContact.MbView, MusciAdapter.ItemClick {

    private MusicPresenterCompl musicPresenterCompl;
    private RecyclerView mcRv;
    private MusciAdapter musciAdapter;
    private List<MbBean.DataBean> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musci_class);
        musicPresenterCompl = new MusicPresenterCompl(this);
        musicPresenterCompl.getData();
        initView();

    }
    private void initView() {
        mcRv = (RecyclerView) findViewById(R.id.mc_rv);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,4);
        mcRv.setLayoutManager(gridLayoutManager);

    }
    @Override
    public void getSuccessData(MbBean mbBean) {
        musciAdapter=new MusciAdapter(list,this);
        list.addAll(mbBean.getData());
        mcRv.setAdapter(musciAdapter);
        musciAdapter.refresh(mbBean.getData());
    }

    @Override
    public void getFailData(String e) {

    }


    @Override
    public void onClick(int position) {
        int id = list.get(position).getId();
        Intent intent=new Intent();
        intent.setClass(MusciClassActivity.this, Music2Activity.class);
        intent.putExtra("musicId",id);
        startActivity(intent);
//        Toast.makeText(this, ""+id, Toast.LENGTH_SHORT).show();
    }
}
