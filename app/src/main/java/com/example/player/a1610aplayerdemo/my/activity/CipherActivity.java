package com.example.player.a1610aplayerdemo.my.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBasePresenterTwo;
import com.example.player.a1610aplayerdemo.base.IBaseViewTwo;
import com.example.player.a1610aplayerdemo.my.bean.PwdBean;
import com.example.player.a1610aplayerdemo.my.presenter.PwdPresenter;

public class CipherActivity extends AppCompatActivity implements IBaseViewTwo<PwdBean> {
    private IBasePresenterTwo<PwdBean> iBasePresenterTwo;

    @BindView(R.id.pwdone_edit)
    EditText pwdoneEdit;
    @BindView(R.id.pwdtwo_edit)
    EditText pwdtwoEdit;
    @BindView(R.id.cipher_button)
    Button cipherButton;

    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cipher);
        ButterKnife.bind(this);
        sp = getSharedPreferences("phoneuser", Context.MODE_PRIVATE);
    }

    @OnClick(R.id.cipher_button)
    public void onViewClicked() {
        String pwd1 = pwdoneEdit.getText().toString().trim();
        String pwd2 = pwdtwoEdit.getText().toString().trim();

        SharedPreferences.Editor editor = sp.edit();
        editor.putString("password", pwd1);
        editor.commit();

        iBasePresenterTwo = new PwdPresenter();
        iBasePresenterTwo.attachView(this);
        iBasePresenterTwo.getData();
    }

    @Override
    public void onLoadDataT(PwdBean data) {
        if(data.getNickName().equals(sp.getString("loginName","空值"))){
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            finish();
        }else {
            Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLoadErrorT(int code, String message) {

    }
}
