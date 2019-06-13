package com.example.player.a1610aplayerdemo.vip;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.Constant;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseAdapter;
import com.example.player.a1610aplayerdemo.base.BaseFragment;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.bean.Bean;
import com.example.player.a1610aplayerdemo.bean.VipDataBean;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.utils.TokenSp;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public class VIPFragment extends Fragment {

    private ImageView titlebar_right;
    private ImageView titlebar_left;
    private RelativeLayout titlebar_search;
    private TextView titlebar_title;
    private RecyclerView recyclerView;
    private Context context;
    private VipAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_vip, container, false);
        init(inflate);
        return inflate;
    }

    private void init(View inflate) {
        titlebar_left = inflate.findViewById(R.id.titlebar_left);
        titlebar_right = inflate.findViewById(R.id.titlebar_right);
        titlebar_search = inflate.findViewById(R.id.titlebar_search);
        titlebar_title = inflate.findViewById(R.id.titlebar_title);
        titlebar_left.setVisibility(View.GONE);
        titlebar_right.setVisibility(View.GONE);
        titlebar_search.setVisibility(View.GONE);
        titlebar_title.setVisibility(View.VISIBLE);
        titlebar_title.setText("会员");
        recyclerView = inflate.findViewById(R.id.vip_vip_recycler);
        LinearLayoutManager manager = new LinearLayoutManager(inflate.getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        context = inflate.getContext();
        adapter = new VipAdapter(context);
        recyclerView.setAdapter(adapter);
        getData();


    }

    private void getData() {
        String token = TokenSp.getInstance().getToken();
        Log.e("123456", "getData: "+token);
        Map<String, String> map = new HashMap<>();
        map.put("Android-channel", "guoyun");
        map.put("Android-VersionCode", "43");
        map.put("DeviceKey", Constant.DeviceKey);
        map.put("Tingyun_Process", "true");
        map.put("CH-TOKEN", token);
        RetrofitCreator.getInstance().getIServiceApi()
                .getVipData(map,"/restapi/masterPackage/getMasterPackagelist?minid=0&size=20")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<Bean<List<VipDataBean>>, List<VipDataBean>>() {
                    @Override
                    public List<VipDataBean> apply(Bean<List<VipDataBean>> listBean) throws Exception {
                        return listBean.getData();
                    }
                })
                .subscribe(new Observer<List<VipDataBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<VipDataBean> vipDataBeans) {

                        adapter.upData(vipDataBeans);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
