package com.example.player.a1610aplayerdemo.compontent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.camera.base.ILoginService;
import com.example.camera.base.IPayCallback;
import com.example.camera.base.IPayService;
import com.example.camera.base.ServiceManager;
import com.example.player.a1610aplayerdemo.R;

public class DemoActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonLogin;
    private TextView resultTv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compontent);
        buttonLogin = findViewById(R.id.btnLogin);
        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.btnPay).setOnClickListener(this);
        resultTv = findViewById(R.id.resultTv);

        if (ServiceManager.getInstance().getiLoginService() == null) {
            buttonLogin.setText("当前登录模块不可用，请配置登录模块");
            buttonLogin.setEnabled(false);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                ILoginService iLoginService = ServiceManager.getInstance().getiLoginService();
                if (iLoginService!=null) {//先进行判断，有可能登录模块没有添加到应用中.
                    iLoginService.login(this, null);
                }

                break;
            case R.id.btnPay:
                IPayService iPayService = ServiceManager.getInstance().getiPayService();
                if (iPayService!=null) {
                    iPayService.pay(this, "11610", 100.5f, new IPayCallback() {
                        @Override
                        public void payResult(boolean result) {
                            resultTv.setText(result?"支付成功":"支付失败");
                        }
                    });
                }

                default:
                    break;
        }
    }
}
