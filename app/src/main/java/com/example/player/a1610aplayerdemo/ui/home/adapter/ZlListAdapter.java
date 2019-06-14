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

public class ZlListAdapter extends BaseAdapter {
    private Context context;
    private List<HomeBean.DataBean.ZlListBean> listBeans;

    public ZlListAdapter(Context context, List<HomeBean.DataBean.ZlListBean> listBeans) {
        this.context = context;
        this.listBeans = listBeans;
    }

    @Override
    public int getCount() {
        return listBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return listBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HolderView holderView = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_zllist_adapter,parent,false);
            holderView = new HolderView();
            holderView.vip_image = convertView.findViewById(R.id.zllist_image);
            holderView.vip_tv = convertView.findViewById(R.id.zllist_tv);
            convertView.setTag(holderView);
        }else {
            holderView = (HolderView) convertView.getTag();
        }
        Picasso.get().load(listBeans.get(position).getImage()).into(holderView.vip_image);
        holderView.vip_tv.setText(listBeans.get(position).getTitle());
        return convertView;
    }

    class HolderView{
        ImageView vip_image;
        TextView vip_tv;
    }

}