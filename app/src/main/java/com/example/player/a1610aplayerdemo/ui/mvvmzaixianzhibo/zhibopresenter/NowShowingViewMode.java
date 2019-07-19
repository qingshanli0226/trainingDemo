package com.example.player.a1610aplayerdemo.ui.mvvmzaixianzhibo.zhibopresenter;

import android.util.Log;
import com.example.player.a1610aplayerdemo.ui.mvvmzaixianzhibo.mvvmbase.IDataListener;
import com.example.player.a1610aplayerdemo.ui.mvvmzaixianzhibo.mvvmbase.IMode;
import com.example.player.a1610aplayerdemo.bean.NowZhiBoDateBean;

import java.util.List;

public class NowShowingViewMode implements IShowingViewMode{
    private IZhiBoView iZhiBoView;
    private IMode<List<NowZhiBoDateBean>> ishowMode = new ZhiBoMode();

    public NowShowingViewMode() {
    }

    @Override
    public void getZiBoDate() {
        ishowMode.getDate(new IDataListener<List<NowZhiBoDateBean>>() {
            @Override
            public void onGetData(List<NowZhiBoDateBean> date) {

                iZhiBoView.onGetZhiBoList(date);

            }

            @Override
            public void onGetDataFailed(int code, String message) {

                iZhiBoView.onGetZhiBoFailed(1,message);

            }
        });
    }

    @Override
    public void attachView(IZhiBoView iZhiBoView) {
        this.iZhiBoView = iZhiBoView;
    }

    @Override
    public void detachView() {
        iZhiBoView = null;
    }
}
