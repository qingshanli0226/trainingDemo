package com.example.player.a1610aplayerdemo.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;

public class MToolBar extends Toolbar {

    private View view;
    public TextView tb_title;
    public EditText tb_editext;
    public ImageView leftImg;
    public ImageView rightImg;
    public RelativeLayout tb_rl; // 自定义布局
    public TextView ringhtText;

    public MToolBar(Context context) {
        super(context);
        initView();
    }

    public MToolBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    @SuppressLint("RestrictedApi")
    public MToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView();
        if (attrs != null) {
            @SuppressLint("RestrictedApi") TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs, R.styleable.MToolBar, defStyleAttr, 0);
            Drawable rightIcon = a.getDrawable(R.styleable.MToolBar_rightimg);
            if (rightIcon != null) {
                setRightIcon(rightIcon);
            }

            boolean ishsowEdit = a.getBoolean(R.styleable.MToolBar_isShowedit, false);
            if (ishsowEdit) {
                showEditextView();
                hideTitleView();
            }

            String title = a.getString(R.styleable.MToolBar_title);
            if (title != null) {
                showTitleView();
                setTitle(title);
            }

            a.recycle();
        }

    }


    public void setLeftImg(int id) {
        leftImg.setVisibility(VISIBLE);
        leftImg.setImageResource(id);
    }

    public void setRightIcon(Drawable rightIcon) {
        rightImg.setImageDrawable(rightIcon);
        rightImg.setVisibility(VISIBLE);
    }

    private void initView() {
        if (view == null) {
            view = LayoutInflater.from(getContext())
                    .inflate(R.layout.mtoolbar, null);

            tb_title = view.findViewById(R.id.tb_title);
            tb_editext = view.findViewById(R.id.tb_edit);
            leftImg = view.findViewById(R.id.tb_leftImg);
            rightImg = view.findViewById(R.id.tb_rightImg);
            tb_rl = view.findViewById(R.id.m_toolbar);
            ringhtText = view.findViewById(R.id.tb_righText);

            LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);

            addView(view, layoutParams);
        }
    }


    public void showRightText() {
        if (ringhtText != null) {
            ringhtText.setVisibility(VISIBLE);
        }
    }

    public void hideLeftIcon(){
        if (leftImg != null){
            leftImg.setVisibility(GONE);
        }
    }

    public void showLeftIcon(){
        if (leftImg != null){
            leftImg.setVisibility(VISIBLE);
        }
    }

    public void showRightIcon(){
        if (rightImg != null){
            rightImg.setVisibility(VISIBLE);
        }
    }

    public void hideRightIcon(){
        if (rightImg != null){
            rightImg.setVisibility(GONE);
        }
    }

    public void setrightText(String text) {
        if (ringhtText != null) {
            if (ringhtText.isShown()) {
                ringhtText.setText(text);
            } else {
                showRightText();
            }
            ringhtText.setText(text);
        }
    }

    public void hideRightText() {
        if (ringhtText != null) {
            ringhtText.setVisibility(VISIBLE);
        }
    }

    public void showEditextView() {
        if (tb_editext != null) {
            tb_editext.setVisibility(VISIBLE);
            //  添加Try catch 是为了防止堆内存 溢出  导致程序蹦掉，  因为超出8MB就会自己挂掉
            try {
                hideTitleView();
            } catch (StackOverflowError e) {
                e.getMessage();
            }

        }
    }

    public void hideEditextView() {
        if (tb_editext != null) {
            tb_editext.setVisibility(GONE);


            try {
                showTitleView();
            } catch (StackOverflowError e) {
                e.getMessage();
            }

        }
    }

    public void showTitleView() {
        if (tb_title != null) {
            tb_title.setVisibility(VISIBLE);


            try {
                hideEditextView();
            } catch (StackOverflowError e) {
                e.getMessage();
            }

        }
    }

    public void hideTitleView() {
        if (tb_title != null) {
            tb_title.setVisibility(GONE);

            try {
                showEditextView();
            } catch (StackOverflowError e) {
                e.getMessage();
            }

        }
    }

    @Override
    public void setBackgroundColor(int color) {
        super.setBackgroundColor(color);
        tb_rl.setBackgroundColor(color);
    }

    @Override
    public void setTitle(int resId) {
        super.setTitle(resId);
    }

    @Override
    public void setTitle(CharSequence title) {
        showTitleView();
        if (tb_title != null) {
            tb_title.setText(title);
        }
    }

    public void setRightIcon(int id) {
        rightImg.setVisibility(VISIBLE);
        rightImg.setImageResource(id);
    }

    public void setrightListener(OnClickListener onClickListener) {
        if (rightImg != null) {
            rightImg.setOnClickListener(onClickListener);
        } else if (ringhtText != null) {
            ringhtText.setOnClickListener(onClickListener);
        }

    }

    public void setleftListener(OnClickListener onClickListener) {
        if (leftImg != null) {
            leftImg.setOnClickListener(onClickListener);
        }
    }

}
