package com.example.player.a1610aplayerdemo.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.example.player.a1610aplayerdemo.R;

public class VideoActivity extends AppCompatActivity {
    private PlayerView player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        View rootView =  getLayoutInflater().from(this).inflate(R.layout.simple_player_view_player,null);
        setContentView(rootView);
        initPlayerView();
    }
    @Override
    protected void onResume() {
        super.onResume();
        player.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        player.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.onDestroy();
    }

    //横竖屏切换
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (player != null) {
            player.onConfigurationChanged(newConfig);
        }
    }

    private void initPlayerView() {
        String url = "http://vd4.bdstatic.com/mda-ja1irnhr4cgdbp8u/hd/mda-ja1irnhr4cgdbp8u.mp4";
        player = new PlayerView(this)
                .setTitle("返回")
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .showThumbnail(new OnShowThumbnailListener() {
                    @Override
                    public void onShowThumbnail(ImageView ivThumbnail) {
                        Glide.with(VideoActivity.this)
                                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1560851519696&di=043dde5e3ae920c3b6b6a0673bf5f021&imgtype=0&src=http%3A%2F%2Fimg3.doubanio.com%2Fview%2Fnote%2Flarge%2Fpublic%2Fp27390391.jpg")
                                .into(ivThumbnail);
                    }
                })
                .setPlaySource(url)
                .startPlay();
    }
}
