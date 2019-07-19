package com.example.player.a1610aplayerdemo.ui.setting;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.LoginOutBean;
import com.example.player.a1610aplayerdemo.net.MVPObserver;
import com.example.player.a1610aplayerdemo.net.MyNetFunction;
import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.ui.activy.MainActivity;
import com.example.player.a1610aplayerdemo.util.DeviceKye;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class SettingActivity extends AppCompatActivity {

    private TextView cleanchacha;
    private TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logoutTc();

            }
        });
    }

    private void logoutTc() {

        Map<String, String> map = new HashMap<>();

        map.put("Android-VersionCode", "43");
        map.put("Accept-Encoding", "gzip");
        map.put("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 5.1.1; sm-j700f Build/LMY47I)");
        map.put("Content-Type", "application/x-www-form-urlencoded");
        map.put("Android-channel", "guoyun");
        map.put("Host", "api.immedc.com");
        map.put("Tingyun_Process", "true");
        map.put("X-Tingyun-Id", "oNIzcYZpC5c;c=2;r=1141970828");
        map.put("deviceKey", DeviceKye.getDeviceKye());

        Map<String, String> fmap = new HashMap<>();

        RetrofitCreator.getApiService().getLogOut(map,fmap)
                .subscribeOn(Schedulers.io())
                .map(new MyNetFunction<ResEntity<LoginOutBean>,LoginOutBean>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MVPObserver<LoginOutBean>(){
                    @Override
                    public void onNext(LoginOutBean logDateBean) {
                        super.onNext(logDateBean);
                        boolean login = logDateBean.isLogin();
                        if (login==false){
                            startActivity(new Intent(SettingActivity.this, MainActivity.class));
                            Toast.makeText(SettingActivity.this, "退出成功", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(SettingActivity.this, "退出失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });




    }

    private void initView() {
        cleanchacha = (TextView) findViewById(R.id.cleanchacha);
        logout = (TextView) findViewById(R.id.logout);



    }
}
