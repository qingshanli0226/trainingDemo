package com.example.player.a1610aplayerdemo.ui.user.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.ui.login.activity.LogIn_Activity;

public class User_Fragment extends Fragment {

    private TextView logInUser;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.user_fragment, container, false);
        initView(view);
        logInUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), LogIn_Activity.class);
                getActivity().startActivity(intent);
            }
        });
        return view;
    }

    private void initView(View viee) {
        logInUser = (TextView) viee.findViewById(R.id.log_in_user);
    }
}