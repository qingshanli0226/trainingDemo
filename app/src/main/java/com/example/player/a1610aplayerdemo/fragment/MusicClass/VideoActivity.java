package com.example.player.a1610aplayerdemo.fragment.MusicClass;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.dou361.ijkplayer.bean.VideoijkBean;
import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.example.player.a1610aplayerdemo.MyApp;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.fragment.MusicClass.bean.VideoBean;
import com.example.player.a1610aplayerdemo.fragment.MusicClass.fragment.MyViewpagerFragment;
import com.example.player.a1610aplayerdemo.net.RetrofitCreate;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

import java.util.ArrayList;
import java.util.List;

public class VideoActivity extends AppCompatActivity {

    /**
     * 搜索
     */
    private EditText tbEd;
    private ImageView tbImg;
    private Toolbar toolbar;
    private ImageView xqImage;
    private ImageView imageAvater;
    /**
     * 111
     */
    private TextView tvName;
    /**
     * 111
     */
    private TextView tvDetil;
    /**
     * 111
     */
    private TextView tvDec;
    private TabLayout tab;
    private ViewPager vp;
    private MyViewpagerFragment myViewpagerFragment;
    private String string;
    private IjkMediaPlayer ijkMediaPlayer;
    private PlayerView playerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initView();
        Intent intent = getIntent();
        int musicId = intent.getIntExtra("musicId", 1);
        string = "http://api.immedc.com/restapi/course/getVideo2?courseId=" + musicId + "&packageId=0";
        initData();

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (playerView != null) {

            playerView.onPause();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (playerView != null) {
            playerView.onResume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (playerView != null) {
            playerView.onDestroy();
        }
    }

    private void initData() {
        RetrofitCreate.getNetApiService().getVideo(string)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VideoBean value) {
                        final VideoBean.DataBean data = value.getData();
                        tvName.setText(data.getTeacherName());
//                        Picasso.with(MyApp.instance).load(data.getImage()).into(xqImage);
                        tvDetil.setText(data.getTeacherTitle());
                        tvDec.setText(data.getShareView().getShareTitle());
                        List<VideoijkBean> list = new ArrayList<>();
                        String url = "http://ivi.bupt.edu.cn/hls/cctv6hd.m3u8";
                        VideoijkBean m1 = new VideoijkBean();
                        m1.setStream("表情");
                        m1.setUrl(url);
                        VideoijkBean m2 = new VideoijkBean();
                        m1.setStream("高清");
                        m1.setUrl(url);

                        list.add(m1);
                        list.add(m2);
//                        View view=getLayoutInflater().from(VideoActivity.this).inflate(R.layout.activity_video,null);
                        playerView = new PlayerView(VideoActivity.this)
                                .setTitle(data.getTeacherTitle())
                                .setScaleType(PlayStateParams.fillparent)
                                .hideMenu(true)
                                .forbidTouch(false)
                                .showThumbnail(new OnShowThumbnailListener() {
                                    @Override
                                    public void onShowThumbnail(ImageView ivThumbnail) {
                                        Glide.with(MyApp.instance).load(data.getTeacherAvatar()).apply(RequestOptions.bitmapTransform(new CircleCrop()))
//                                                .placeholder(Colo)
                                                .into(ivThumbnail);
                                    }
                                })
                                .setPlaySource(list)
                                .startPlay();
//                        Picas
// so.with(MyApp.instance).load(data.getTeacherAvatar()).into(imageAvater);
                        Glide.with(MyApp.instance).load(data.getTeacherAvatar()).apply(RequestOptions.bitmapTransform(new CircleCrop()))
                                .into(imageAvater);

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
//        xqImage = (ImageView) findViewById(R.id.xq_image);
        imageAvater = (ImageView) findViewById(R.id.image_avater);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvDetil = (TextView) findViewById(R.id.tv_detil);
        tvDec = (TextView) findViewById(R.id.tv_dec);
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);
        myViewpagerFragment = new MyViewpagerFragment(getSupportFragmentManager());
        vp.setAdapter(myViewpagerFragment);
        tab.setupWithViewPager(vp);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (playerView != null) {
            playerView.onConfigurationChanged(newConfig);
        }

    }

    @Override
    public void onBackPressed() {
        if (playerView != null && playerView.onBackPressed()) {
            return;
        }
        super.onBackPressed();

    }
}
