package com.example.player.a1610aplayerdemo.ui.xuankeadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.XuanKeDateBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ZhuanLanAdp extends BaseAdapter {

    List<XuanKeDateBean.DataBean.ZlListBean> dataBeanList = new ArrayList<>();

    public void updateData(List<XuanKeDateBean.DataBean.ZlListBean> dataBeans) {
        dataBeanList.clear();
        dataBeanList.addAll(dataBeans);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return dataBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.zhuanlan_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.zhualan_img);
        Picasso.get().load(dataBeanList.get(position).getImage()).into(imageView);



        return convertView;
    }
}
