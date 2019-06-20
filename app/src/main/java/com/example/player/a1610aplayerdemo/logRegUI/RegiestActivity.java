package com.example.player.a1610aplayerdemo.logRegUI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import com.example.player.a1610aplayerdemo.R;

public class RegiestActivity extends AppCompatActivity {

    private EditText regShoujihao;
    private EditText regYzm;
    private CheckBox ischeck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiest);
        initView();
    }

    public void fanhui(View view) {

        startActivity(new Intent(RegiestActivity.this, LoginActivity.class));
        finish();
    }

    public void toLog(View view) {
        startActivity(new Intent(RegiestActivity.this, LoginActivity.class));
        finish();
    }

    public void nextStep(View view) {


    }

    public void getYzm(View view) {


    }

    private void initView() {
        regShoujihao = (EditText) findViewById(R.id.reg_shoujihao);
        regYzm = (EditText) findViewById(R.id.reg_yzm);
        ischeck = (CheckBox) findViewById(R.id.ischeck);
    }
}
