package com.example.player.a1610aplayerdemo.cateactivity.presenter;

import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.cateactivity.Bean.CateGoryBean;

import java.util.List;

public class CateGoryContract {

    public interface ILoadCateGoryBean  {
        void getCateGoryBean(String url);
    }

    public interface ICateGoryState{
        void succssful(List<CateGoryBean.DataBean> bean);
    }

}
