package com.example.player.a1610aplayerdemo.compontent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.example.compontentlibrary.LoginActivity;
import com.example.player.a1610aplayerdemo.R;

public class CompontentActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compontent);
        findViewById(R.id.btnLogin).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btnLogin:
                intent.setClass(CompontentActivity.this, LoginActivity.class);
                break;
                default:
                    break;
        }
        startActivity(intent);
    }
}
