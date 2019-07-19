package com.example.player.a1610aplayerdemo.activity.register.bean;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.activity.main.MainActivity;
import com.example.player.a1610aplayerdemo.base.MToolBar;
import com.example.player.a1610aplayerdemo.net.HeadParam;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.token.SpUtils;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class PasswordLoginActivity extends AppCompatActivity implements View.OnClickListener {

    private MToolBar psd_login_mtoolabr;
    private EditText pwd;
    private EditText again_pwd;
    private Button pwd_login;
    private String code;
    private String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_login);

        Intent intent = getIntent();
        code = intent.getStringExtra("code");
        phone = intent.getStringExtra("phone");
        initView();
        initToolbar();
    }

    private void initToolbar() {
        psd_login_mtoolabr.setTitle("设置密码");
        psd_login_mtoolabr.setLeftImg(R.drawable.ic_back_img);
        psd_login_mtoolabr.setleftListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {
        psd_login_mtoolabr = (MToolBar) findViewById(R.id.psd_login_mtoolabr);
        pwd = (EditText) findViewById(R.id.pwd);
        again_pwd = (EditText) findViewById(R.id.again_pwd);
        pwd_login = (Button) findViewById(R.id.pwd_login);

        pwd_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pwd_login:
               submit();
                break;
        }
    }

    private void submit() {
        // validate
        String pwdString = pwd.getText().toString().trim();
        if (TextUtils.isEmpty(pwdString)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        String pwd = again_pwd.getText().toString().trim();
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "请再次输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!pwd.equals(pwdString)){
            Toast.makeText(this, "两次密码不一样", Toast.LENGTH_SHORT).show();
            return;
        }
        if (pwdString.length()<6){
            Toast.makeText(this, "密码长度不可小于6位", Toast.LENGTH_SHORT).show();
            return;
        }
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("token", SpUtils.getSpUtils().getToken());
        paramMap.put("identifyingCode",code);
        paramMap.put("password",pwd);
        paramMap.put("mobilePhone",phone);
        RetrofitCreator.getInstance().getRetrofitApiService()
                .singUp(HeadParam.getHeadMap(),paramMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SingUpBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SingUpBean singUpBean) {
                        if (singUpBean.getData().isLogin()){
                            Intent intent = new Intent();
                            intent.setClass(PasswordLoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(PasswordLoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        // TODO validate success, do something


    }
}
