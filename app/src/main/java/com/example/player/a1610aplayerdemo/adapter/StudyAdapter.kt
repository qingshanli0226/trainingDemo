package com.example.player.a1610aplayerdemo.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

class StudyAdapter: RecyclerView.Adapter<StudyAdapter.MyViewHolders>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolders {
        return MyViewHolders(StudyItemView(p0?.context))
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(p0: MyViewHolders, p1: Int) {

    }

    class MyViewHolders(itemview: View):RecyclerView.ViewHolder(itemview){

    }
}