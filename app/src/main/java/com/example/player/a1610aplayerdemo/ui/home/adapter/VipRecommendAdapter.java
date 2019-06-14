package com.example.player.a1610aplayerdemo.ui.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.ui.home.bean.HomeBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class VipRecommendAdapter extends BaseAdapter {
    private Context context;
    private List<HomeBean.DataBean.VipRecommendBean> list = new ArrayList<>();

    public VipRecommendAdapter(Context context, List<HomeBean.DataBean.VipRecommendBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HolderView holderView = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_viprecommend_adapter,parent,false);
            holderView = new HolderView();
            holderView.vip_image = convertView.findViewById(R.id.vip_image);
            holderView.vip_tv1 = convertView.findViewById(R.id.vip_tv1);
            holderView.vip_tv2 = convertView.findViewById(R.id.vip_tv2);
            convertView.setTag(holderView);
        }else {
            holderView = (HolderView) convertView.getTag();
        }

        Picasso.get().load(list.get(position).getImage()).into(holderView.vip_image);
        holderView.vip_tv1.setText(list.get(position).getTitle());
        holderView.vip_tv2.setText(list.get(position).getText1());

        return convertView;
    }

    class HolderView{
        ImageView vip_image;
        TextView vip_tv1;
        TextView vip_tv2;
    }

}