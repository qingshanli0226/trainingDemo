package com.example.player.a1610aplayerdemo.ui.mvvmzaixianzhibo.zhiboadapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.player.a1610aplayerdemo.BR;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.NowZhiBoDateBean;

import java.util.ArrayList;
import java.util.List;

public class NowZhiBoAdp extends RecyclerView.Adapter<NowZhiBoAdp.ZhiBoShowViewHolder>{
    private List<NowZhiBoDateBean> boDateBeans = new ArrayList<>();

    public void upadateBooks(List<NowZhiBoDateBean> bookBeans) {
        boDateBeans.clear();
        boDateBeans.addAll(bookBeans);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ZhiBoShowViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.zaixianzhiboitem, viewGroup, false);

        return new ZhiBoShowViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ZhiBoShowViewHolder zhiBoShowViewHolder, int i) {
        zhiBoShowViewHolder.viewDataBinding.setVariable(BR.zaixianShow,boDateBeans.get(i));
    }

    @Override
    public int getItemCount() {
        return boDateBeans.size();
    }

    public class ZhiBoShowViewHolder extends RecyclerView.ViewHolder {
        public ViewDataBinding viewDataBinding;

        public ZhiBoShowViewHolder(@NonNull ViewDataBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            this.viewDataBinding = viewDataBinding;
        }
    }

}
