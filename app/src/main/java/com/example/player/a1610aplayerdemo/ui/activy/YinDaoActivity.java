package com.example.player.a1610aplayerdemo.ui.activy;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.TokenDateBean;
import com.example.player.a1610aplayerdemo.ui.tokenpresenter.TokenInterface;
import com.example.player.a1610aplayerdemo.ui.tokenpresenter.TokenPresenterCompl;
import com.example.player.a1610aplayerdemo.util.SpUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

public class YinDaoActivity extends AppCompatActivity implements TokenInterface.TokenView {


    SimpleDraweeView sm;

    TokenInterface.ItokenPresenter itokenPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yin_dao);

        itokenPresenter = new TokenPresenterCompl(this);

        itokenPresenter.getTokenData();

        sm = findViewById(R.id.yd_img);
        sm.setImageURI("http://ali-files.yooshow.com/2019/03/20/ecccd992-f2a7-4d33-a414-5348c34d28ab.png");


        zdtz();
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1){
                startActivity(new Intent(YinDaoActivity.this,MainActivity.class));
            }
        }
    };

    private void zdtz() {

        handler.sendEmptyMessageDelayed(1,3000);
    }


    public void jump(View view) {

        startActivity(new Intent(YinDaoActivity.this,MainActivity.class));

        // startActivity(new Intent(YinDaoActivity.this,LoodingActivity.class));
    }

    @Override
    public void onGetDataSuccess(@NotNull TokenDateBean bean) {


        SpUtil.saveToken(bean.getAccessToken());

    }

    @Override
    public void onGetDataFailed(@NotNull String errorMsg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        itokenPresenter.detachView();
    }
}
