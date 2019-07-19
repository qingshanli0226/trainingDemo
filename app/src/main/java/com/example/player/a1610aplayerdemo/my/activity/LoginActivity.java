package com.example.player.a1610aplayerdemo.my.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.player.a1610aplayerdemo.MVPApplication;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBasePresenterTwo;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.base.IBaseViewTwo;
import com.example.player.a1610aplayerdemo.my.bean.AuthCode;
import com.example.player.a1610aplayerdemo.my.presenter.AuthCodePresenter;
import com.example.player.a1610aplayerdemo.my.presenter.NextPresenter;

public class LoginActivity extends AppCompatActivity implements IBaseView<AuthCode>,IBaseViewTwo<AuthCode> {
    private IBasePresenter<AuthCode> iBasePresenter;
    private IBasePresenterTwo<AuthCode> iBasePresenterTwo;
    private SharedPreferences sp,sp1,sp2;

    @BindView(R.id.feedback_back)
    ImageView feedbackBack;
    @BindView(R.id.login_text)
    TextView loginText;
    @BindView(R.id.phone_edit)
    EditText phoneEdit;
    @BindView(R.id.verification_edit)
    EditText verificationEdit;
    @BindView(R.id.show_hidden)
    TextView showHidden;
    @BindView(R.id.next_button)
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        sp = getSharedPreferences("phone", Context.MODE_PRIVATE);
        sp2 = getSharedPreferences("phoneuser", Context.MODE_PRIVATE);
        sp1 = MVPApplication.instance.getSharedPreferences("tokenKey",Context.MODE_PRIVATE);
    }

    @OnClick({R.id.feedback_back, R.id.login_text, R.id.show_hidden, R.id.next_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.feedback_back:
                finish();
                break;
            case R.id.login_text:
                finish();
                break;
            case R.id.show_hidden:
                String phoneNumber = phoneEdit.getText().toString().trim();
                if(phoneNumber.isEmpty()){
                    Toast.makeText(this, "手机机号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }else if(phoneNumber.length() != 11){
                    Toast.makeText(this, "手机号的格式不正确", Toast.LENGTH_SHORT).show();
                    return;
                }
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("phonenumber", phoneNumber);
                editor.commit();
                iBasePresenter = new AuthCodePresenter();
                iBasePresenter.attachView(this);
                iBasePresenter.getData();
                break;
            case R.id.next_button:
                iBasePresenterTwo = new NextPresenter();
                iBasePresenterTwo.attachView(this);
                iBasePresenterTwo.getData();
                break;
        }
    }

    @Override
    public void onLoadData(AuthCode data) {
        if(data.isSuccess()){
            String phoneNumber = phoneEdit.getText().toString().trim();
            String token = sp1.getString("token","空值");
            SharedPreferences.Editor editor = sp2.edit();
            editor.putString("token", token);
            editor.putString("identifyingCode", data.getCode());
            editor.putString("loginName", phoneNumber);
            editor.commit();
        }
    }

    @Override
    public void onLoadError(int code, String message) {

    }

    @Override
    public void onLoadDataT(AuthCode data) {
        if(data.isSuccess()){
            Intent intent = new Intent(LoginActivity.this,CipherActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onLoadErrorT(int code, String message) {

    }
}
