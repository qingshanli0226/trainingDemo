package com.example.player.a1610aplayerdemo.activity.register;

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
import android.view.View;
import android.widget.*;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.activity.login.LoginActivity;
import com.example.player.a1610aplayerdemo.activity.login.bean.CheckBean;
import com.example.player.a1610aplayerdemo.activity.register.bean.GetValidCodeBean;
import com.example.player.a1610aplayerdemo.activity.register.bean.PasswordLoginActivity;
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

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private MToolBar register_toolbar;
    private TextView tv_login;
    private EditText ed_register_phone;
    private EditText ed_register_code;
    private Button gain_code;
    private CheckBox checkbox_consent;
    private TextView register_tv_consent;
    private Button register_btn_next;
    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
         initLoginText();

    }

    private void initLoginText() {
        final SpannableStringBuilder style = new SpannableStringBuilder();
        // 设置文字
        style.append(tv_login.getText());

        //设置部分文字点击事件
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick( @NonNull View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

            }
        };
        int length = tv_login.getText().length();
        // 将点击事件加入  具体的内容上
        style.setSpan(clickableSpan,length-2,length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //     tv_ljRegister.setText(style);

        // 设置部分文字颜色
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.RED);
        style.setSpan(foregroundColorSpan,length-2,length,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        // 配置给 TextView
        tv_login.setMovementMethod(LinkMovementMethod.getInstance()); // 添加了下划线
        tv_login.setText(style);

        final SpannableStringBuilder servestyle = new SpannableStringBuilder();
        servestyle.append(register_tv_consent.getText());
        ClickableSpan serve_clickableSpan = new ClickableSpan() {
            @Override
            public void onClick( @NonNull View view) {
                Toast.makeText(RegisterActivity.this, ""+servestyle.toString(), Toast.LENGTH_SHORT).show();
            }
        };
        int serve_length = register_tv_consent.getText().length();
        // 将点击事件加入  具体的内容上
        servestyle.setSpan(serve_clickableSpan,serve_length-4,serve_length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        // 设置部分文字颜色
        ForegroundColorSpan serve_foregroundColorSpan = new ForegroundColorSpan(Color.RED);
        servestyle.setSpan(serve_foregroundColorSpan,serve_length-4,serve_length,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        // 配置给 TextView
        register_tv_consent.setMovementMethod(LinkMovementMethod.getInstance()); // 添加了下划线
        register_tv_consent.setText(servestyle );
    }

    private void initView() {
        register_toolbar = (MToolBar) findViewById(R.id.register_toolbar);
        tv_login = (TextView) findViewById(R.id.tv_login);
        ed_register_phone = (EditText) findViewById(R.id.ed_register_phone);
        ed_register_code = (EditText) findViewById(R.id.ed_register_code);
        gain_code = (Button) findViewById(R.id.gain_code);
        checkbox_consent = (CheckBox) findViewById(R.id.checkbox_consent);
        register_tv_consent = (TextView) findViewById(R.id.register_tv_consent);
        register_btn_next = (Button) findViewById(R.id.register_btn_next);

        gain_code.setOnClickListener(this);
        register_btn_next.setOnClickListener(this);

        register_btn_next.setEnabled(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gain_code:
                 gainCode();
                break;
            case R.id.register_btn_next:
                submit();
                break;
        }
    }
// 检查手机后是否注册过
    private void gainCode() {
        String phone = ed_register_phone.getText().toString();
        if (phone.equals("")){
            Toast.makeText(this, "手机号不可为空", Toast.LENGTH_SHORT).show();
            return;
        }else if (phone.length() != 11){
            Toast.makeText(this, "亲，暂时只支持大陆手机号", Toast.LENGTH_SHORT).show();
            return;
        }else {
            Map<String,String> paramMap = new HashMap<>();
            paramMap.put("loginName",phone);
// 获取 header 参数
            Map<String, String> headMap = HeadParam.getHeadMap();
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
                            if (checkBean.isData()){ // true 代表已经注册过了  不可以再次注册
                                    checkRegisterPhone();
                            }else {
                                //  获取验证码
                                getValidCode();
                            }
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }

    }
// 获取验证码
    private void getValidCode() {
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("messageType","1");
        paramMap.put("mobilePhone",ed_register_phone.getText().toString());
                RetrofitCreator.getInstance().getRetrofitApiService()
                .getValidCode(HeadParam.getHeadMap(),paramMap)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<GetValidCodeBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(GetValidCodeBean getValidCodeBean) {

                                String code = getValidCodeBean.getCode();
                                initCode(code);

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
    }

    private void initCode(String code) {
        this.code = code;
        ed_register_code.setText(code);
        register_btn_next.setEnabled(true);
        register_btn_next.setBackgroundColor(Color.RED);

    }
//  手机号注册过得话弹出对话框提示用户
    private void checkRegisterPhone() {
        final AlertDialog.Builder alerDialog = new AlertDialog.Builder(this);
        alerDialog.setTitle("用户提示");
        alerDialog.setIcon(R.drawable.yy);
        alerDialog.setMessage("此手机号已注册，不可再次注册，请使用其他手机号注册");
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
        final String phone = ed_register_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "phone不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String pwd = ed_register_code.getText().toString().trim();
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "pwd不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        if (!checkbox_consent.isChecked()){
            Toast.makeText(this, "请同意协议", Toast.LENGTH_SHORT).show();
            return;
        }
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("loginName",phone);
        paramMap.put("identifyingCode",code);
        paramMap.put("token", SpUtils.getSpUtils().getToken());
        RetrofitCreator.getInstance().getRetrofitApiService()
                .checkValidCode(HeadParam.getHeadMap(),paramMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CheckBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CheckBean checkBean) {
                        if (checkBean.isData()){
                            Toast.makeText(RegisterActivity.this, "账号注册成功", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent();
                            intent.setClass(RegisterActivity.this, PasswordLoginActivity.class);
                            intent.putExtra("phone",phone);
                            intent.putExtra("code",code);
                            startActivity(intent);
                        }else {
                            Toast.makeText(RegisterActivity.this, "验证码无效", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
