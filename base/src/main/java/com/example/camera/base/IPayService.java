package com.example.camera.base;

import android.content.Context;

public interface IPayService {
    void pay(Context context, String user, float price, IPayCallback callback);
}
