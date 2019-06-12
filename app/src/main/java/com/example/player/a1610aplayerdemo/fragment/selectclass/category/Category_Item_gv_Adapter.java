package com.example.player.a1610aplayerdemo.fragment.selectclass.category;

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


public class Category_Item_gv_Adapter extends BaseAdapter {

    private List<GetHomeBean.DataBean.HomeCategoryBean> list = new ArrayList<>();
    public void refreshData( List<GetHomeBean.DataBean.HomeCategoryBean> list){
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
        MyCaegoryViewHolder myCaegoryViewHolder = null;
        if (view == null){
            myCaegoryViewHolder = new MyCaegoryViewHolder();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gridview,null);
            myCaegoryViewHolder.imageView = view.findViewById(R.id.grideview_img);
            myCaegoryViewHolder.textView = view.findViewById(R.id.grideview_name);
            view.setTag(myCaegoryViewHolder);
        }else {
            myCaegoryViewHolder = (MyCaegoryViewHolder) view.getTag();
        }

        Glide.with(viewGroup.getContext()).load(list.get(i).getBannerUrl()).into(myCaegoryViewHolder.imageView);
        myCaegoryViewHolder.textView.setText(list.get(i).getTitle());

        return view;
    }
}

class MyCaegoryViewHolder{
    ImageView imageView;
    TextView textView;

}
