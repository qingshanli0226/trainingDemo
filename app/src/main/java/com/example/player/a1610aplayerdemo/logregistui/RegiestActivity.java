package com.example.player.a1610aplayerdemo.logregistui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.RegCheckBean;
import com.example.player.a1610aplayerdemo.bean.LogDateBean;
import com.example.player.a1610aplayerdemo.bean.NextTypeBean;
import com.example.player.a1610aplayerdemo.bean.RegCodeBean;
import com.example.player.a1610aplayerdemo.net.MVPObserver;
import com.example.player.a1610aplayerdemo.net.MyNetFunction;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.util.DeviceKye;
import com.example.player.a1610aplayerdemo.util.SpUtil;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

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
        final String sjh = regShoujihao.getText().toString();
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
        filemap.put("identifyingCode", regYzm.getText().toString());
        filemap.put("token+=",SpUtil.getToken());

        RetrofitCreator.getApiService().getNextDate(map,filemap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MVPObserver<NextTypeBean>(){

                    @Override
                    public void onNext(NextTypeBean nextTypeBean) {
                        super.onNext(nextTypeBean);
                        boolean login = nextTypeBean.isData();
                        if (login){
                            Intent intent = new Intent(RegiestActivity.this, AddPassWordActivity.class);
                            intent.putExtra("identifyingCode",regYzm.getText().toString());
                            intent.putExtra("mobilePhone",sjh);
                            startActivity(intent);
                        }else {
                            Toast.makeText(RegiestActivity.this, "该账户错误", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void getYzm(View view) {
        String sjh = regShoujihao.getText().toString();
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
        filemap.put("messageType","1");
        filemap.put("mobilePhone", sjh);

        RetrofitCreator.getApiService().getRegCodeDate(map,filemap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MVPObserver<RegCodeBean>(){

                    @Override
                    public void onNext(RegCodeBean regCheckBean) {
                        super.onNext(regCheckBean);
                        regYzm.setText(regCheckBean.getCode());
                    }
                });
    }
    public void getIfReg(View view) {

        String sjh = regShoujihao.getText().toString();
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

        RetrofitCreator.getApiService().getRegCheck(map,filemap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MVPObserver<RegCheckBean>(){

                    @Override
                    public void onNext(RegCheckBean regCheckBean) {
                        super.onNext(regCheckBean);
                        boolean login = regCheckBean.isData();
                        if (login){
                            Toast.makeText(RegiestActivity.this, "该账户已注册", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(RegiestActivity.this, "该账户尚未注册", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    private void initView() {
        regShoujihao = (EditText) findViewById(R.id.reg_shoujihao);
        regYzm = (EditText) findViewById(R.id.reg_yzm);
        ischeck = (CheckBox) findViewById(R.id.ischeck);
    }
}
