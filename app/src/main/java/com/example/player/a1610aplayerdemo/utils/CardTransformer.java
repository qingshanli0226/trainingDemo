package com.example.player.a1610aplayerdemo.utils;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Lmz on 2019/06/12
 *  fragment 偏移设置
 */
public class CardTransformer implements ViewPager.PageTransformer{
    @Override
    public void transformPage(@NonNull View view, float position) {
            if (position<0){
                view.setTranslationX(-position*view.getWidth());
                //调整位置
            }
    }
}
