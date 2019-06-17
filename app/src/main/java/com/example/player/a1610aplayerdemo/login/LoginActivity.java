package com.example.player.a1610aplayerdemo.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.activity.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView loginback;
    private TextView forget;
    private TextView registerTv;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

    }

    private void initView() {
        loginback = (ImageView) findViewById(R.id.loginback);
        forget = (TextView) findViewById(R.id.forget);
        registerTv = (TextView) findViewById(R.id.registerTv);
        loginback.setOnClickListener(this);
        forget.setOnClickListener(this);
        registerTv.setOnClickListener(this);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginback:
                finish();
                break;
            case R.id.forget:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.registerTv:
                Intent intent2 = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnLogin:

                break;
        }
    }
}
