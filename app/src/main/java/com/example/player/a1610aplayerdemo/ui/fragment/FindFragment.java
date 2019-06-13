package com.example.player.a1610aplayerdemo.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.service.BaseService;
import com.example.player.a1610aplayerdemo.bean.HomeBean;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.TokenBean;
import com.example.player.a1610aplayerdemo.adapter.FindsAdapter;
import com.example.player.a1610aplayerdemo.base.BaseFragment;
import com.example.player.a1610aplayerdemo.presenter.FindPresenter;
import com.example.player.a1610aplayerdemo.util.SharedPreferenceToken;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.gson.Gson;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.HashMap;
import java.util.Map;

public class FindFragment extends BaseFragment implements IBaseView<String> {

    private RecyclerView recyclerView1;
    SharedPreferenceToken sharedPreferenceToken;
    IBasePresenter findPresenter;
    @Override
    protected View getContentView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        recyclerView1 = view.findViewById(R.id.recycler1);
        sharedPreferenceToken = new SharedPreferenceToken(getContext());
        final String token = sharedPreferenceToken.getToken();
        if (token==null){
            getTokenData();
        }
        Fresco.initialize(getContext());
        findPresenter = new FindPresenter();
        findPresenter.attachView(this);
        findPresenter.getData();
        return view;
    }



    private void getTokenData() {
        Map<String,String> map = new HashMap<>();
        map.put("product","PD1709+");
        map.put("device","PD1709");
        map.put("brand","vivo+");
        map.put("deviceKey","45F582DF57D4AA6D53455B181C338859");
        map.put("sdkVersion","19");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.immedc.com/restapi/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(BaseService.class)
                .getTokenData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TokenBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TokenBean tokenBean) {

                        sharedPreferenceToken.SaveToken(tokenBean.getData().getAccessToken());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("我",e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        findPresenter.detachView();
    }

    @Override
    public void onLoadData(String data) {

        Gson gson = new Gson();
        HomeBean homeBean = gson.fromJson(data, HomeBean.class);
        HomeBean.DataBean data1 = homeBean.getData();
        FindsAdapter findsAdapter = new FindsAdapter();
        findsAdapter.refresh(data1);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView1.setAdapter(findsAdapter);
        recyclerView1.setLayoutManager(manager);
    }



    @Override
    public void onLoadError(int code, String message) {

    }
}
