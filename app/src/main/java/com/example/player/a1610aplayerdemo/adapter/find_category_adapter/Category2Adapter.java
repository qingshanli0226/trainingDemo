package com.example.player.a1610aplayerdemo.adapter.find_category_adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerAdapter;
import com.example.player.a1610aplayerdemo.bean.LiveBean;
import com.example.player.a1610aplayerdemo.bean.MusicClassBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class Category2Adapter extends BaseRecyclerAdapter<LiveBean.DataBean>{
    Context context;

    public Category2Adapter(List<LiveBean.DataBean> list, Context context, int layId) {
        super(list, context, layId);
        this.context = context;
    }

    @Override
    public void refreshItemUi(BaseViewHolder holder, LiveBean.DataBean itemData) {
        ImageView simpleDraweeView = holder.itemView.findViewById(R.id.simpleImg);
        TextView textView = holder.itemView.findViewById(R.id.simpleTitle);
        TextView textwriter = holder.itemView.findViewById(R.id.simplewriter);
        TextView textwritermessage = holder.itemView.findViewById(R.id.simplewritermessage);
        TextView textprice = holder.itemView.findViewById(R.id.simpleprice);
        Glide.with(context).load(itemData.getImageUrl()).into(simpleDraweeView);
        textView.setText(itemData.getRoomTitle());
        textprice.setText(itemData.getPrice()+"元");
        textwriter.setText("讲师 :"+itemData.getTeacherName());
        textwritermessage.setText(itemData.getTeacherTitle());
    }
}
