package com.example.player.a1610aplayerdemo.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.home.bean.HomeBean;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {
    private Context context;
    private List<HomeBean.DataBean.HomeCategoryBean> list;

    public CategoryAdapter(Context context, List<HomeBean.DataBean.HomeCategoryBean> list) {
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
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_category_adapter,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.category_iamge);
            viewHolder.textView = convertView.findViewById(R.id.category_tv);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(list.get(position).getBannerUrl()).into(viewHolder.imageView);
        viewHolder.textView.setText(list.get(position).getTitle());

        return convertView;
    }

    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }

}