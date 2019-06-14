package com.example.player.a1610aplayerdemo.fragment.selectclass.course;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.fragment.selectclass.bean.GetHomeBean;
import com.example.player.a1610aplayerdemo.fragment.selectclass.zl.zlvideoactivity.onclickinterface.OnclickListener;

import java.util.ArrayList;
import java.util.List;

public class CourseRvAdapter extends  RecyclerView.Adapter<CourseRvAdapter.MyCourseHolder>{

    private List<GetHomeBean.DataBean.CourseRecommendsBean> list = new ArrayList<>();
    private Context m_context;
    private OnclickListener onclickListener;


    public void setList(List<GetHomeBean.DataBean.CourseRecommendsBean> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyCourseHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        m_context = viewGroup.getContext();
        View view = LayoutInflater.from(m_context).inflate(R.layout.item_course_rv,viewGroup,false);
        return new MyCourseHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCourseHolder myCourseHolder, final int i) {
        Glide.with(m_context).load(list.get(i).getImageUrl()).into(myCourseHolder.course_img);
        myCourseHolder.course_title.setText(list.get(i).getAppTitle());

        myCourseHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onclickListener != null){
                    onclickListener.onClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyCourseHolder extends RecyclerView.ViewHolder {
        ImageView course_img;
        TextView course_title;
        public MyCourseHolder(@NonNull View itemView) {
            super(itemView);
            course_img = itemView.findViewById(R.id.item_course_img);
            course_title = itemView.findViewById(R.id.item_course_title);
        }
    }


    public void setOnclickListener(OnclickListener onclickListener) {
        this.onclickListener = onclickListener;
    }


}
