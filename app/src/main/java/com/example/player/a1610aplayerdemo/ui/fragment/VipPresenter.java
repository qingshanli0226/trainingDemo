package com.example.player.a1610aplayerdemo.ui.fragment;

import com.example.player.a1610aplayerdemo.base.BasePresenter;
import com.example.player.a1610aplayerdemo.bean.MemberBean;
import com.example.player.a1610aplayerdemo.utils.Constans;
import com.example.player.a1610aplayerdemo.utils.EntityUtils;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Lmz on 2019/06/12
 * vip页面的presenter
 */
public class VipPresenter extends BasePresenter<MemberBean.DataBean> {
   private String params;
   private String size;
   public void setParams(String params,String size){
       this.params =params;
       this.size =size;
   }

    @Override
    public String getApiPath() {
        return "masterPackage";
    }

    @Override
    public String getApiPath2() {
        return "getMasterPackagelist";
    }

    @Override
    public Type getType() {
        return new TypeToken<EntityUtils<List<MemberBean.DataBean>>>(){}.getType();
    }

    @Override
    public int isList() {
        return Constans.DATA_TYPE_LIST;
    }
}
