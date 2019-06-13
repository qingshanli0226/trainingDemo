package com.example.player.a1610aplayerdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.player.a1610aplayerdemo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutMy_Fragment extends Fragment {

    private View view;
    private ImageView my_back_img;
    private ImageView my_avatar;
    private TextView my_login_or_register_tv;
    private ImageView my_message_img;
    private ImageView my_setting_img;
    private ScrollView my_scrollView;


    public AboutMy_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_about_my, container, false);

        initView(view);
        initAvatar();
        return view;
    }

    private void initAvatar() {

        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(getActivity()).load(R.drawable.ic_launcher_background)
                .apply(requestOptions).into(my_avatar);
    }

    private void initView(View view) {
        my_back_img = (ImageView) view.findViewById(R.id.my_back_img);
        my_avatar = (ImageView) view.findViewById(R.id.my_avatar);
        my_login_or_register_tv = (TextView) view.findViewById(R.id.my_login_or_register_tv);
        my_message_img = (ImageView) view.findViewById(R.id.my_message_img);
        my_setting_img = (ImageView) view.findViewById(R.id.my_setting_img);
        my_scrollView = (ScrollView) view.findViewById(R.id.my_scrollView);
    }
}

