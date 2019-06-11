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

public class OptionAdapter extends RecyclerView.Adapter<OptionAdapter.OptionViewHolder>{
    private List<DiscoverBean.HomeCategoryBean> list=new ArrayList<>();
    private Context context;
    public void setList(List<DiscoverBean.HomeCategoryBean> list) {
        this.list = list;
    }

    public OptionAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public OptionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_option,viewGroup,false);
        return new OptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OptionViewHolder optionViewHolder, int i) {
        Picasso.get().load(list.get(i).getBannerUrl()).into(optionViewHolder.imageView);
        optionViewHolder.textView.setText(list.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class OptionViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public OptionViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.option_iv1);
            textView=itemView.findViewById(R.id.option_tv1);
        }
    }
}
