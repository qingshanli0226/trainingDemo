package com.example.player.a1610aplayerdemo.ui.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.ui.MainActivity;
import com.example.player.a1610aplayerdemo.ui.register.activity.Register_Activity;

public class LogIn_Activity extends AppCompatActivity {
    private TextView registerLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        initView();

        registerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LogIn_Activity.this, Register_Activity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        registerLogin = (TextView) findViewById(R.id.register_login);
    }
}