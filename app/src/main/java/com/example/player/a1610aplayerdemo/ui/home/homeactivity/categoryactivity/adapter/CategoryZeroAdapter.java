package com.example.player.a1610aplayerdemo.ui.home.homeactivity.categoryactivity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.ui.home.homeactivity.categoryactivity.bean.CategoryZeroBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CategoryZeroAdapter extends BaseAdapter {
    private Context context;
    private List<CategoryZeroBean.DataBean> list = new ArrayList<>();

    public void updata(Context context, List<CategoryZeroBean.DataBean> list){
        this.context = context;
        this.list.clear();
        this.list.addAll(list);
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
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.categroyzero_item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.categoryzero_image);
            viewHolder.textView = convertView.findViewById(R.id.categoryzero_tv);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Picasso.get().load(list.get(position).getImage()).into(viewHolder.imageView);
        viewHolder.textView.setText(list.get(position).getShortName());
        return convertView;
    }

    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}