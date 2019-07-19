package com.example.player.a1610aplayerdemo.logregistui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.baseclassextraction.IBasePresenter;
import com.example.player.a1610aplayerdemo.baseclassextraction.IBaseView;
import com.example.player.a1610aplayerdemo.bean.LogDateBean;
import com.example.player.a1610aplayerdemo.logregistui.longinpresenter.LoginPresenterComple;
import com.example.player.a1610aplayerdemo.net.MVPObserver;
import com.example.player.a1610aplayerdemo.net.MyNetFunction;
import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.ui.activy.LoodingActivity;
import com.example.player.a1610aplayerdemo.ui.activy.MainActivity;
import com.example.player.a1610aplayerdemo.util.DeviceKye;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements IBaseView<LogDateBean> {
    private EditText logShoujihao;
    private EditText logMima;

    IBasePresenter iBasePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        iBasePresenter = new LoginPresenterComple();
        iBasePresenter.attachView(this);


        initView();

    }



    public void fanhui(View view) {
        finish();
    }

    public void toReg(View view) {

        startActivity(new Intent(LoginActivity.this,RegiestActivity.class));
        finish();
    }
    public void Log(View view) {
        String sjh = logShoujihao.getText().toString();
        String mima = logMima.getText().toString();
        Map<String, String> map = new HashMap<>();
        map.put("Android-VersionCode", "43");
        map.put("Accept-Encoding", "gzip");
        map.put("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 5.1.1; sm-j700f Build/LMY47I)");
        map.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        map.put("Android-channel", "guoyun");
        map.put("Host", "api.immedc.com");
        map.put("Tingyun_Process", "true");
        map.put("deviceKey", DeviceKye.getDeviceKye());

        Map filemap = new HashMap<>();
        filemap.put("loginName", sjh);
        filemap.put("password", mima);
        RetrofitCreator.getApiService().getLogDate(map,filemap)
                .subscribeOn(Schedulers.io())
                .map(new MyNetFunction<ResEntity<LogDateBean>,LogDateBean>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MVPObserver<LogDateBean>(){

                    @Override
                    public void onNext(LogDateBean logDateBean) {
                        super.onNext(logDateBean);
                        boolean login = logDateBean.isLogin();
                        if (login){
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        }else {

                        }
                    }
                });
    }

    private void initView() {
        logShoujihao = (EditText) findViewById(R.id.log_shoujihao);
        logMima = (EditText) findViewById(R.id.log_mima);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onLoadDataList(List<LogDateBean> date) {

    }

    @Override
    public void onLoadDateBean(LogDateBean date) {



    }

    @Override
    public void onLoadEeeor(int code, String message) {

    }
}
