package com.example.player.a1610aplayerdemo.choice.masterlives;

import android.content.Context;
import android.view.View;
import com.example.player.a1610aplayerdemo.base.BaseAdapter;
import com.example.player.a1610aplayerdemo.bean.MainBean;
import com.example.player.a1610aplayerdemo.choice.courserecommends.CourseRecommendsItemView;

public class MasterLivesItemAdapter extends BaseAdapter<MainBean.MasterLivesBean,MasterLivesItemView> {
    @Override
    protected int getViewType(int position) {
        return 0;
    }

    @Override
    protected MasterLivesItemView getView(Context context, int i) {
        return new MasterLivesItemView(context);
    }


    @Override
    protected void setItemView(View itemView, MainBean.MasterLivesBean masterLivesBean, int i) {
        MasterLivesItemView masterLivesItemView = (MasterLivesItemView) itemView;
        masterLivesItemView.setMasterItem(masterLivesBean,i);
    }

}
