package com.example.player.a1610aplayerdemo.ui.main.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.player.a1610aplayerdemo.Constant;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.bean.DetailBean;
import com.example.player.a1610aplayerdemo.ui.main.detail.list.ListFragment;
import com.example.player.a1610aplayerdemo.ui.main.detail.web.WebViewFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener, IBaseView<DetailBean> {
    private ImageView titlebar_left;
    private TextView text;
    private RelativeLayout titlebar_search;
    private TextView titlebar_title;
    private ImageView titlebar_right;
    private ImageView details_iv;
    private Button details_shikan;
    private TextView details_shoucang;
    private TextView details_share;
    private RelativeLayout detail_relative;
    private ImageView details_avatar;
    private TextView details_nameAndfrom;
    private TextView details_courseName;
    private LinearLayout details_linear;
    private TabLayout details_tab;
    private View details_view;
    private ViewPager details_vp;
    private TextView details_join;
    private TextView details_goumai;
    private LinearLayout details_vip;
    private DetailsPresent detailsPresent;
    private WebViewFragment webViewFragment;
    private ListFragment listFragment;
    private String url;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initView();
        getIntentFun();
    }

    private void getIntentFun() {
        Intent intent = getIntent();
        url = intent.getStringExtra(Constant.URL);
        Log.e("yn", "getIntentActivity: "+url);
        detailsPresent = new DetailsPresent(url);
        detailsPresent.attachView(this);
        detailsPresent.getData();
    }

    private void initView() {
        titlebar_left = (ImageView) findViewById(R.id.titlebar_left);
        text = (TextView) findViewById(R.id.text);
        titlebar_search = (RelativeLayout) findViewById(R.id.titlebar_search);
        titlebar_title = (TextView) findViewById(R.id.titlebar_title);
        titlebar_right = (ImageView) findViewById(R.id.titlebar_right);
        details_iv = (ImageView) findViewById(R.id.details_iv);
        details_shikan = (Button) findViewById(R.id.details_shikan);
        details_shoucang = (TextView) findViewById(R.id.details_shoucang);
        details_share = (TextView) findViewById(R.id.details_share);
        detail_relative = (RelativeLayout) findViewById(R.id.detail_relative);
        details_avatar = (ImageView) findViewById(R.id.details_avatar);
        details_nameAndfrom = (TextView) findViewById(R.id.details_nameAndfrom);
        details_courseName = (TextView) findViewById(R.id.details_courseName);
        details_linear = (LinearLayout) findViewById(R.id.details_linear);
        details_tab = (TabLayout) findViewById(R.id.details_tab);
        details_view = (View) findViewById(R.id.details_view);
        details_vp = (ViewPager) findViewById(R.id.details_vp);
        details_join = (TextView) findViewById(R.id.details_join);
        details_goumai = (TextView) findViewById(R.id.details_goumai);
        details_vip = (LinearLayout) findViewById(R.id.details_vip);


        titlebar_left.setVisibility(View.VISIBLE);
        titlebar_search.setVisibility(View.GONE);
        titlebar_right.setVisibility(View.GONE);
        titlebar_title.setVisibility(View.VISIBLE);

        details_shikan.setOnClickListener(this);
        titlebar_left.setOnClickListener(this);
        details_shoucang.setOnClickListener(this);
        details_share.setOnClickListener(this);

        details_tab.setupWithViewPager(details_vp);
        webViewFragment = new WebViewFragment();
        listFragment = new ListFragment();
        Fragment[] fragments = new Fragment[]{
                webViewFragment,
                listFragment
        };
        DetailsVpAdapter adapter = new DetailsVpAdapter(getSupportFragmentManager(),fragments);
        details_vp.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.details_shikan:

                break;
            case R.id.titlebar_left:
                finish();
                break;
            case R.id.details_shoucang:
                break;
            case R.id.details_share:
                break;
        }
    }

    @Override
    public void onLoadDataObject(DetailBean o) {
        String name = o.getName();
        titlebar_title.setText(name);
        String teacherName = o.getTeacherName();
        String teacherTitle = o.getTeacherTitle();
        details_nameAndfrom.setText(teacherName + "     " +teacherTitle);
        String teacherAvatar = o.getTeacherAvatar();
        Picasso.with(this).load(teacherAvatar).into(details_avatar);
        String image = o.getImage();
        Picasso.with(this).load(image).into(details_iv);
        String courseName = o.getCourseName();
        details_courseName.setText(courseName);

        webViewFragment.setData(o.getSummany().equals("")?o.getCourseIntroduce():o.getSummany());
        listFragment.setData(o,url);
    }

    @Override
    public void onLoadData(List<DetailBean> data) {

    }

    @Override
    public void onLoadError(int code, String msg) {

    }
}
