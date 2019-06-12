package com.example.player.a1610aplayerdemo.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import io.reactivex.annotations.NonNull;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseViewAdapter <T, V extends View>  extends RecyclerView.Adapter<BaseViewAdapter.BaseViewHolder> {
    private List<T> data = new ArrayList<>();//定义一个数据列表.
    private OnItemClickListener onItemClickListener;//维护一个点击回调接口

    //更新数据
    public void updateData(List<T> dataList) {
        this.data.clear();
        this.data.addAll(dataList);
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        V view = getItemView(viewGroup.getContext());
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BaseViewAdapter.BaseViewHolder baseViewHolder, final int position) {
        refreshItemUi((V)baseViewHolder.itemView, data.get(position));

        //回调点击事件
        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(baseViewHolder.itemView, position);
                }
            }
        });
    }
    public abstract V getItemView(Context context);
    /**
     * 在子类中去刷新UI
     * @param itemView
     * @param t
     */
    protected abstract void refreshItemUi(V itemView, T t);

    @Override
    public int getItemCount() {
        return data.size();
    }

    protected class BaseViewHolder extends RecyclerView.ViewHolder {
        public BaseViewHolder(View itemView) {
            super(itemView);
        }
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

}
