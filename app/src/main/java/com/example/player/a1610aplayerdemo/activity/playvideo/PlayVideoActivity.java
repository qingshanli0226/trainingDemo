package com.example.player.a1610aplayerdemo.activity.playvideo;

import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.dou361.ijkplayer.bean.VideoijkBean;
import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.widget.IjkVideoView;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.example.player.a1610aplayerdemo.R;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public class PlayVideoActivity extends AppCompatActivity {

    private PlayerView player;
private View y_videoview;

    public  IjkVideoView ijk_videoview;
    private WindowManager wm;
    private WindowManager.LayoutParams params;
    public  View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
     y_videoview = findViewById(R.id.play_view);

        initData();
    }


//http://ivi.bupt.edu.cn/hls/cctv3hd.m3u8  // 直播

    //http://9890.vod.myqcloud.com/9890_9c1fa3e2aea011e59fc841df10c92278.f20.mp4
    private void initData() {
       View rootView = getLayoutInflater().from(this).inflate(R.layout.simple_player_view_player, null);
        setContentView(rootView);
        String url = "http://ivi.bupt.edu.cn/hls/cctv3hd.m3u8";
        VideoijkBean videoijkBean = new VideoijkBean();
        videoijkBean.setUrl(url);
        videoijkBean.setStream("高清");
       player = new PlayerView(this)
                .setTitle("什么")
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .showThumbnail(new OnShowThumbnailListener() {
                    @Override
                    public void onShowThumbnail(ImageView ivThumbnail) {
                        Glide.with(PlayVideoActivity.this)
                                .load("http://pic2.nipic.com/20090413/406638_125424003_2.jpg")
                                .placeholder(R.color.colorAccent)
                                .error(R.color.colorPrimary)
                                .into(ivThumbnail);
                    }
                })
                .setPlaySource(videoijkBean)
                .startPlay();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (player != null) {
            player.onPause();
        }

        initSmallWindow();

        /**demo的内容，恢复系统其它媒体的状态*/
        //MediaUtils.muteAudioFocus(mContext, true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (player != null) {
            player.onResume();
        }
        /**demo的内容，暂停系统其它媒体的状态*/
    //    MediaUtils.muteAudioFocus(mContext, false);
        /**demo的内容，激活设备常亮状态*/
        //if (wakeLock != null) {
        //    wakeLock.acquire();
        //}
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.onDestroy();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (player != null) {
            player.onConfigurationChanged(newConfig);
        }
    }

    @Override
    public void onBackPressed() {
        if (player != null && player.onBackPressed()) {
            return;
        }
        super.onBackPressed();
        /**demo的内容，恢复设备亮度状态*/
        //if (wakeLock != null) {
        //    wakeLock.release();
        //}
    }


    private void initSmallWindow() {
        initView();
        createFloatView();
    }

    public void createFloatView() {
        wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        params = new WindowManager.LayoutParams();

        params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT; // 系统级别的window
        params.format = PixelFormat.TRANSPARENT; // 背景透明
        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;

        params.width = 600;
        params.height = 600;

        LayoutInflater inflater = LayoutInflater.from(this);
        view = inflater.inflate(R.layout.window_layout,null); // 生成view
        ijk_videoview = view.findViewById(R.id.ijk_videoview); // 拿到ijkvideoview控件
        wm.addView(view,params);
        Uri uri = Uri.parse("http://ivi.bupt.edu.cn/hls/cctv5phd.m3u8");
        ijk_videoview.setVideoURI(uri);// 设置播放视频
        ijk_videoview.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                ijk_videoview.start();// 准备好之后，进行播放
            }
        });

        initTouchListener();
        initClickListener();
    }

    private void initClickListener() {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ijk_videoview.release(true);
                view.setVisibility(View.GONE);

                startActivity(PlayVideoActivity.this.getIntent());

            }
        });
    }

    private void initTouchListener() {

        view.setOnTouchListener(new View.OnTouchListener() {
            int lastX,lastY;
            int parmX,parmY;
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        lastX = (int) event.getRawX();
                        lastY = (int) event.getRawY();
                        parmX = params.x;
                        parmY = params.y;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int dx = (int) (event.getRawX() - lastY);
                        int dy = (int) (event.getRawY() - lastY);
                        params.x = parmX + dx;
                        params.y = parmY + dy;
                        break;
                }
                wm.updateViewLayout(view,params);
                return false;
            }
        });
    }


    private void initView() {
        ijk_videoview = (IjkVideoView) findViewById(R.id.ijk_videoview);
    }


}
