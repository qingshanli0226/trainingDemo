package com.example.player.a1610aplayerdemo.study;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.study.adapter.VipAdapter;
import com.example.player.a1610aplayerdemo.study.bean.VipBean;
import com.example.player.a1610aplayerdemo.study.presenter.VipPresenter;
import com.scwang.smartrefresh.header.WaterDropHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudyFragment extends Fragment implements IBaseView<List<VipBean>>, VipAdapter.OnItemClickListener {
    @BindView(R.id.vip_rv)
    RecyclerView vipRv;
    Unbinder unbinder;
    @BindView(R.id.vip_srl)
    SmartRefreshLayout vipSrl;
    private IBasePresenter iBasePresenter;
    private VipAdapter vipAdapter;
    private List<VipBean> vipBeans;

    public StudyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iBasePresenter = new VipPresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_study, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        iBasePresenter.attachView(this);
        iBasePresenter.getData();
        return view;
    }

    private void initView() {
        vipRv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        vipSrl.setRefreshHeader(new WaterDropHeader(getActivity()));
        vipSrl.setRefreshFooter(new BallPulseFooter(getActivity()));

        vipSrl.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                iBasePresenter.getData();
                refreshlayout.finishRefresh();
            }
        });

        vipSrl.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                Toast.makeText(getActivity(), "数据加载完毕，暂无更多数据", Toast.LENGTH_SHORT).show();
                refreshlayout.finishLoadmore();
            }
        });
    }

    @Override
    public void onLoadData(List<VipBean> data) {
        vipBeans = new ArrayList<>();
        vipBeans.addAll(data);

        vipAdapter = new VipAdapter();
        vipAdapter.setOnItemClickListener(this);
        vipAdapter.updateData(vipBeans);
        vipRv.setAdapter(vipAdapter);
        vipAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadError(int code, String message) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        iBasePresenter.detachView();
        unbinder.unbind();
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getActivity(), "" + vipBeans.get(position).getName(), Toast.LENGTH_SHORT).show();
    }
}
