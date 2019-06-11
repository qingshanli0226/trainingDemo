package com.example.player.a1610aplayerdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.common.HomeBean;

import java.util.List;

public class Adapter_CourseMasterRecylerView extends RecyclerView.Adapter<Adapter_CourseMasterRecylerView.ViewHolder>{
    private Context mContext;
    private HomeBean mHomeBean;
    private List<HomeBean.DataBean.MasterLivesBean> masterLives;
    private OnClikItem mClikItem;

    public void setClikItem(OnClikItem clikItem) {
        mClikItem = clikItem;
    }

    public Adapter_CourseMasterRecylerView(Context context, HomeBean homeBean) {
        mContext = context;
        mHomeBean = homeBean;
        masterLives = mHomeBean.getData().getMasterLives();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.course_layout_master_rv_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        HomeBean.DataBean.MasterLivesBean bean = masterLives.get(i);
        viewHolder.title.setText(bean.getAppTitle());
        viewHolder.adress.setText(bean.getTeacherTitle());
        viewHolder.price.setText(String.valueOf(bean.getPrice())+"元");
        viewHolder.teacher.setText(bean.getTeacherName());
        Glide.with(mContext).load(bean.getImageUrl()).into(viewHolder.mImageView);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClikItem.OnClick(i);
            }
        });
        int liveStatus = bean.getLiveStatus();
        if(liveStatus != 2){
            viewHolder.liveStatus.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return masterLives.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImageView;
        private TextView title;
        private TextView adress;
        private TextView price;
        private TextView teacher;
        private TextView liveStatus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.masterRecyclerView_Image);
            title = (TextView) itemView.findViewById(R.id.masterRV_CourseName);
            adress = (TextView) itemView.findViewById(R.id.masterRV_Adress);
            price = (TextView) itemView.findViewById(R.id.masterRV_Price);
            teacher = (TextView) itemView.findViewById(R.id.masterRV_Teacher);
            liveStatus = (TextView) itemView.findViewById(R.id.masterRV_LiveStatus);
        }
    }
    interface OnClikItem{
        void OnClick(int i);
    }
}
