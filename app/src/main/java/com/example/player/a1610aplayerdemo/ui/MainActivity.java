package com.example.player.a1610aplayerdemo.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.example.player.a1610aplayerdemo.commit.Contants;
import com.example.player.a1610aplayerdemo.utils.Md5Utils;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.ui.home.fragment.Home_Fragment;
import com.example.player.a1610aplayerdemo.ui.member.fragment.Member_Fragment;
import com.example.player.a1610aplayerdemo.ui.study.fragment.Already_Fragment;
import com.example.player.a1610aplayerdemo.ui.user.fragment.User_Fragment;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import okhttp3.Call;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private ViewPager vp;
    private RadioGroup rg;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Main_Adapter adapter;
    private List<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        data();
        adapter();
        listener();

        Log.i("TagA", "设备：" + Build.DEVICE);
        Log.i("TagA", "设备的key：" + getDeviceKey());
        Log.i("TagA", "系统版本：" + String.valueOf(Build.VERSION.SDK_INT));
        Log.i("TagA", "品牌：" + Build.BOARD);

        Map map = new HashMap();
        map.put("device", Build.DEVICE);
        map.put("deviceKey", getDeviceKey());
        map.put("sdkVersion", String.valueOf(Build.VERSION.SDK_INT));
        map.put("brand", Build.BRAND);
        map.put("product", Build.PRODUCT);

        OkHttpUtils
                .post()
                .url(Contants.BASE_URL)
                .addParams("", Build.DEVICE)
                .addParams("", getDeviceKey())
                .addParams("", String.valueOf(Build.VERSION.SDK_INT))
                .addParams("", Build.BRAND)
                .addParams("", Build.PRODUCT)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONObject data = jsonObject.getJSONObject("data");
                    String accessToken = data.getString("accessToken");
                    Toast.makeText(MainActivity.this, "TOKEN:" + accessToken, Toast.LENGTH_SHORT).show();
                    Log.i("TOKEN", accessToken);
                    Contants.TOKEN = accessToken;
                    OkHttpUtils
                            .get()
                            .url(Contants.BASE_URL + Contants.GET_HOME)
                            .addHeader("CH-TOKEN", Contants.TOKEN)
                            .build().execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {

                        }

                        @Override
                        public void onResponse(String response, int id) {

                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @SuppressLint("MissingPermission")
    private String getDeviceKey() {
        String deviceKey = null;
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        deviceKey = tm.getSimSerialNumber();
        deviceKey = Md5Utils.MD5(deviceKey);
        return deviceKey;
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        rg = (RadioGroup) findViewById(R.id.rg);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);
        vp.addOnPageChangeListener(this);
    }

    private void data(){
        list.add(new Home_Fragment());
        list.add(new Member_Fragment());
        list.add(new Already_Fragment());
        list.add(new User_Fragment());
    }

    private void adapter(){
        adapter = new Main_Adapter(getSupportFragmentManager(),list);
        vp.setAdapter(adapter);
    }

    private void listener(){
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (R.id.rb1 == checkedId){
                    vp.setCurrentItem(0);
                }
                if (R.id.rb2 == checkedId){
                    vp.setCurrentItem(1);
                }
                if (R.id.rb3 == checkedId){
                    vp.setCurrentItem(2);
                }
                if (R.id.rb4 == checkedId){
                    vp.setCurrentItem(3);
                }
            }
        });
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        switch (i){
            case 0:
                rb1.setChecked(true);
                break;
            case 1:
                rb2.setChecked(true);
                break;
            case 2:
                rb3.setChecked(true);
                break;
            case 3:
                rb4.setChecked(true);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}