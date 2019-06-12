package com.example.player.a1610aplayerdemo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.common.HomeBean;

import java.util.List;

    public class Adapter_CourseSpecialGridView extends BaseAdapter {
        private Context mContext;
        private HomeBean mBean;
        private List<HomeBean.DataBean.ZlListBean> zlList;

        public Adapter_CourseSpecialGridView(Context context, HomeBean bean) {
            mContext = context;
            mBean = bean;
            zlList = mBean.getData().getZlList();
            Log.e("获取的图片个数","==>"+zlList.size());
        }

        @Override
        public int getCount() {
            return zlList.size();
        }

        @Override
        public Object getItem(int position) {
            return zlList.get(position);
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
                convertView = View.inflate(mContext, R.layout.course_layout_special_gv_item,null);
                holder.mImageView = (ImageView)convertView.findViewById(R.id.specialPageItemImg);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            HomeBean.DataBean.ZlListBean zlListBean = zlList.get(position);
            String image = zlListBean.getImage();
            Glide.with(convertView.getContext()).load(image).into(holder.mImageView);

            return convertView;
        }
        class ViewHolder{
            ImageView mImageView;
        }

    }
