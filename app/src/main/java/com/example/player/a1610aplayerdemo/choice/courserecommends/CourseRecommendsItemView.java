package com.example.player.a1610aplayerdemo.choice.courserecommends;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.MainBean;
import com.squareup.picasso.Picasso;

public class CourseRecommendsItemView extends LinearLayout {
    private ImageView iv;
    private TextView tv;
    private Context context;

    public CourseRecommendsItemView(Context context) {
        super(context);
        init(context);
        this.context = context;
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_item_course_item, this);
        iv = inflate.findViewById(R.id.course_iv);
        tv = inflate.findViewById(R.id.course_title);

    }

    public CourseRecommendsItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        this.context = context;

    }

    public CourseRecommendsItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        this.context = context;

    }

    public void setCourseItem(MainBean.CourseRecommendsBean courseItem){
        String title = courseItem.getAppTitle();
        String image = courseItem.getImageUrl();
        Picasso.with(context).load(image).into(iv);
        tv.setText(title);
    }
}
