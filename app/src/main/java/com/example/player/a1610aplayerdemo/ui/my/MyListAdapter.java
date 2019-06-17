package com.example.player.a1610aplayerdemo.ui.my;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;

import java.util.List;

public class MyListAdapter extends BaseAdapter {
    private Context context;
    private List<MyListBean> listBeans;

    public MyListAdapter(Context context, List<MyListBean> listBeans) {
        this.context = context;
        this.listBeans = listBeans;
    }

    @Override
    public int getCount() {
        return listBeans.size();
    }

    @Override
    public Object getItem(int i) {
        return listBeans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyListViewHolder myListViewHolder;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.fragment_my_list_item, viewGroup, false);
            myListViewHolder = new MyListViewHolder();
            myListViewHolder.imageView = view.findViewById(R.id.iv);
            myListViewHolder.textView = view.findViewById(R.id.tv);
            view.setTag(myListViewHolder);
        }else{
            myListViewHolder = (MyListViewHolder) view.getTag();
        }
        MyListBean myListBean = listBeans.get(i);
        myListViewHolder.textView.setText(myListBean.getString());
        myListViewHolder.imageView.setImageResource(myListBean.getInteger());
        return view;
    }

    class MyListViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
