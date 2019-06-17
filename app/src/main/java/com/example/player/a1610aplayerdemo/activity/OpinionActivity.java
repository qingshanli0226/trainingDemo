package com.example.player.a1610aplayerdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.player.a1610aplayerdemo.R;

public class OpinionActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView opinion_iv1;
    private EditText opinion_et1;
    private EditText opinion_et2;
    private Button opinion_btn1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opinion);
        initView();
    }

    private void initView() {
        opinion_iv1 = (ImageView) findViewById(R.id.opinion_iv1);
        opinion_et1 = (EditText) findViewById(R.id.opinion_et1);
        opinion_et2 = (EditText) findViewById(R.id.opinion_et2);
        opinion_btn1 = (Button) findViewById(R.id.opinion_btn1);

        opinion_btn1.setOnClickListener(this);
        opinion_iv1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.opinion_btn1:
                if (submit()){
                    String s1=opinion_et1.getText().toString();
                    String s2=opinion_et2.getText().toString();
                    Toast.makeText(this, "提交意见成功", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            case R.id.opinion_iv1:
                finish();
                break;
        }
    }

    private boolean submit() {
        // validate
        String et1 = opinion_et1.getText().toString().trim();
        if (TextUtils.isEmpty(et1)) {
            Toast.makeText(this, "意见和建议为空", Toast.LENGTH_SHORT).show();
            return false;
        }

        String et2 = opinion_et2.getText().toString().trim();
        if (TextUtils.isEmpty(et2)) {
            Toast.makeText(this, "联系方式为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
        // TODO validate success, do something
    }
}
