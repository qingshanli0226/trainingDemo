package com.example.player.a1610aplayerdemo.ui.musicpresenter;

import com.example.player.a1610aplayerdemo.bean.MusicClassBean;
import com.example.player.a1610aplayerdemo.bean.TuiJianDateBean;
import com.example.player.a1610aplayerdemo.net.MVPObserver;
import com.example.player.a1610aplayerdemo.net.MyNetFunction;
import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.ui.tuijianpresenter.TuiJianInterface;
import com.example.player.a1610aplayerdemo.util.DeviceKye;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusicClassPresenterCompl implements MusicClassInterface.IMusicClassPresenter{

    MusicClassInterface.MusicClassView tuiJianView;

    public MusicClassPresenterCompl(MusicClassInterface.MusicClassView tuiJianView) {
        this.tuiJianView = tuiJianView;
    }

    @Override
    public void  getMusicClassData(String s) {

        Map<String, String> map = new HashMap<>();
        map.put("pid", s);


        Map headmap = new HashMap<>();
        headmap.put("deviceKey", DeviceKye.getDeviceKye());

        RetrofitCreator.getApiService().getMusicClassDate(headmap,map)
                .subscribeOn(Schedulers.io())
                .map(new MyNetFunction<ResEntity<List<MusicClassBean>>,List<MusicClassBean>>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MVPObserver<List<MusicClassBean>>(){
                    @Override
                    public void onNext(List<MusicClassBean> musicClassBeans) {
                        super.onNext(musicClassBeans);
                        tuiJianView.onGetDataSuccess(musicClassBeans);
                    }
                });
    }
    @Override
    public void detachView() {
       tuiJianView = null;
    }
}
