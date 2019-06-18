package com.example.player.a1610aplayerdemo.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.player.a1610aplayerdemo.MainActivity;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.token.TokenBean;
import com.example.player.a1610aplayerdemo.token.TokenPresenter;
import com.squareup.picasso.Picasso;

public class TokenActivity extends AppCompatActivity implements IBaseView {
    IBasePresenter iBasePresenter;
    @BindView(R.id.token_greet_iv)
    ImageView tokenGreetIv;
    private SharedPreferences sp;
    public final static int REQUEST_READ_PHONE_STATE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token);
        ButterKnife.bind(this);

        Picasso.with(this).load("http://ali-files.yooshow.com/2019/06/17/2ac137aa-954a-4ac9-836a-4475c24caf7b.jpg").into(tokenGreetIv);

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_READ_PHONE_STATE);
        } else {
            sp = getSharedPreferences("tokenKey", Context.MODE_PRIVATE);
            iBasePresenter = new TokenPresenter();
            iBasePresenter.attachView(this);
            iBasePresenter.getData();
        }
    }

    @Override
    public void onLoadData(Object data) {
        TokenBean tokenBean = (TokenBean) data;
        String token = tokenBean.getData().getAccessToken();

        SharedPreferences.Editor editor = sp.edit();
        editor.putString("token", token);
        editor.commit();

        Intent intent = new Intent(TokenActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onLoadError(int code, String message) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_READ_PHONE_STATE:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    sp = getSharedPreferences("tokenKey", Context.MODE_PRIVATE);
                    iBasePresenter = new TokenPresenter();
                    iBasePresenter.attachView(this);
                    iBasePresenter.getData();
                }
                break;
            default:
                break;
        }
    }
}
