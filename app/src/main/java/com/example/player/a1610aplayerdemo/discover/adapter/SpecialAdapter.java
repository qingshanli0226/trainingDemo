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

public class SpecialAdapter extends RecyclerView.Adapter<SpecialAdapter.SpecialViewHolder>{
    private List<DiscoverBean.ZlListBean> list=new ArrayList<>();
    private Context context;
    private onItemSpecialClickListener listener;

    public void setListener(onItemSpecialClickListener listener) {
        this.listener = listener;
    }

    public void setList(List<DiscoverBean.ZlListBean> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public SpecialViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_special,viewGroup,false);
        return new SpecialViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialViewHolder optionViewHolder, final int i) {
        Picasso.get().load(list.get(i).getImage()).into(optionViewHolder.imageView);
        optionViewHolder.textView.setText(list.get(i).getTitle());
        optionViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemSpecial(list.get(i),i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SpecialViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public SpecialViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.special_iv1);
            textView=itemView.findViewById(R.id.special_tv1);
        }
    }
    public interface onItemSpecialClickListener{
        void onItemSpecial(DiscoverBean.ZlListBean bean,int index);
    }
}
