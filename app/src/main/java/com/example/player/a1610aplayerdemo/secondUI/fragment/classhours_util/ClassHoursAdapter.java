package com.example.player.a1610aplayerdemo.secondUI.fragment.classhours_util;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.secondUI.bean.BannerBean;

import java.util.List;

public class ClassHoursAdapter extends BaseRecyclerViewAdapter<BannerBean.DataBean.ChaptersBean, View> {

    public ClassHoursAdapter(List<BannerBean.DataBean.ChaptersBean> list, Context context, int type) {
        super(list, context, type);
    }

    @Override
    public void refreshItemUi(BaseViewHolder holder, BannerBean.DataBean.ChaptersBean itemData, int position) {
        final TextView textViewshowIndex = holder.itemView.findViewById(R.id.showIndexText);
        final TextView textViewname = holder.itemView.findViewById(R.id.name);
        textViewshowIndex.setText(itemData.getShowIndexText());
        textViewname.setText(itemData.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewshowIndex.setTextColor(Color.parseColor("#8E002E"));
                textViewname.setTextColor(Color.parseColor("#8E002E"));
            }
        });
    }
}
