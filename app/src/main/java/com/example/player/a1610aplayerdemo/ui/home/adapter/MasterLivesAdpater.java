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

import java.util.List;

public class MasterLivesAdpater extends BaseAdapter {
    private Context context;
    private List<HomeBean.DataBean.MasterLivesBean> livesBeans;

    public MasterLivesAdpater(Context context, List<HomeBean.DataBean.MasterLivesBean> livesBeans) {
        this.context = context;
        this.livesBeans = livesBeans;
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
        HolderView holderView = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_masterlives_adapter,parent,false);
            holderView = new HolderView();
            holderView.masterlives_image = convertView.findViewById(R.id.masterlives_image);
            holderView.masterlives_tv1 = convertView.findViewById(R.id.masterlives_tv1);
            holderView.masterlives_tv2 = convertView.findViewById(R.id.masterlives_tv2);
            holderView.masterlives_tv3 = convertView.findViewById(R.id.masterlives_tv3);
            holderView.masterlives_tv4 = convertView.findViewById(R.id.masterlives_tv4);
            convertView.setTag(holderView);
        }else {
            holderView = (HolderView) convertView.getTag();
        }
        Picasso.with(context).load(livesBeans.get(position).getImageUrl()).into(holderView.masterlives_image);
        holderView.masterlives_tv1.setText(livesBeans.get(position).getAppTitle());
        holderView.masterlives_tv2.setText(livesBeans.get(position).getTeacherName());
        holderView.masterlives_tv3.setText(livesBeans.get(position).getTeacherTitle());
        holderView.masterlives_tv4.setText(livesBeans.get(position).getPrice() + "元");
        return convertView;
    }

    class HolderView{
        ImageView masterlives_image;
        TextView masterlives_tv1;
        TextView masterlives_tv2;
        TextView masterlives_tv3;
        TextView masterlives_tv4;
    }
}