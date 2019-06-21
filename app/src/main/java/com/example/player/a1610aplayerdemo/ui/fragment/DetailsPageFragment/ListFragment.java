package com.example.player.a1610aplayerdemo.ui.fragment.DetailsPageFragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.adapter.DetailsPageAdapter;
import com.example.player.a1610aplayerdemo.base.BaseFragment;
import com.example.player.a1610aplayerdemo.net.bean.DetailBean2;

import java.util.List;

public class ListFragment extends BaseFragment{

    private DetailBean2.DataBean dataBean;
    private RecyclerView recyclerView;

    public void setDataBean(DetailBean2.DataBean dataBean) {
        this.dataBean = dataBean;
    }


    @Override
    protected View getContentView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.itemclick_list_fragment, container, false);
        List<DetailBean2.DataBean.ChaptersBean> chapters = dataBean.getChapters();
        recyclerView = view.findViewById(R.id.recyc);
        LinearLayoutManager manager =  new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        DetailsPageAdapter adapter = new DetailsPageAdapter(chapters,getContext(),R.layout.itemclick_list_fragment_item);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
