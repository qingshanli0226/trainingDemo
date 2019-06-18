package com.example.player.a1610aplayerdemo.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.DetailBean2;

import java.util.ArrayList;
import java.util.List;

public class ItemClickListAdapter extends BaseRecyclerAdapter<DetailBean2.DataBean.ChaptersBean>{

    private TextView zj;
    private TextView bt;
    private TextView jj;
    private ImageView imageView;
    private List<Boolean> ischecklist;
    private int position;


    public ItemClickListAdapter(List<DetailBean2.DataBean.ChaptersBean> list, Context context, int layId) {
        super(list, context, layId);
        ischecklist = new ArrayList<>();
        for (int i = 0;i<list.size();i++){
            if (i==0){
                ischecklist.add(true);
            }
            ischecklist.add(false);
        }
    }

    @Override
    public void refreshItemUi(final BaseViewHolder holder, final DetailBean2.DataBean.ChaptersBean itemData) {
        int adapterPosition = holder.getAdapterPosition();
        zj = holder.itemView.findViewById(R.id.list_zj);
        bt = holder.itemView.findViewById(R.id.list_title);
        jj = holder.itemView.findViewById(R.id.jianjie);
        imageView = holder.itemView.findViewById(R.id.list_bo);
        zj.setText(itemData.getShowIndexText());
        bt.setText(itemData.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
//                showColor();
                position = holder.getLayoutPosition(); // 1
                Toast.makeText(holder.itemView.getContext(), "我"+position, Toast.LENGTH_SHORT).show();
                for(int j = 0; j <ischecklist.size();j++){
                    ischecklist.set(j,false);
                }
                ischecklist.set(position,true);
                notifyDataSetChanged();
                }
        });

        if (ischecklist.get(adapterPosition)){
           showColor();
        }else {
           hideColor();
        }

    }

    @SuppressLint("ResourceAsColor")
    private void hideColor(){
        zj.setTextColor(R.color.item_list_zj_noselect);
        bt.setTextColor(R.color.item_list_zj_noselect);
        jj.setTextColor(R.color.item_list_zj_noselect);
        imageView.setBackgroundResource(R.drawable.bof1);
    }

    @SuppressLint("ResourceAsColor")
    private void showColor(){
        zj.setTextColor(0xff8b0000);
        bt.setTextColor(0xff8b0000);
        jj.setTextColor(0xff8b0000);
        imageView.setBackgroundResource(R.drawable.bof2);
    }
}
