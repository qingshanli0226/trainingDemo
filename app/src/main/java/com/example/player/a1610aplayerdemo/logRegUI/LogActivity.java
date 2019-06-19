package com.example.player.a1610aplayerdemo.logRegUI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.LogDateBean;
import com.example.player.a1610aplayerdemo.net.MVPObserver;
import com.example.player.a1610aplayerdemo.net.MyNetFunction;
import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.util.DeviceKye;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class LogActivity extends AppCompatActivity {

    private EditText logShoujihao;
    private EditText logMima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        initView();
    }

    public void fanhui(View view) {
        finish();
    }

    public void toReg(View view) {

        startActivity(new Intent(LogActivity.this,RegiestActivity.class));
        finish();
    }

    public void Log(View view) {

        String sjh = logShoujihao.getText().toString();
        String mima = logMima.getText().toString();

        getLog(sjh,mima);
    }

    private void getLog(String sjh, String mima) {


        Map<String, String> map = new HashMap<>();
        map.put("loginName", sjh);
        map.put("password", mima);
        map.put("Android-VersionCode", "43");
        map.put("Accept-Encoding", "gzip");
        map.put("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 5.1.1; sm-j700f Build/LMY47I)");
        map.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        map.put("Android-channel", "guoyun");
        map.put("Host", "api.immedc.com");
        map.put("Tingyun_Process", "true");

        Map headmap = new HashMap<>();
        headmap.put("deviceKey", DeviceKye.getDeviceKye());


        RetrofitCreator.getApiService().getLogDate(headmap,map)
                .subscribeOn(Schedulers.io())
                .map(new MyNetFunction<ResEntity<LogDateBean>,LogDateBean>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MVPObserver<LogDateBean>(){

                    @Override
                    public void onNext(LogDateBean logDateBean) {
                        super.onNext(logDateBean);

                        Log.d("xx","success");


                    }
                });

    }

    private void initView() {
        logShoujihao = (EditText) findViewById(R.id.log_shoujihao);
        logMima = (EditText) findViewById(R.id.log_mima);
    }
}
