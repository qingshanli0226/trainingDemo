package com.example.player.a1610aplayerdemo.my.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.my.bean.UserBean;
import com.example.player.a1610aplayerdemo.my.presenter.UserPresenter;

public class RegisterActivity extends AppCompatActivity implements IBaseView<UserBean> {
    private IBasePresenter<UserBean> iBasePresenter;

    @BindView(R.id.feedback_back)
    ImageView feedbackBack;
    @BindView(R.id.login_text)
    TextView loginText;
    @BindView(R.id.account_edit)
    EditText accountEdit;
    @BindView(R.id.password_edit)
    EditText passwordEdit;
    @BindView(R.id.show_hidden)
    TextView showHidden;
    @BindView(R.id.ok_button)
    Button okButton;

    private boolean flage = true;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        iBasePresenter = new UserPresenter();
        iBasePresenter.attachView(this);
        sp = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
    }

    @OnClick({R.id.feedback_back, R.id.login_text, R.id.show_hidden, R.id.ok_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.feedback_back:
                finish();
                break;
            case R.id.login_text:
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.show_hidden:
                if(flage){
                    flage = false;
                    //android:inputType="textPassword"
                    showHidden.setText("隐藏");
                    passwordEdit.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else {
                    flage = true;
                    showHidden.setText("显示");
                    passwordEdit.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                break;
            case R.id.ok_button:
                userruning();
                break;
        }
    }

    private void userruning() {
        String username = accountEdit.getText().toString();
        String password = passwordEdit.getText().toString();
        if(username.isEmpty()){
            Toast.makeText(this, "用户名为空", Toast.LENGTH_SHORT).show();
            return;
        }else if(password.isEmpty()){
            Toast.makeText(this, "用户密码为空", Toast.LENGTH_SHORT).show();
            return;
        }else if(username.length() != 11){
            Toast.makeText(this, "手机号有误", Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("loginName", username);
        editor.putString("password", password);
        editor.commit();
        iBasePresenter.getData();
    }

    @Override
    public void onLoadData(UserBean data) {
        Toast.makeText(this, ""+data.getNickName(), Toast.LENGTH_SHORT).show();
        if(data!=null){
            if(data.getNickName().equals(accountEdit.getText().toString())){
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        }else {
            Toast.makeText(this, "账号或者密码有误", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLoadError(int code, String message) {

    }
}
