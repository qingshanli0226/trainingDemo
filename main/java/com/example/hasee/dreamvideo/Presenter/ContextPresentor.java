package com.example.hasee.dreamvideo.Presenter;

import com.example.hasee.dreamvideo.bean.HomeBean;

/**
 * Created by Lmz on 2019/06/09
 *  总的 presenter类
 */
public class ContextPresentor {

    public interface IHomePresenter{
        void getHomeinfo(String pagesize,String page);
    }
    public interface IHomeView{
        void getHomeInfoSuccess(HomeBean bean);
        void getHomeInfoFailure(String mess);
    }
}
