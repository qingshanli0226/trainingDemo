package com.example.player.a1610aplayerdemo.curriculum.fragment;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.activity.VideoActivity;
import com.example.player.a1610aplayerdemo.curriculum.adapter.HourAdapter;
import com.example.player.a1610aplayerdemo.curriculum.bean.BannerBean;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HourListFragment extends Fragment implements HourAdapter.OnItemClickListener{


    @BindView(R.id.hourRv)
    RecyclerView hourRv;
    Unbinder unbinder;

    private HourReseiver hourReseiver;
    private BannerBean bannerBean;
    private List<BannerBean.ChaptersBean> chaptersBeans;
    private HourAdapter hourAdapter;

    public HourListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        hourReseiver = new HourReseiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.banner.message");
        getActivity().registerReceiver(hourReseiver, intentFilter);

        View view = inflater.inflate(R.layout.fragment_hour_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(getActivity(),VideoActivity.class);
        intent.putExtra("url","http://ivi.bupt.edu.cn/hls/cctv6hd.m3u8");
        startActivity(intent);
    }

    public class HourReseiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.banner.message")) {
                Bundle bundle = intent.getExtras();
                bannerBean = (BannerBean) bundle.getSerializable("bannerBean");
                initData();
            }
        }
    }

    private void initData() {
        hourRv.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        chaptersBeans = new ArrayList<>();
        chaptersBeans.addAll(bannerBean.getChapters());

        hourAdapter = new HourAdapter();
        hourAdapter.setOnItemClickListener(this);
        hourAdapter.updateData(chaptersBeans);
        hourRv.setAdapter(hourAdapter);
        hourAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(hourReseiver);
    }
}
