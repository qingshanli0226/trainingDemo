package com.example.player.a1610aplayerdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.common.HomeBean;

import java.util.List;

public class Adapter_VIPRecyclerView extends RecyclerView.Adapter<Adapter_VIPRecyclerView.ViewHolder> {
    private Context mContext;
    private HomeBean mHomeBean;
    private List<HomeBean.DataBean.VipRecommendBean> vipRecommend;
    private OnClikcItem mClikcItem;

    public void setClikcItem(OnClikcItem clikcItem) {
        mClikcItem = clikcItem;
    }

    public Adapter_VIPRecyclerView(Context context, HomeBean homeBean) {
        mContext = context;
        mHomeBean = homeBean;
        vipRecommend = mHomeBean.getData().getVipRecommend();
        Log.i("TagVIP","==>"+vipRecommend.size());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.vip_layout_rv_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        HomeBean.DataBean.VipRecommendBean bean = vipRecommend.get(i);
        String image = bean.getImage();
        Log.i("TagVIP","==>"+image);
        Glide.with(mContext).load(image).into(viewHolder.mImageView);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClikcItem.OnClikc(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return vipRecommend.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.vipPageRV_Image);
        }
    }
    public interface OnClikcItem{
        void OnClikc(int i);
    }
}
