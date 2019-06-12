package com.example.player.a1610aplayerdemo.fragment.Home.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.example.player.a1610aplayerdemo.MyApp;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseViewHolder;
import com.example.player.a1610aplayerdemo.fragment.Home.bean.SelectorBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ZhuanLanAdapter extends BaseAdapter {

    List<SelectorBean.ZlListBean> selectorBeans=new ArrayList<>();
    public void refresh(List<SelectorBean.ZlListBean> listBeans){
        selectorBeans.clear();
        selectorBeans.addAll(listBeans);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return selectorBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return selectorBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.zl_item,null);
        }
        ImageView imageView=convertView.findViewById(R.id.image_ima);
        Picasso.with(parent.getContext()).load(selectorBeans.get(position).getImage()).into(imageView);
        return convertView;
    }
}
