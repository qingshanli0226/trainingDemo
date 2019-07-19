package com.example.player.a1610aplayerdemo.logregistui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.AddPwdDataBean;
import com.example.player.a1610aplayerdemo.net.MVPObserver;
import com.example.player.a1610aplayerdemo.net.MyNetFunction;
import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.ui.activy.MainActivity;
import com.example.player.a1610aplayerdemo.util.DeviceKye;
import com.example.player.a1610aplayerdemo.util.SpUtil;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class AddPassWordActivity extends AppCompatActivity {

    private EditText addPwd1;
    private EditText addPwd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pass_word);
        initView();


    }

    public void fanhui(View view) {
        finish();
    }

    public void finishReg(View view) {
        Intent  intent = getIntent();
        String identifyingCode = intent.getStringExtra("identifyingCode");
        String mobilePhone = intent.getStringExtra("mobilePhone");

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
        filemap.put("mobilePhone",mobilePhone);
        filemap.put("identifyingCode",identifyingCode);
        filemap.put("password",addPwd1.getText().toString());
        filemap.put("token+=", SpUtil.getToken());


        RetrofitCreator.getApiService().getNextDate(map,filemap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new MyNetFunction<ResEntity<AddPwdDataBean>,AddPwdDataBean>())
                .subscribe(new MVPObserver<AddPwdDataBean>(){
                    @Override
                    public void onNext(AddPwdDataBean addPwdDataBean) {
                        super.onNext(addPwdDataBean);
                        if (addPwdDataBean.isLogin()==true){
                            Toast.makeText(AddPassWordActivity.this, "注册成功并登录" , Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AddPassWordActivity.this, MainActivity.class));
                        }
                    }
                });
    }

    private void initView() {
        addPwd1 = (EditText) findViewById(R.id.add_pwd1);
        addPwd2 = (EditText) findViewById(R.id.add_pwd2);
    }
}
