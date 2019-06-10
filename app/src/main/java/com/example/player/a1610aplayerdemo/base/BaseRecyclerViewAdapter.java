package com.example.player.a1610aplayerdemo.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用adapter基类，提取共性的内容。
 * 两个变化，一个是管理的数据类型，另一是布局转换的itemView
 * 将这两个变化使用泛型来兼容不同的数据类型和itemview
 * @param <T>
 * @param <V>
 */
public abstract class BaseRecyclerViewAdapter<T, V extends View>  extends RecyclerView.Adapter<BaseRecyclerViewAdapter.BaseViewHolder> {

    private List<T> data = new ArrayList<>();//定义一个数据列表.
    private OnItemClickListener onItemClickListener;//维护一个点击回调接口

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new BaseViewHolder(getItemView(viewGroup.getContext()));
    }


    //因为生成itemView需要上下文，所以添加一个参数，就是上下文参数, 并且返回值只要是集成View即可,不需要指定返回的具体类型.
    public abstract V getItemView(Context context);

    /**
     * 在UI上渲染数据
     * @param baseViewHolder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull final BaseViewHolder baseViewHolder, final int position) {
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

    class BaseViewHolder extends RecyclerView.ViewHolder {
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
