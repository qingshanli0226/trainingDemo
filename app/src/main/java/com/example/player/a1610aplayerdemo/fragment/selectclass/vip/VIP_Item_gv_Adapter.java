package com.example.player.a1610aplayerdemo.fragment.selectclass.vip;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.fragment.selectclass.bean.GetHomeBean;

import java.util.ArrayList;
import java.util.List;


public class VIP_Item_gv_Adapter extends BaseAdapter {

    private List<GetHomeBean.DataBean.VipRecommendBean> list = new ArrayList<>();
    public void refreshData( List<GetHomeBean.DataBean.VipRecommendBean> list){
        Log.i("bbb", "refreshData: "+list.size());
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyVIPViewHolder myCourseViewHolder = null;
        if (view == null){
            myCourseViewHolder = new MyVIPViewHolder();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_vpi_grideview,null);
            myCourseViewHolder.course_img = view.findViewById(R.id.item_vpi_img);
            myCourseViewHolder.course_title = view.findViewById(R.id.item_vpi_title);
            myCourseViewHolder.course_vip_tv = view.findViewById(R.id.item_vip_tv);
            view.setTag(myCourseViewHolder);
        }else {
            myCourseViewHolder = (MyVIPViewHolder) view.getTag();
        }

        Glide.with(viewGroup.getContext()).load(list.get(i).getImage()).into(myCourseViewHolder.course_img);
        myCourseViewHolder.course_title.setText(list.get(i).getTitle());
        myCourseViewHolder.course_vip_tv.setText(list.get(i).getText1());

        return view;
    }
}

class MyVIPViewHolder {
    ImageView course_img;
    TextView course_title;
    TextView course_vip_tv;

}
