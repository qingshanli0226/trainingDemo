package com.example.hasee.dreamvideo.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.hasee.dreamvideo.bean.HomeBean
import com.example.hasee.dreamvideo.widget.HomeItemView

/**
 * Created by Lmz on 2019/06/09
 */
class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    private var list =ArrayList<HomeBean.DataBean.ListBean>()
    fun Refresh(list: MutableList<HomeBean.DataBean.ListBean>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
    fun LoadMore(list: MutableList<HomeBean.DataBean.ListBean>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): HomeViewHolder {
        return HomeViewHolder(HomeItemView(parent?.context))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(vh: HomeViewHolder, position: Int) {
        //获取每一个条目的数据
        val data  = list.get(position)
        //设置条目的view    as 是强转的意思
        val itemview = vh.itemView as HomeItemView
        //给条目设置数据
        itemview.setData(data)
    }

    class HomeViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){

    }
}