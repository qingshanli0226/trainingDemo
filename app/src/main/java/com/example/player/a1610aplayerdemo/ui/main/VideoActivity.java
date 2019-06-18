package com.example.player.a1610aplayerdemo.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.widget.IjkVideoView;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.example.player.a1610aplayerdemo.Constant;
import com.example.player.a1610aplayerdemo.R;

public class VideoActivity extends AppCompatActivity {
    private String url;
    private String name;
    private IjkVideoView ijk;
    private PlayerView playerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        getIntentData();

        setVideo();
    }

    private void setVideo() {
        playerView = new PlayerView(this);
        playerView.setTitle(name)
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)

                .forbidTouch(false)
//                .showThumbnail(new OnShowThumbnailListener() {
//                    @Override
//                    public void onShowThumbnail(ImageView ivThumbnail) {
//
//                    }
//                })
                .setPlaySource(url)
                .startPlay();
    }

    private void getIntentData() {
        Intent intent = getIntent();
        url = intent.getStringExtra(Constant.URL);
        name = intent.getStringExtra(Constant.TITLE);
    }


    @Override
    protected void onPause() {
        super.onPause();
        playerView.pausePlay();
    }
}
