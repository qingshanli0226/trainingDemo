package com.example.camera.pay;

import android.content.Context;
import android.content.Intent;
import com.example.camera.base.Constant;
import com.example.camera.base.IPayCallback;
import com.example.camera.base.IPayService;
import com.example.camera.base.ServiceManager;

public class PayService implements IPayService {

    @Override
    public void pay(Context context, String user, float price, IPayCallback callback) {
        ServiceManager.getInstance().setiPayCallback(callback);
        Intent intent = new Intent(context, PayActivity.class);
        intent.putExtra(Constant.PAY_USER, user);
        intent.putExtra(Constant.PAY_PRICE, price);
        context.startActivity(intent);
    }
}
