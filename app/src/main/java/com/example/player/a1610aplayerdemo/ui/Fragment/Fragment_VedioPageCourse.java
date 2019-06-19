package com.example.player.a1610aplayerdemo.ui.Fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.common.VedioBean;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class Fragment_VedioPageCourse extends Fragment {
    private Context mContext;
    private VedioBean.DataBean data;
    public Fragment_VedioPageCourse(Context context, VedioBean.DataBean data) {
        mContext = context;
        this.data = data;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment__vedio_page_course, container, false);
    }

}
