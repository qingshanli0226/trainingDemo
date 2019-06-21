package com.example.player.a1610aplayerdemo.my.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.my.bean.Feedback;
import com.example.player.a1610aplayerdemo.my.presenter.FeedbackPresenter;

public class FeedbackActivity extends AppCompatActivity implements IBaseView<Feedback> {
    IBasePresenter iBasePresenter;
    @BindView(R.id.feedback_back)
    ImageView feedbackBack;
    @BindView(R.id.feedback_et1)
    EditText feedbackEt1;
    @BindView(R.id.feedback_et2)
    EditText feedbackEt2;
    @BindView(R.id.feedback_btn)
    Button feedbackBtn;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        ButterKnife.bind(this);
        sp = getSharedPreferences("feedback", Context.MODE_PRIVATE);
    }

    @OnClick({R.id.feedback_back, R.id.feedback_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.feedback_back:
                finish();
                break;
            case R.id.feedback_btn:
                String s1 = feedbackEt1.getText().toString().trim();
                String s2 = feedbackEt2.getText().toString().trim();
                if (s1.equals("") || s2.equals("")) {
                    Toast.makeText(this, "有空值", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("opinion", s1);
                    editor.putString("relation", s2);
                    editor.commit();

                    iBasePresenter = new FeedbackPresenter();
                    iBasePresenter.attachView(this);
                    iBasePresenter.getData();
                }
                break;
        }
    }

    @Override
    public void onLoadData(Feedback data) {
        if (!data.getContents().equals("")) {
            Toast.makeText(this, "提交成功", Toast.LENGTH_SHORT).show();
            Log.i("aaa", data.getContents());
            finish();
        }
    }

    @Override
    public void onLoadError(int code, String message) {

    }
}
