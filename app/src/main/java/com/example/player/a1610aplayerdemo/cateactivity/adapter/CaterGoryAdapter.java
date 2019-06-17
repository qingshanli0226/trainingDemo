package com.example.player.a1610aplayerdemo.cateactivity.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.Content;
import com.example.player.a1610aplayerdemo.MyApp;
import com.example.player.a1610aplayerdemo.details.ui.DetailsActivity;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.cateactivity.Bean.CateGoryBean;

public class CaterGoryAdapter extends BaseRecyclerViewAdapter<CateGoryBean.DataBean, View> implements BaseRecyclerViewAdapter.IItemViewClick<CateGoryBean.DataBean> {
    @Override
    protected View getItemViewHodler(ViewGroup viewGroup, Context context, int viewType) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cate_gory_item,viewGroup,false);
    }

    @Override
    protected void setItemViewHolder(View view, CateGoryBean.DataBean data, int positon) {
        Glide.with(view.getContext())
                .load(data.getImage())
                .into((ImageView) view.findViewById(R.id.iv_category));
        ((TextView) view.findViewById(R.id.tv_cate_title)).setText(data.getAppName());
        ((TextView) view.findViewById(R.id.tv_cate_teacherTitle)).setText(data.getTeacherTitle());

        setiItemViewClick(this);
    }

    @Override
    public void onItemClik(View itme, CateGoryBean.DataBean data, int position) {
        Intent intent = new Intent(itme.getContext(), DetailsActivity.class);
        intent.putExtra(Content.DETAILS_FLAG,data.getId());
        intent.putExtra(Content.TOOL_VAULE,data.getAppName());
        Log.d("MH",data.getId()+"DETAILS_FLAG");
        Log.d("MH",data.getAppName()+"TOOL_VAULE");
        itme.getContext().startActivity(intent);
    }
}
