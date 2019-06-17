package com.example.player.a1610aplayerdemo.details.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.player.a1610aplayerdemo.Content;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.DivToolbar;
import com.example.player.a1610aplayerdemo.details.adapter.DFragmentAdapter;
import com.example.player.a1610aplayerdemo.details.bean.DetailsBean;
import com.example.player.a1610aplayerdemo.details.presenter.DetialsComple;
import com.example.player.a1610aplayerdemo.details.presenter.DetialsContract;

public class DetailsActivity extends AppCompatActivity implements DetialsContract.IDetialsStatus, View.OnClickListener {
    private DivToolbar toolbar;
    private String toolbarVaue;
    private DivToolbar toolBar;
    private ImageView rlDetails;
    private Button btnTrysee;
    private ImageView ivTeacherAvatar;
    private TextView tvTeacherName;
    private TextView tvTeacherDetails;
    private TextView tvClassNaem;
    private TabLayout detailsTab;
    private ViewPager detailsPage;


    private DFragmentAdapter viewPagerAdapter;
    private DetialsContract.IDetialsPresenter iDetialsPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        int detailsFlag = intent.getIntExtra(Content.DETAILS_FLAG, 0);
        toolbarVaue = intent.getStringExtra(Content.TOOL_VAULE);
        String url = "http://api.immedc.com/restapi/course/getVideo2?courseId=" + detailsFlag + "&packageId=0";
        Log.d("MH",url+"url");
        iDetialsPresenter = new DetialsComple(this);
        iDetialsPresenter.getDetialsBean(url);
        initView();

    }

    private void initView() {
        initbar();
        rlDetails = findViewById(R.id.rl_details);
        btnTrysee = findViewById(R.id.btn_trysee);
        ivTeacherAvatar = findViewById(R.id.iv_teacher_avatar);
        tvTeacherName = findViewById(R.id.tv_teacher_name);
        tvTeacherDetails = findViewById(R.id.tv_teacher_details);
        tvClassNaem = findViewById(R.id.tv_class_naem);
        detailsTab = findViewById(R.id.details_Tab);
        detailsPage = findViewById(R.id.details_page);

        viewPagerAdapter = new DFragmentAdapter(getSupportFragmentManager());
        detailsPage.setAdapter(viewPagerAdapter);
        detailsTab.setupWithViewPager(detailsPage);

        btnTrysee.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_trysee:
                Toast.makeText(this, "点击了试看", Toast.LENGTH_SHORT).show();
            break;
            default:break;
        }
    }


    private void initbar() {
        toolbar = findViewById(R.id.tool_bar);
        toolbar.setLeftImageResource(R.drawable.toolbar_back);
        toolbar.setRightLayoutVisibility(View.GONE);
        toolbar.setCenterLeftTextLayoutVisibility(View.GONE);
        toolbar.setCenterRightTextLayoutVisibility(View.VISIBLE);
        toolbar.setCenterRightText(toolbarVaue);
        toolbar.setLeftLayoutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void succssful(DetailsBean detailsBean) {
            Glide.with(this).load(detailsBean.getData().getImage()).into(rlDetails);
            Glide.with(this).load(detailsBean.getData().getTeacherAvatar())
                    .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                    .into(ivTeacherAvatar);

            tvTeacherName.setText(detailsBean.getData().getTeacherName());
            tvTeacherDetails.setText(detailsBean.getData().getTeacherTitle());
            tvTeacherDetails.setText(detailsBean.getData().getShareView().getShareTitle());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iDetialsPresenter.dettach();
    }
}
