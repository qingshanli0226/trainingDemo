package com.example.player.a1610aplayerdemo.fragment.selectclass.master;

import android.content.Context;
import android.view.View;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.fragment.selectclass.bean.GetHomeBean;

public class Master_Rv_adapter extends BaseRecyclerViewAdapter<GetHomeBean.DataBean.MasterLivesBean, MstItemView> {
    @Override
    public MstItemView getItemView(Context context, int viewType) {
        return new MstItemView(context);
    }

    @Override
    protected int getViewType(int position) {
        return 0;
    }

    @Override
    public void refreshItemUi(MstItemView itemView, GetHomeBean.DataBean.MasterLivesBean masterLivesBean, int position) {
        itemView.setData(masterLivesBean);
    }


}
