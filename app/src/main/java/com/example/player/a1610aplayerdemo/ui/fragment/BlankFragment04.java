package com.example.player.a1610aplayerdemo.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.ui.login.LoginActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment04 extends Fragment {


    private ImageView i_img;
    private TextView loginTV;
    private LinearLayout exitLogin;
    private TextView shareText;

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
        shareText = (TextView) view.findViewById(R.id.shareText);
        shareText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShare();
            }
        });
    }
    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // title标题，微信、QQ和QQ空间等平台使用
        oks.setTitle("来自央音的分享");
        // titleUrl QQ和QQ空间跳转链接
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url在微信、微博，Facebook等平台中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网使用
        oks.setComment("我是测试评论文本");
        // 启动分享GUI
        oks.show(getContext());
    }
}

