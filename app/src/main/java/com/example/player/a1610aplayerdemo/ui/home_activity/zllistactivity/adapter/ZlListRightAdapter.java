package com.example.player.a1610aplayerdemo.ui.home_activity.zllistactivity.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.ui.home_activity.zllistactivity.bean.ZlListRightBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ZlListRightAdapter extends XRecyclerView.Adapter<ZlListRightAdapter.MyViewHolder> {
    private Context context;
    private List<ZlListRightBean.DataBean> list = new ArrayList<>();

    public void updata(Context context,List<ZlListRightBean.DataBean> list){
        this.context = context;
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.zllistright_item,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Picasso.get().load(list.get(i).getImage()).into(myViewHolder.zllistright_image);
        myViewHolder.zllistright_tv1.setText(list.get(i).getTitle());
        myViewHolder.zllistright_tv2.setText(list.get(i).getIntroduce());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView zllistright_image;
        private TextView zllistright_tv1,zllistright_tv2,zllistright_tv3;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            zllistright_image = itemView.findViewById(R.id.zllistright_image);
            zllistright_tv1 = itemView.findViewById(R.id.zllistright_tv1);
            zllistright_tv2 = itemView.findViewById(R.id.zllistright_tv2);
            zllistright_tv3 = itemView.findViewById(R.id.zllistright_tv3);
        }
    }
}