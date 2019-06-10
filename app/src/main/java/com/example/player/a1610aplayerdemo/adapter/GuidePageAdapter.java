package com.example.player.a1610aplayerdemo.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.example.player.a1610aplayerdemo.R;

import java.util.ArrayList;
import java.util.List;

public class GuidePageAdapter extends PagerAdapter {
    private List<View> viewList;
    private int[] mResIds=new int[]{R.mipmap.tp01,R.mipmap.tp02,R.mipmap.tp03,R.mipmap.tp04};


    public GuidePageAdapter(List<View> viewList) {
        this.viewList = viewList;
    }

    @Override
    public int getCount() {
        if (viewList!=null){
            return viewList.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view=viewList.get(position);
        int count=getCount();
        ViewGroup.LayoutParams params=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        view.setBackgroundResource(mResIds[position%count]);
        view.setLayoutParams(params);
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
        container.removeView(viewList.get(position));
    }
}
