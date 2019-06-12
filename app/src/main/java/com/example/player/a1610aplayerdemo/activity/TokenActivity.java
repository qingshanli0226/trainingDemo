package com.example.player.a1610aplayerdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.player.a1610aplayerdemo.MainActivity;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.token.TokenBean;
import com.example.player.a1610aplayerdemo.token.TokenPresenter;

public class TokenActivity extends AppCompatActivity implements IBaseView {
    IBasePresenter iBasePresenter;
    private SharedPreferences sp,sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token);
        sp = getSharedPreferences("tokenKey",Context.MODE_PRIVATE);
        sharedPreferences = getSharedPreferences("2019_06_10", Context.MODE_PRIVATE);
        boolean ischeck = sharedPreferences.getBoolean("ischeck",true);
        if(ischeck){
            iBasePresenter = new TokenPresenter();
            iBasePresenter.attachView(this);
            iBasePresenter.getData();
        }else {
            Intent intent = new Intent(TokenActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onLoadData(Object data) {
        TokenBean tokenBean = (TokenBean) data;
        String token = tokenBean.getData().getAccessToken();

        SharedPreferences.Editor editor = sp.edit();
        editor.putString("token",token);
        editor.commit();

        Intent intent = new Intent(TokenActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onLoadError(int code, String message) {

    }
}
