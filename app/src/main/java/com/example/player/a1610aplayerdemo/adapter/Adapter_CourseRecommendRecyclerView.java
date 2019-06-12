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

public class Adapter_CourseRecommendRecyclerView extends RecyclerView.Adapter<Adapter_CourseRecommendRecyclerView.ViewHolder>{
    private HomeBean mHomeBean;
    private Context mContext;
    private List<HomeBean.DataBean.CourseRecommendsBean> recommends;
    private onClickItem mClickItem;

    public void setClickItem(onClickItem clickItem) {
        mClickItem = clickItem;
    }

    public Adapter_CourseRecommendRecyclerView(HomeBean homeBean, Context context) {
        mHomeBean = homeBean;
        mContext = context;
        recommends = mHomeBean.getData().getCourseRecommends();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.course_layout_recommend_rv_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.mTextView.setText(recommends.get(i).getAppTitle());
        Glide.with(mContext).load(recommends.get(i).getImageUrl()).into(viewHolder.mImageView);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickItem.onClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recommends.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImageView;
        private TextView mTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = (ImageView)itemView.findViewById(R.id.recommendRecyclerViewItem_Image);
            mTextView = (TextView)itemView.findViewById(R.id.recommendRecyclerViewItem_Text);
        }
    }
    interface onClickItem{
        void onClick(int i);
    }
}
