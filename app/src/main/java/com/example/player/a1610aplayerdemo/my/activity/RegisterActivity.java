package com.example.player.a1610aplayerdemo.my.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.player.a1610aplayerdemo.R;

public class RegisterActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.feedback_back, R.id.login_text, R.id.show_hidden, R.id.ok_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.feedback_back:
                finish();
                break;
            case R.id.login_text:
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
                break;
        }
    }
}
