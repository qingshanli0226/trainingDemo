package com.example.player.a1610aplayerdemo.discover.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.discover.bean.DiscoverBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder>{
    private List<DiscoverBean.MasterLivesBean> list=new ArrayList<>();
    private Context context;
    private onItemCourseClickListener listener;

    public void setListener(onItemCourseClickListener listener) {
        this.listener = listener;
    }

    public void setList(List<DiscoverBean.MasterLivesBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_course,viewGroup,false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder optionViewHolder, final int i) {
        Picasso.get().load(list.get(i).getImageUrl()).into(optionViewHolder.imageView);
        optionViewHolder.textView.setText(list.get(i).getAppTitle());
        optionViewHolder.textView2.setText(list.get(i).getTeacherName());
        optionViewHolder.textView3.setText(list.get(i).getTeacherTitle());
        optionViewHolder.textView4.setText(list.get(i).getPrice()+"");
        optionViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemCourse(list.get(i),i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CourseViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.course_iv1);
            textView=itemView.findViewById(R.id.course_tv1);
            textView2=itemView.findViewById(R.id.course_tv2);
            textView3=itemView.findViewById(R.id.course_tv3);
            textView4=itemView.findViewById(R.id.course_tv4);
        }
    }
    public interface onItemCourseClickListener{
        void onItemCourse(DiscoverBean.MasterLivesBean bean,int index);
    }
}
