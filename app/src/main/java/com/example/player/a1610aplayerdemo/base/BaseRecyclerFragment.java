package com.example.player.a1610aplayerdemo.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.player.a1610aplayerdemo.R;

import java.util.List;

public abstract class BaseRecyclerFragment<T,V extends View> extends Fragment implements IBaseView<T> {
 private IBasePresenter iBasePresenter;
 private BaseRecyclerViewAdapter baseRecyclerViewAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.base_recyclerview_fragment,container,false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView){
        RecyclerView recyclerView = rootView.findViewById(R.id.base_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        baseRecyclerViewAdapter = getAdapter();
        recyclerView.setAdapter(baseRecyclerViewAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        iBasePresenter = getPresenter();
        iBasePresenter.attachView(this);
        initData();
    }

   private void initData(){
        iBasePresenter.getData(); // 通过presenter 去获取数据
   }

    // 需要子类来提供适配器
    public abstract BaseRecyclerViewAdapter<T,V> getAdapter();

    public abstract IBasePresenter getPresenter();


    /**
     * 当presenter获得数据后，会回调该方法，将数据返回。
     * @param data
     */
    @Override
    public void onloadData(List<T> data) {
         baseRecyclerViewAdapter.upData(data);
    }
    /**
     * 当presenter获取失败时调用该方法。
     * @param code
     * @param message
     */
    @Override
    public void onLoadError(int code, String message) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        iBasePresenter.detachView();
    }
}
