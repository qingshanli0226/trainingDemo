package com.example.player.a1610aplayerdemo.ui.fragment.ItemClickFragment;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseFragment;
import com.example.player.a1610aplayerdemo.bean.DetailBean2;


public class KnowledgeFragment extends BaseFragment{
    TextView mz;
    TextView js;
    private DetailBean2.DataBean dataBean;

    public void setDataBean(DetailBean2.DataBean dataBean) {
        this.dataBean = dataBean;
    }

    @Override
    protected View getContentView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.itemclick_knowledge_fragment, container, false);
        mz = view.findViewById(R.id.mz);
        js = view.findViewById(R.id.js);
        mz.setText(dataBean.getCourseName());
        js.setText(dataBean.getCourseIntroduce());
        return view;
    }
}
