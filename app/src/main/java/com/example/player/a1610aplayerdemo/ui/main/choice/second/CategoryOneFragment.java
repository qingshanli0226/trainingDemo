package com.example.player.a1610aplayerdemo.ui.main.choice.second;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.base.BaseAdapter;
import com.example.player.a1610aplayerdemo.base.BaseFragment;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.bean.CategoryOneBean;

import java.util.List;

public class CategoryOneFragment extends BaseFragment<List<CategoryOneBean>,CategroyOneView> {
    private CategroyOneAdapter adapter = new CategroyOneAdapter();
    @Override
    public RecyclerView.LayoutManager getRecyclerViewManager(Context context) {
        GridLayoutManager manager = new GridLayoutManager(context, 4);
        return manager;
    }

    @Override
    protected void setTitleBar(ImageView titlebar_left, ImageView titlebar_right, RelativeLayout titlebar_search, TextView titlebar_title) {
        titlebar_left.setVisibility(View.VISIBLE);
        titlebar_right.setVisibility(View.GONE);
        titlebar_search.setVisibility(View.GONE);
        titlebar_title.setVisibility(View.VISIBLE);
        titlebar_title.setText("音乐课堂");

        titlebar_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
    }


    @Override
    public BaseAdapter getBaseAdapter() {
        return adapter;
    }

    @Override
    public IBasePresenter getiBasePresenter() {
        return new CategoryOnePresenter();
    }
}
