package com.example.player.a1610aplayerdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.example.player.a1610aplayerdemo.R;

import java.util.ArrayList;

public class Welcome_Activity extends AppCompatActivity {
    private ViewPager vp;
    private int[] mImageIds = new int[]{R.mipmap.jiangyinglianordiqier1,R.mipmap.jiangyinglianordiqier2,R.mipmap.jiangyinglianordiqier3,R.mipmap.jiangyinglianordiqier4};
    private ArrayList<ImageView> mImageViewList;
    private LinearLayout llContainer;
    private ImageView ivRedPoint;
    private int mPaintDis;
    private Button start_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome_ll);
        initView();
    }

    private void initView(){
        vp = findViewById(R.id.vp_guide);
        llContainer = findViewById(R.id.ll_container);
        ivRedPoint = findViewById(R.id.iv_red);
        start_btn = findViewById(R.id.start_btn);

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Welcome_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        initData();
        GuideAdapter adapter = new GuideAdapter();
//        vp.setPageTransformer(true);
        vp.setAdapter(adapter);

        ivRedPoint.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void onGlobalLayout() {

                ivRedPoint.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                mPaintDis = llContainer.getChildAt(1).getLeft() - llContainer.getChildAt(0).getLeft();
//                System.out.println("距离：" + mPaintDis);
            }
        });

        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                int leftMargin = (int) (mPaintDis * v) + i *mPaintDis;
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) ivRedPoint.getLayoutParams();
                params.leftMargin = leftMargin;
                ivRedPoint.setLayoutParams(params);

            }

            @Override
            public void onPageSelected(int i) {
//                System.out.println("position:" + i);
                if (i == mImageViewList.size() - 1){
                    start_btn.setVisibility(View.VISIBLE);
                }else {
                    start_btn.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                System.out.println("state:" + i);
            }
        });

    }

    class GuideAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mImageViewList.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageView view = mImageViewList.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }

    private void initData(){
        mImageViewList = new ArrayList<>();
        for (int i = 0; i < mImageIds.length;i++){
            ImageView view = new ImageView(this);
            view.setBackgroundResource(mImageIds[i]);
            mImageViewList.add(view);
            ImageView pointView = new ImageView(this);
            pointView.setImageResource(R.drawable.shape_point1);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            if (i > 0){
                params.leftMargin = 20;
            }

            pointView.setLayoutParams(params);

            llContainer.addView(pointView);
        }
    }

}