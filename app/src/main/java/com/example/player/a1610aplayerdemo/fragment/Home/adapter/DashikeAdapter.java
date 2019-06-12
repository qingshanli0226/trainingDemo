package com.example.player.a1610aplayerdemo.fragment.Home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.MyApp;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.fragment.Home.bean.SelectorBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DashikeAdapter extends BaseAdapter {

    List<SelectorBean.MasterLivesBean> livesBeans=new ArrayList<>();
    public void refresh(List<SelectorBean.MasterLivesBean> masterLivesBeans){
        livesBeans.clear();
        livesBeans.addAll(masterLivesBeans);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return livesBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return livesBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView= LayoutInflater.from(MyApp.instance).inflate(R.layout.dashike_item,null);
        }
        ImageView imageView = convertView.findViewById(R.id.ds_img);
        Picasso.with(MyApp.instance).load(livesBeans.get(position).getImageUrl()).into(imageView);

        TextView bt = convertView.findViewById(R.id.ds_txr);
        bt.setText(livesBeans.get(position).getAppTitle());

        TextView price = convertView.findViewById(R.id.ds_price);
        price.setText(livesBeans.get(position).getPrice()+"元");

        TextView js = convertView.findViewById(R.id.ds_jiangshi);
        js.setText("讲师:"+livesBeans.get(position).getTeacherName());

        return convertView;
    }
}
