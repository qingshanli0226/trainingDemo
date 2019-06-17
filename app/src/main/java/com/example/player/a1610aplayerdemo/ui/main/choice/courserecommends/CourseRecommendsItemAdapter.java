package com.example.player.a1610aplayerdemo.ui.main.choice.courserecommends;

import android.content.Context;
import android.view.View;
import com.example.player.a1610aplayerdemo.base.BaseAdapter;
import com.example.player.a1610aplayerdemo.bean.MainBean;

public class CourseRecommendsItemAdapter extends BaseAdapter<MainBean.CourseRecommendsBean,CourseRecommendsItemView> {
    @Override
    protected int getViewType(int position) {
        return 0;
    }

    @Override
    protected CourseRecommendsItemView getView(Context context, int i) {
        return new CourseRecommendsItemView(context);
    }

    @Override
    protected void setItemView(View itemView, MainBean.CourseRecommendsBean courseRecommendsBean, int i) {
        CourseRecommendsItemView view = (CourseRecommendsItemView) itemView;
        view.setCourseItem(courseRecommendsBean,i);
    }
}
