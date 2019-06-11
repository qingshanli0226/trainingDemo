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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;

import java.util.List;

/**
 * 这是一个基类，继承自Fragment可以用于所有的子类Fragment 实现自IBaseView  使用的是MVP模式
 * 首先呢在onCreateView方法里面生成布局  因为我们这个基类主要是用于RecyclerView 每一个继承自本类的类，就会有RecyclerView
 * 所以呢 我们就可以对这个RecyclerView进行初始化
 * RecyclerView 设置Adapter 为BaseAdapter  这个类呢  也是一个基类
 * 我们不能对于adapter进行初始化，所以说需要让子类进行初始化
 *我们可以在onActivityCreated方法中进行对于数据的初始化
 * 我们使用的是MVP模式，所以说我们可以在presenter中进行对数据的初始化（也要对view进行绑定）
 * 如果数据请求成功   presenter就会调用View的onLoadData方法
 * 我们可以在这个方法中对于适配器的数据进行刷新
 *别忘记在Destroy中对View进行解绑
 * @param <T>
 * @param <V>
 */
public abstract class BaseFragment<T,V extends View> extends Fragment implements IBaseView<T>  {
    private BaseAdapter baseAdapter;
    private IBasePresenter iBasePresenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View inflate = inflater.inflate(R.layout.fragment_base, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        //初始化recyclerview
        RecyclerView recyclerView = inflate.findViewById(R.id.base_fragment_recy);
        recyclerView.setLayoutManager(new LinearLayoutManager(inflate.getContext()));
        baseAdapter = getBaseAdapter();
        recyclerView.setAdapter(baseAdapter);
        RelativeLayout titlebar_search = inflate.findViewById(R.id.titlebar_search);
        TextView titlebar_title = inflate.findViewById(R.id.titlebar_title);
        ImageView titlebar_right = inflate.findViewById(R.id.titlebar_right);
        ImageView titlebar_left = inflate.findViewById(R.id.titlebar_left);
        setTitleBar(titlebar_left,titlebar_right,titlebar_search,titlebar_title);
    }

    protected abstract void setTitleBar(ImageView titlebar_left, ImageView titlebar_right, RelativeLayout titlebar_search, TextView titlebar_title);

    //让子类对adapter进行初始化
    public abstract  BaseAdapter getBaseAdapter();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        iBasePresenter = getiBasePresenter();
        iBasePresenter.attachView(this);
        initData();
    }

    private void initData(){
        //获取数据
        iBasePresenter.getData();
    }

    public abstract IBasePresenter getiBasePresenter();



    @Override
    public void onDestroy() {
        super.onDestroy();
        iBasePresenter.detachView();
    }

    @Override
    public void onLoadData(List<T> data) {
        //请求到数据之后就会执行做个方法
        //刷新数据即可
        baseAdapter.updataData(data);
    }

    @Override
    public void onLoadError(int code, String msg) {

    }
}
