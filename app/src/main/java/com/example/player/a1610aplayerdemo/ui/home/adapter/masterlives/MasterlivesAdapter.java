package com.example.player.a1610aplayerdemo.ui.home.adapter.masterlives;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.ui.home.bean.HomeBean;
import com.squareup.picasso.Picasso;

public class MasterlivesAdapter extends BaseRecyclerViewAdapter<HomeBean.DataBean.MasterLivesBean, View> {
    @Override
    protected View getItemView(Context context, int viewtype) {
        return LayoutInflater.from(context).inflate(R.layout.item_masterlives_adapter,null);
    }

    @Override
    protected void refreshItemUi(View itemView, HomeBean.DataBean.MasterLivesBean masterLivesBean, int i) {
        ImageView imageView = itemView.findViewById(R.id.masterlives_image);
        Picasso.get().load(masterLivesBean.getImageUrl()).into(imageView);
        ((TextView)itemView.findViewById(R.id.masterlives_tv1)).setText(masterLivesBean.getAppTitle());
        ((TextView)itemView.findViewById(R.id.masterlives_tv2)).setText(masterLivesBean.getTeacherName());
        ((TextView)itemView.findViewById(R.id.masterlives_tv3)).setText(masterLivesBean.getTeacherTitle());
        ((TextView)itemView.findViewById(R.id.masterlives_tv4)).setText(masterLivesBean.getPrice() + "元");
    }
}