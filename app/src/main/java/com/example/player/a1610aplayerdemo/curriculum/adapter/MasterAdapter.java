package com.example.player.a1610aplayerdemo.curriculum.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.curriculum.bean.Bean;
import com.othershe.library.NiceImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MasterAdapter extends RecyclerView.Adapter<MasterAdapter.MyViewHolder>{
    private List<Bean.MasterLivesBean> list = new ArrayList<>();
    private onClickItemListener listener;
    private Context context;

    public void setListener(onClickItemListener listener) {
        this.listener = listener;
    }

    public void refresh(List<Bean.MasterLivesBean> dataList) {
        this.list.clear();
        this.list.addAll(dataList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.master_item,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        Picasso.with(context).load(list.get(i).getImageUrl()).into(myViewHolder.imageView);
        myViewHolder.textTitle.setText(list.get(i).getAppTitle());
        myViewHolder.textTeacher.setText("讲师: "+list.get(i).getTeacherName());
        myViewHolder.textTT.setText(list.get(i).getTeacherTitle());
        myViewHolder.textPice.setText(list.get(i).getPrice()+"");
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickMaster(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private NiceImageView imageView;
        private TextView textTitle,textTeacher,textTT,textPice;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.master_niv);
            textTitle = itemView.findViewById(R.id.master_title_tv);
            textTeacher = itemView.findViewById(R.id.master_teacher_tv);
            textTT = itemView.findViewById(R.id.master_teacherTitl_tv);
            textPice = itemView.findViewById(R.id.master_price_tv);
        }
    }

    public interface onClickItemListener{
        void onClickMaster(int index);
    }
}
