package com.example.compontentlibrary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.example.camera.base.Constant;
import com.example.camera.base.ILoginService;

public class LoginService implements ILoginService {
    @Override
    public void login(Context context, Bundle data) {
        Intent intent = new Intent();
        intent.setClass(context, LoginActivity.class);
        intent.putExtra(Constant.LOGIN_PARAMS, data);
        context.startActivity(intent);
    }
}
