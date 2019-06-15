package com.example.player.a1610aplayerdemo.fragment.MusicClass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.fragment.MusicClass.adapter.Music2Adapter;
import com.example.player.a1610aplayerdemo.fragment.MusicClass.bean.Mb2Bean;
import com.example.player.a1610aplayerdemo.net.RetrofitCreate;
import com.example.player.a1610aplayerdemo.utils.ToolbarManger;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Music2Activity extends AppCompatActivity  {
    int id;
    /**
     * 搜索
     */
    private EditText tbEd;
    private ImageView tbImg;
    private Toolbar toolbar;
    private RecyclerView rv;
    private List<Mb2Bean.DataBean> list=new ArrayList<>();
    private Music2Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music2);
        initView();
        Intent intent = getIntent();
        if (intent != null) {
            id = (int) intent.getIntExtra("musicId", 0);
            Toast.makeText(this, "" + id, Toast.LENGTH_SHORT).show();
        }
        String url = "course/getCourses?grade=0&perfesionalCategoryId=" + id + "&page=1&size=20";
        RetrofitCreate.getNetApiService().getMb2Bean(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Mb2Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Mb2Bean value) {
                        List<Mb2Bean.DataBean> data = value.getData();
                        adapter=new Music2Adapter();
                        rv.setAdapter(adapter);
                        adapter.refresh(data);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView() {
        tbEd = (EditText) findViewById(R.id.tb_ed);
        tbImg = (ImageView) findViewById(R.id.tb_img);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        rv = (RecyclerView) findViewById(R.id.rv_re);
        tbEd.setVisibility(View.GONE);
        tbImg.setVisibility(View.GONE);
        toolbar.setTitle("管乐");
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        rv.setLayoutManager(gridLayoutManager);
    }



}
