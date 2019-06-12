package com.example.player.a1610aplayerdemo.choice;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseAdapter;
import com.example.player.a1610aplayerdemo.base.BaseFragment;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.bean.MainBean;

import java.util.ArrayList;
import java.util.List;

public class ChoiceFragment extends BaseFragment<Object,View> {
    @Override
    protected void setTitleBar(ImageView titlebar_left, ImageView titlebar_right, RelativeLayout titlebar_search, TextView titlebar_title) {
        titlebar_left.setImageResource(R.drawable.ic_action_main_my);
        titlebar_right.setVisibility(View.GONE);
        titlebar_title.setVisibility(View.GONE);
        titlebar_search.setVisibility(View.VISIBLE);
    }

    private ChoiceAdapter adapter = new ChoiceAdapter();
    @Override
    public BaseAdapter getBaseAdapter() {
        return adapter;
    }

    @Override
    public IBasePresenter getiBasePresenter() {
        return new ChoicePresenter();
    }

    @Override
    public void onLoadDataObject(Object oo) {
        super.onLoadDataObject(oo);
        List<Object> objects = new ArrayList<>();

        MainBean o = (MainBean) oo;

        objects.add(0,o.getHomeBanner());
//        objects.add(1,o.getHomeCategory());
//        objects.add(2,o.getVipRecommend());
//        objects.add(3,o.getZlList());
//        objects.add(4,o.getCourseRecommends());
//        objects.add(5,o.getMasterLives());

        adapter.updataData(objects);

    }


}
