package com.example.player.a1610aplayerdemo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.activity.LoginActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment04 extends Fragment {


    private ImageView i_img;
    private TextView loginTV;
    private LinearLayout exitLogin;

    public BlankFragment04() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragment04, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        i_img = (ImageView) view.findViewById(R.id.i_img);
        loginTV = (TextView) view.findViewById(R.id.loginTV);
        exitLogin = (LinearLayout) view.findViewById(R.id.exitLogin);

        loginTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
