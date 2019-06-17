package com.example.player.a1610aplayerdemo.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.activity.OpinionActivity;

public class MyFragment extends Fragment implements View.OnClickListener {
    private LinearLayout my_ll1;
    private LinearLayout my_ll2;
    private LinearLayout my_ll3;
    private LinearLayout my_ll4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        my_ll1 = (LinearLayout) view.findViewById(R.id.my_ll1);
        my_ll2 = (LinearLayout) view.findViewById(R.id.my_ll2);
        my_ll3 = (LinearLayout) view.findViewById(R.id.my_ll3);
        my_ll4 = (LinearLayout) view.findViewById(R.id.my_ll4);

        my_ll1.setOnClickListener(this);
        my_ll2.setOnClickListener(this);
        my_ll3.setOnClickListener(this);
        my_ll4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.my_ll1:
                break;
            case R.id.my_ll2:
                break;
            case R.id.my_ll3:
                break;
            case R.id.my_ll4:
                Intent intent=new Intent(getActivity(), OpinionActivity.class);
                startActivity(intent);
                break;
        }
    }
}
