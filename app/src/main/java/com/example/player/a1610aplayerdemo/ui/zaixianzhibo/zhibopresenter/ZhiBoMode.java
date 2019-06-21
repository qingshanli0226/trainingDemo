package com.example.player.a1610aplayerdemo.ui.zaixianzhibo.zhibopresenter;

import com.example.player.a1610aplayerdemo.baseclassextraction.BaseMode;
import com.example.player.a1610aplayerdemo.bean.NowZhiBoDateBean;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ZhiBoMode extends BaseMode<List<NowZhiBoDateBean>> {
    @Override
    public String getAPIPath1() {
        return null;
    }

    @Override
    public String getAPIPath2() {
        return null;
    }

    @Override
    public Type getDataType() {
         return new TypeToken<List<NowZhiBoDateBean>>(){}.getType();
    }
}
