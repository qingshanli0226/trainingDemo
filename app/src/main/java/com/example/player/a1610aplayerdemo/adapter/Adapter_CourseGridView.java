package com.example.player.a1610aplayerdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.common.HomeBean;

import java.util.List;

public class Adapter_CourseGridView extends BaseAdapter {
    private Context mContext;
    private HomeBean mBean;
    private List<HomeBean.DataBean.HomeCategoryBean> homeCategory;

    public Adapter_CourseGridView(Context context, HomeBean bean) {
        mContext = context;
        mBean = bean;
        homeCategory = mBean.getData().getHomeCategory();
    }

    @Override
    public int getCount() {
        return homeCategory.size();
    }

    @Override
    public Object getItem(int position) {
        return homeCategory.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.course_layout_gride_item,null);
            holder.mImageView = (ImageView)convertView.findViewById(R.id.gridView_Item_Image);
            holder.mTextView = (TextView)convertView.findViewById(R.id.gridView_Item_Text);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        HomeBean.DataBean.HomeCategoryBean homeCategoryBean = homeCategory.get(position);
        holder.mTextView.setText(homeCategoryBean.getTitle());
        Glide.with(convertView.getContext()).load(homeCategoryBean.getBannerUrl()).into(holder.mImageView);
        return convertView;

    }
    class ViewHolder{
        ImageView mImageView;
        TextView mTextView;
    }
}
