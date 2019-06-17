package com.example.player.a1610aplayerdemo.details.presenter;

import com.example.player.a1610aplayerdemo.details.bean.DetailsBean;

public class DetialsContract {

    public interface IDetialsPresenter{
        void getDetialsBean(String url);
        void dettach();
    }

    public interface IDetialsStatus{
        void succssful(DetailsBean detailsBean);
    }
}
