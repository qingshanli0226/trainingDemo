package com.example.player.a1610aplayerdemo.member.adapter;

import android.content.Context;
import com.example.player.a1610aplayerdemo.base.BaseViewAdapter;
import com.example.player.a1610aplayerdemo.member.bean.MemberBean;
import com.example.player.a1610aplayerdemo.member.view.MemberItemView;

public class MemberAdapter extends BaseViewAdapter<MemberBean, MemberItemView> {
    @Override
    public MemberItemView getItemView(Context context) {
        return new MemberItemView(context);
    }

    @Override
    protected void refreshItemUi(MemberItemView itemView, MemberBean memberBean) {
        itemView.updateImg(memberBean.getImage());
    }
}
