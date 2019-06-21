package com.example.player.a1610aplayerdemo.activity.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.MToolBar;
import com.example.player.a1610aplayerdemo.activity.login.bean.CheckBean;
import com.example.player.a1610aplayerdemo.activity.login.bean.SignInBean;
import com.example.player.a1610aplayerdemo.activity.main.MainActivity;
import com.example.player.a1610aplayerdemo.net.*;
import com.example.player.a1610aplayerdemo.token.SpUtils;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private MToolBar mToolBar;
    private TextView tv_ljRegister;
    private EditText ed_login_phone;
    private EditText ed_login_pwd;
    private Button bt_longin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initRegisterText();
        initToolbar();
    }

    private void initRegisterText() {
        final SpannableStringBuilder style = new SpannableStringBuilder();
        // 设置文字
        style.append(tv_ljRegister.getText());

        //设置部分文字点击事件
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick( @NonNull View view) {
                Toast.makeText(LoginActivity.this, ""+style.toString(), Toast.LENGTH_SHORT).show();
            }
        };
        int length = tv_ljRegister.getText().length();
        // 将点击事件加入  具体的内容上
        style.setSpan(clickableSpan,length-4,length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
   //     tv_ljRegister.setText(style);

        // 设置部分文字颜色
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.RED);
        style.setSpan(foregroundColorSpan,length-4,length,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        // 配置给 TextView
        tv_ljRegister.setMovementMethod(LinkMovementMethod.getInstance()); // 添加了下划线
        tv_ljRegister.setText(style);

    }

    private void initToolbar() {
        mToolBar.showTitleView();
        mToolBar.setTitle("登录");
        mToolBar.hideEditextView();
        mToolBar.rightImg.setVisibility(View.GONE);
        mToolBar.setLeftImg(R.drawable.ic_back_img);
        mToolBar.setrightText("忘记密码？");

    }

    private void initView() {
        mToolBar = findViewById(R.id.login_toolbar);
        tv_ljRegister = (TextView) findViewById(R.id.tv_ljRegister);
        tv_ljRegister.setOnClickListener(this);
        ed_login_phone = (EditText) findViewById(R.id.ed_login_phone);
        ed_login_phone.setOnClickListener(this);
        ed_login_pwd = (EditText) findViewById(R.id.ed_login_pwd);
        ed_login_pwd.setOnClickListener(this);
        bt_longin = (Button) findViewById(R.id.bt_longin);
        bt_longin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_longin:
                submit();
                break;
            case R.id.ed_login_pwd:
                checkUserExists();
                break;
        }
    }

    private void checkUserExists() {
        if (ed_login_phone.getText() != null){
            Map<String,String> headMap = new HashMap<>();
            String token = SpUtils.getSpUtils().getToken();
            if (token == null){
                return ;
            }else {
                headMap.put(Contance.CH_TOKEN,token);
            }
            Map<String,String> paramMap = new HashMap<>();
            paramMap.put("loginName",ed_login_phone.getText().toString().trim());
            RetrofitCreator.getInstance().getRetrofitApiService()
                    .getCheckUser(headMap,paramMap)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<CheckBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(CheckBean checkBean) {
                            boolean data = checkBean.isData();
                            Log.i("checkUser", "onNext: "+data);
                            if(!data){
                                checkUserNotifiy();
                            }

                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.i("checkUser", "onError: "+e.toString());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }

    }
// 如果用户未注册 弹出提示框提示用户
    private void checkUserNotifiy() {
        final AlertDialog.Builder alerDialog = new AlertDialog.Builder(this);
        alerDialog.setTitle("用户提示");
        alerDialog.setIcon(R.drawable.yy);
        alerDialog.setMessage("此手机还未注册，请先注册");
        alerDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alerDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alerDialog.show();

    }

    private void submit() {
        // validate
        String phone = ed_login_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "请输入您的手机号码", Toast.LENGTH_SHORT).show();
            return;
        }

        if (phone.length() != 11){
            Toast.makeText(this, "暂不支持外国号码", Toast.LENGTH_SHORT).show();
            return;
        }

        String pwd = ed_login_pwd.getText().toString().trim();
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something

        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("loginName",phone);
        paramMap.put("password",pwd);


         RetrofitCreator.getInstance().getRetrofitApiService()
                 .getSingIn(HeadParam.getHeadMap(),paramMap)
                 .subscribeOn(Schedulers.io())
                 .map(new NetFunction<ResEntity<SignInBean.DataBean>,SignInBean.DataBean>())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Observer<SignInBean.DataBean>() {
                     @Override
                     public void onSubscribe(Disposable d) {

                     }

                     @Override
                     public void onNext(SignInBean.DataBean signInBean) {
                         boolean login = signInBean.isLogin();
                         if (login){
                             Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                             Intent intent = new Intent();
                             intent.setClass(LoginActivity.this, MainActivity.class);
                             startActivity(intent);
                         }else {
                             Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                         }
                     }

                     @Override
                     public void onError(Throwable e) {
                         Log.i("loginError", "onError: "+e.toString());
                     }

                     @Override
                     public void onComplete() {

                     }
                 });

    }
}
