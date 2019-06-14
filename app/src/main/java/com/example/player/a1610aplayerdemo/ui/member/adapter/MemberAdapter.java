package com.example.player.a1610aplayerdemo.ui.member.adapter;

import android.content.Context;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.ui.member.bean.MemberBean;
import com.example.player.a1610aplayerdemo.ui.member.view.IMemberView;

public class MemberAdapter extends BaseRecyclerViewAdapter<MemberBean.DataBean, IMemberView> {
    @Override
    protected IMemberView getItemView(Context context) {
        return new IMemberView(context);
    }

    @Override
    protected void refreshItemUi(IMemberView itemView, MemberBean.DataBean dataBean) {
        itemView.updateImg(dataBean.getImage());
    }

}