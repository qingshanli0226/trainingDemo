package com.example.player.a1610aplayerdemo.ui.my.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.SignInBean;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,ILoginView{
    private ImageView titlebar_left;
    private TextView text;
    private RelativeLayout titlebar_search;
    private TextView titlebar_title;
    private ImageView titlebar_right;
    private TextView noMoney;
    private EditText edit_phone;
    private EditText edit_pwd;
    private Button btn_login;
    private TextView forgetPwd;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        initView();
        loginPresenter = new LoginPresenter(this);

    }

    private void initView() {
        titlebar_left = (ImageView) findViewById(R.id.titlebar_left);
        text = (TextView) findViewById(R.id.text);
        titlebar_search = (RelativeLayout) findViewById(R.id.titlebar_search);
        titlebar_title = (TextView) findViewById(R.id.titlebar_title);
        titlebar_right = (ImageView) findViewById(R.id.titlebar_right);
        noMoney = (TextView) findViewById(R.id.noMoney);
        edit_phone = (EditText) findViewById(R.id.edit_phone);
        edit_pwd = (EditText) findViewById(R.id.edit_pwd);
        btn_login = (Button) findViewById(R.id.btn_login);
        forgetPwd = (TextView) findViewById(R.id.forgetPwd);

        titlebar_left.setVisibility(View.VISIBLE);
        titlebar_left.setOnClickListener(this);
        titlebar_search.setVisibility(View.GONE);
        titlebar_right.setVisibility(View.GONE);
        titlebar_title.setVisibility(View.VISIBLE);
        titlebar_title.setText("手机快捷登录");

        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.titlebar_left:
                finish();
                break;
            case R.id.btn_login:
                //登录
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String phone = edit_phone.getText().toString().trim();
        String pwd = edit_pwd.getText().toString().trim();

        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }else if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        loginPresenter.getData(phone,pwd);

    }

    @Override
    public void loginSuccess(SignInBean signInBean) {
        finish();
    }

    @Override
    public void loginFail() {
        Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Log.e("login", "loginError: 失败");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy(this);
    }
}
