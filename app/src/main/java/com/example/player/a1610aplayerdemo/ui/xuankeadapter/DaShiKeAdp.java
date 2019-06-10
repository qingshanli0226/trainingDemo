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

public class DaShiKeAdp extends BaseAdapter {

    List<XuanKeDateBean.DataBean.MasterLivesBean> dataBeanList = new ArrayList<>();

    public void updateData(List<XuanKeDateBean.DataBean.MasterLivesBean> dataBeans) {
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashike_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.ds_img);
        Picasso.get().load(dataBeanList.get(position).getImageUrl()).into(imageView);

       TextView bt = convertView.findViewById(R.id.ds_txr);
       bt.setText(dataBeanList.get(position).getAppTitle());

       TextView price = convertView.findViewById(R.id.ds_price);
       price.setText(dataBeanList.get(position).getPrice()+"元");

       TextView js = convertView.findViewById(R.id.ds_jiangshi);
       js.setText("讲师:"+dataBeanList.get(position).getTeacherName());

        return convertView;
    }
}
