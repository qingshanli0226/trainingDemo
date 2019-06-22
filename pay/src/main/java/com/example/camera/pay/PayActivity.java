package com.example.camera.pay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.example.camera.base.Constant;
import com.example.camera.base.ServiceManager;

public class PayActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView payResultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
       findViewById(R.id.payButton).setOnClickListener(this);
        payResultTv = findViewById(R.id.payResultTv);
        payResultTv.setText(getIntent().getFloatExtra(Constant.PAY_PRICE, -1) + "");
        ServiceManager.getInstance().getiPayCallback().payResult(true);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.payButton) {
            payResultTv.setText(getIntent().getFloatExtra(Constant.PAY_PRICE, -1) + "");
            ServiceManager.getInstance().getiPayCallback().payResult(true);
        } else {
        }
    }
}
