package com.example.player.a1610aplayerdemo.ui.main.choice.masterlives;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.MainBean;
import com.example.player.a1610aplayerdemo.utils.WidthAndHeight;

import java.util.List;

public class MasterLivesView extends LinearLayout {
    private RecyclerView recyclerView;
    private LinearLayout linearLayout;
    public MasterLivesView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_item_master, this);
        recyclerView = inflate.findViewById(R.id.master_recycler);
        linearLayout = inflate.findViewById(R.id.master_linear);

        Display display = WidthAndHeight.getHeight().getDisplay();
        int width = display.getWidth();

        ViewGroup.LayoutParams params = linearLayout.getLayoutParams();
        params.width = width;
        linearLayout.setLayoutParams(params);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    public MasterLivesView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    public MasterLivesView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }

    public void setMasterView(List<MainBean.MasterLivesBean> masterLivesBeans){
        MasterLivesItemAdapter adapter = new MasterLivesItemAdapter();
        recyclerView.setAdapter(adapter);
        adapter.updataData(masterLivesBeans);
    }
}
