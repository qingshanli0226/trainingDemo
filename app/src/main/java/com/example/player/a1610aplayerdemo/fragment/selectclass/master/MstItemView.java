package com.example.player.a1610aplayerdemo.fragment.selectclass.master;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.fragment.selectclass.bean.GetHomeBean;

public class MstItemView extends LinearLayout {

    private ImageView master_img;
    private TextView master_title;
    private TextView master_teacher;
    private TextView master_colloeg;
    private TextView master_price;
    private Context m_context;

    public MstItemView(Context context) {
        super(context);
        m_context = context;
        initView(context);
    }

    private void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_master_rv, this);
        master_img = inflate.findViewById(R.id.master_img);
        master_title = inflate.findViewById(R.id.master_title);
        master_colloeg = inflate.findViewById(R.id.master_colloge);
        master_price = inflate.findViewById(R.id.master_price);
        master_teacher = inflate.findViewById(R.id.master_teacher);

    }

    public MstItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setData(GetHomeBean.DataBean.MasterLivesBean bean){
        Glide.with(m_context).load(bean.getImageUrl()).into(master_img);
        master_title.setText(bean.getAppTitle());
        master_teacher.setText(bean.getTeacherName());
        master_colloeg.setText(bean.getTeacherTitle());
        master_price.setText("￥"+bean.getPrice());

    }

}
