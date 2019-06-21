package com.example.player.a1610aplayerdemo.ui.main.choice.second.detail.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.IMyClick;
import com.example.player.a1610aplayerdemo.bean.DetailBean;

import java.util.List;

public class ListOneAdapter extends BaseAdapter {
    private List<DetailBean.ChaptersBean> chaptersBeans;
    private Context context;
    private IMyClick iMyClick;


    public ListOneAdapter(List<DetailBean.ChaptersBean> chaptersBeans, Context context, IMyClick iMyClick) {
        this.chaptersBeans = chaptersBeans;
        this.context = context;
        this.iMyClick = iMyClick;
    }

    @Override
    public int getCount() {
        return chaptersBeans.size();
    }

    @Override
    public Object getItem(int i) {
        return chaptersBeans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.details_vp_list_one, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.jianjie = view.findViewById(R.id.jianjie);
            viewHolder.title = view.findViewById(R.id.list_one_title);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        DetailBean.ChaptersBean chaptersBean = chaptersBeans.get(i);
        final int a = i;
        viewHolder.jianjie.setText("简介");
        viewHolder.jianjie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iMyClick.setListItemJianJieClick(a);
            }
        });
        String name = chaptersBean.getName();
//        if(name == null){
//            Log.e("qwe", "getView: 名字是空");
//        }else{
//            if(viewHolder.title == null){
//                Log.e("qwe", "getView: 控件是空");
//            }else {
        viewHolder.title.setText(name);

//            }
//    }
        viewHolder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iMyClick.setListItemTitleClick(a);
            }
        });
        return view;
    }

    class ViewHolder {
        TextView title;
        TextView jianjie;
    }
}
