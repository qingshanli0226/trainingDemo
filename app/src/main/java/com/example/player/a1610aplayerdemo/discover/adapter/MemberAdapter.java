package com.example.player.a1610aplayerdemo.discover.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.discover.bean.DiscoverBean;
import com.squareup.picasso.Picasso;
import io.reactivex.annotations.NonNull;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class MemberAdapter  extends RecyclerView.Adapter<MemberAdapter.MemberViewHolder>{
    private List<DiscoverBean.VipRecommendBean> list=new ArrayList<>();

    public void setList(List<DiscoverBean.VipRecommendBean> list) {
        this.list = list;
    }

    @android.support.annotation.NonNull
    @Override
    public MemberViewHolder onCreateViewHolder(@android.support.annotation.NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_member,viewGroup,false);
        return new MemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@android.support.annotation.NonNull MemberViewHolder memberViewHolder, int i) {
        Picasso.get().load(list.get(i).getImage()).into(memberViewHolder.imageView);
        memberViewHolder.textView.setText(list.get(i).getTitle());
        memberViewHolder.textView2.setText(list.get(i).getText1());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MemberViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView textView1;
        TextView textView2;
        public MemberViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.member_iv1);
            textView=itemView.findViewById(R.id.member_tv1);
            textView1=itemView.findViewById(R.id.member_tv2);
            textView2=itemView.findViewById(R.id.member_tv3);
        }
    }
}
