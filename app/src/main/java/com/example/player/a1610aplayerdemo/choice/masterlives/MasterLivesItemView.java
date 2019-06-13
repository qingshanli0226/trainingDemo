package com.example.player.a1610aplayerdemo.choice.masterlives;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.MainBean;
import com.squareup.picasso.Picasso;

class MasterLivesItemView extends LinearLayout {

    private ImageView iv;
    private TextView title;
    private TextView teacherTitle;
    private TextView teacher;
    private TextView money;

    private Context context;

    public MasterLivesItemView(Context context) {
        super(context);
        init(context);
        this.context = context;
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_item_master_item, this);
        iv = inflate.findViewById(R.id.master_iv);
        title = inflate.findViewById(R.id.master_title);
        teacherTitle = inflate.findViewById(R.id.master_teacherTitle);
        teacher = inflate.findViewById(R.id.master_teacher);
        money = inflate.findViewById(R.id.master_money);

    }

    public MasterLivesItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        this.context = context;

    }

    public MasterLivesItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        this.context = context;

    }

    public void setMasterItem(MainBean.MasterLivesBean masterLivesBean,int i){
        String title = masterLivesBean.getAppTitle();
        String image = masterLivesBean.getImageUrl();
        Picasso.with(context).load(image).into(iv);
        this.title.setText(title);
        String teacherName = masterLivesBean.getTeacherName();
        teacher.setText(teacherName);
        String teacherTitle = masterLivesBean.getTeacherTitle();
        this.teacherTitle.setText(teacherTitle);
        int price = masterLivesBean.getPrice();
        money.setText(price+"元");
        final int a = i;
        iv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("click", "onClick: 大师课"+a);
            }
        });
    }
}
