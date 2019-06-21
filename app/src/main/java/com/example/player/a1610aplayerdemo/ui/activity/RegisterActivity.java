package com.example.player.a1610aplayerdemo.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView registerback;
    private TextView gologin;
    private EditText phoneNumber;
    private EditText verifyCode;
    private CheckBox checkbox;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        RegisterNext();
    }

    private void initView() {
        registerback = (ImageView) findViewById(R.id.registerback);
        gologin = (TextView) findViewById(R.id.gologin);
        registerback.setOnClickListener(this);
        gologin.setOnClickListener(this);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        phoneNumber.setOnClickListener(this);
        verifyCode = (EditText) findViewById(R.id.verifyCode);
        verifyCode.setOnClickListener(this);
        checkbox = (CheckBox) findViewById(R.id.checkbox);
        checkbox.setOnClickListener(this);
        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registerback:
                finish();
                break;
            case R.id.gologin:
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.next:
                RegisterNext();
                break;
        }
    }
    private void RegisterNext(){
        String phoneNumberString = phoneNumber.getText().toString().trim();
        String verifyCodeString = verifyCode.getText().toString().trim();
        if (phoneNumberString.isEmpty()&&verifyCodeString.isEmpty()){
            submit();
        }else {
            if (checkbox.isChecked()){
                next.setClickable(true);
                next.setBackgroundColor(Color.parseColor("#8F002F"));
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(this, "您还没有同意服务协议", Toast.LENGTH_SHORT).show();
            }
        }

    }


    private void submit() {
        // validate
        String phoneNumberString = phoneNumber.getText().toString().trim();
        if (TextUtils.isEmpty(phoneNumberString)) {
            Toast.makeText(this, "phoneNumberString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String verifyCodeString = verifyCode.getText().toString().trim();
        if (TextUtils.isEmpty(verifyCodeString)) {
            Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
