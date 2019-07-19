package com.example.player.a1610aplayerdemo.fragment.selectclass.zl;

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
import com.example.player.a1610aplayerdemo.fragment.selectclass.zl.zlvideoactivity.onclickinterface.OnclickListener;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;


public class ZL_Item_gv_Adapter extends BaseAdapter {
   private OnclickListener onclickListener;
    private List<GetHomeBean.DataBean.ZlListBean> list = new ArrayList<>();
    public void refreshData( List<GetHomeBean.DataBean.ZlListBean> list){
        Log.i("bbb", "refreshData: "+list.size());
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void setOnclickListener(OnclickListener onclickListener) {
        this.onclickListener = onclickListener;
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        MyZLViewHolder myZLViewHolder = null;
        if (view == null){
            myZLViewHolder = new MyZLViewHolder();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_zl_grideview,null);
            myZLViewHolder.course_img = view.findViewById(R.id.item_zl_img);
            myZLViewHolder.course_title = view.findViewById(R.id.item_zl_title);
            view.setTag(myZLViewHolder);
        }else {
            myZLViewHolder = (MyZLViewHolder) view.getTag();
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onclickListener!=null){
                    onclickListener.onClick(i);
                }
            }
        });

        Glide.with(viewGroup.getContext()).load(list.get(i).getImage()).into(myZLViewHolder.course_img);
        myZLViewHolder.course_title.setText(list.get(i).getTitle());
        return view;
    }
}

class MyZLViewHolder {
    ImageView course_img;
    TextView course_title;
}
