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

public class HomeCategoryAdp extends BaseAdapter {

    List<XuanKeDateBean.DataBean.HomeCategoryBean> dataBeanList = new ArrayList<>();

    public void updateData(List<XuanKeDateBean.DataBean.HomeCategoryBean> dataBeans) {
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.homecategory_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.gory_img);
        Picasso.get().load(dataBeanList.get(position).getBannerUrl()).into(imageView);

        TextView textView = convertView.findViewById(R.id.gory_txt);
        textView.setText(dataBeanList.get(position).getTitle());

        return convertView;
    }
}
