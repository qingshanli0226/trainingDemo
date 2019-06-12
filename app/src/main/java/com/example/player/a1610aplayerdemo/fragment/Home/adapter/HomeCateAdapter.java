package com.example.player.a1610aplayerdemo.fragment.Home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.fragment.Home.bean.SelectorBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class HomeCateAdapter extends BaseAdapter {
    List<SelectorBean.HomeCategoryBean> beans=new ArrayList<>();
    public void refresh(List<SelectorBean.HomeCategoryBean> list){
        beans.clear();
        beans.addAll(list);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return beans.size();
    }

    @Override
    public Object getItem(int position) {
        return beans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cate_item,parent,false);
        }
        TextView textView=convertView.findViewById(R.id.gory_txt);
        ImageView imageView=convertView.findViewById(R.id.gory_img);
        Picasso.with(parent.getContext()).load(beans.get(position).getBannerUrl()).into(imageView);
        textView.setText(beans.get(position).getTitle());
        return convertView;
    }
}
