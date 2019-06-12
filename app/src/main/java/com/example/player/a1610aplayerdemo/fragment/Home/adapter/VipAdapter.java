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
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class VipAdapter extends BaseAdapter {
    List<SelectorBean.VipRecommendBean> list=new ArrayList<>();
    public void refresh(List<SelectorBean.VipRecommendBean> lists){
            list.clear();
            list.addAll(lists);
            notifyDataSetChanged();
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
        if (convertView == null) {
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.vip_item,null);
        }
        ImageView imageView=convertView.findViewById(R.id.vip_img);
        TextView textView=convertView.findViewById(R.id.vip_tv);
        Picasso.with(MyApp.instance).load(list.get(position).getImage())
                .into(imageView);
        textView.setText(list.get(position).getTitle());
        return convertView;
    }
}
