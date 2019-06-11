package com.example.player.a1610aplayerdemo.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用adapter基类，提取共性的内容
 * 两个变化，一个是管理的数据类型， 另一个是布局装换的itemview
 * 将这两个变化使用泛型来兼容不同的数据类型和 itemview
 *
 */

public abstract class BaseRecyclerViewAdapter<T,V extends View> extends RecyclerView.Adapter<BaseViewHolder>{

    private List<T> data = new ArrayList<>();// 定义一个数据列表
    private OnItemClickListener onItemClickListener;

// 更新数据
    public void upData(List<T> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        V view = getItemView(viewGroup.getContext(),viewType);
        return new BaseViewHolder(view);
    }


    /* *
 * 在UI上渲染数据
 * @param baseViewHolder
 * @param position
 */
    @Override
    public void onBindViewHolder(@NonNull final BaseViewHolder baseViewHolder, final int position) {
            refreshItemUi((V)baseViewHolder.itemView,data.get(position),position);
            // 回调点击事件
        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null){
                    onItemClickListener.onItemClick(baseViewHolder.itemView,position);
                }
            }
        });
    }
    //因为生成itemView需要上下文，所以添加一个参数，就是上下文参数, 并且返回值只要是集成View即可,不需要指定返回的具体类型.
   public abstract V getItemView(Context context,int viewType);

    @Override
    public int getItemViewType(int position) {
        return getViewType(position);
    }
// 根据position 传递不同viewType
    protected abstract int getViewType(int position);

    public abstract void refreshItemUi(V itemView, T t,int position);

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }
}
