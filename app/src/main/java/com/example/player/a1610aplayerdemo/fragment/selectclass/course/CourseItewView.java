package com.example.player.a1610aplayerdemo.fragment.selectclass.course;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.fragment.selectclass.bean.GetHomeBean;

import java.util.List;

public class CourseItewView extends LinearLayout {

    Context m_context;
    RecyclerView m_rv;

    public CourseItewView(Context context) {
        super(context);
        m_context = context;
        initView(context);
    }


    public CourseItewView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        m_context = context;
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_course,this);
        m_rv = view.findViewById(R.id.course_rv);
    }

    public void setRvData(List<GetHomeBean.DataBean.CourseRecommendsBean> list){
        LinearLayoutManager manager = new LinearLayoutManager(m_context);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        m_rv.setLayoutManager(manager);
        CourseRvAdapter courseRvAdapter = new CourseRvAdapter();
        courseRvAdapter.setList(list);
        m_rv.setAdapter(courseRvAdapter);
    }

}
