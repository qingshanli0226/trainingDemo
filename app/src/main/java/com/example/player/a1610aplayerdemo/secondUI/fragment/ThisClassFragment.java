package com.example.player.a1610aplayerdemo.secondUI.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseView;
import com.example.player.a1610aplayerdemo.secondUI.bean.BannerBean;
import com.example.player.a1610aplayerdemo.secondUI.persenter.VedioPersenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThisClassFragment extends Fragment implements BaseView<BannerBean> {


    private TextView courseName;
    private TextView courseIntroduce;

    public ThisClassFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_this_class, container, false);
        initView(view);

        return view;

    }

    private void initView(View view) {
        courseName = (TextView) view.findViewById(R.id.courseName);
        courseIntroduce = (TextView) view.findViewById(R.id.courseIntroduce);

        Intent intent = getActivity().getIntent();
        String relation = intent.getStringExtra("relation");
        new VedioPersenter(this).getVedioData(relation, "0");

    }

    @Override
    public void onLoadData(BannerBean datalist) {
        courseName.setText( datalist.getData().getCourseName()+"");
        courseIntroduce.setText(datalist.getData().getCourseIntroduce()+"");


    }

    @Override
    public void onLoadError(int code, String str) {

    }
}
