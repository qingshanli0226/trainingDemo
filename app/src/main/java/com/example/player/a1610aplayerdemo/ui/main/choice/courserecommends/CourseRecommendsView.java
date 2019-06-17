package com.example.player.a1610aplayerdemo.ui.main.choice.courserecommends;

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

public class CourseRecommendsView extends LinearLayout {
    private RecyclerView recyclerView;
    private CourseRecommendsItemAdapter adapter;
    private Context context;

    public CourseRecommendsView(Context context) {
        super(context);
        init(context);
        this.context = context;
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_item_course, this);
        recyclerView = inflate.findViewById(R.id.course_recycler);

        Display display = WidthAndHeight.getHeight().getDisplay();
        int width = display.getWidth();

        ViewGroup.LayoutParams params = recyclerView.getLayoutParams();
        params.width = width;
        recyclerView.setLayoutParams(params);
    }

    public CourseRecommendsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        this.context = context;

    }

    public CourseRecommendsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        this.context = context;
    }

    public void setCourseView(List<MainBean.CourseRecommendsBean> courseRecommendsBeans){
        adapter = new CourseRecommendsItemAdapter();
        recyclerView.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        adapter.updataData(courseRecommendsBeans);
    }

}
