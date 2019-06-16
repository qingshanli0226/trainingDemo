package com.example.player.a1610aplayerdemo.base;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;

public class DivToolbar extends RelativeLayout{
    private RelativeLayout titleLayout;
    private RelativeLayout leftLayout;
    private RelativeLayout rigthLayout;
    private ImageView leftImage;
    private ImageView rightImage;
    private TextView rightText;
    private EditText centerEText;
    private TextView centerLeftText;
    private TextView centerRightText;

    public DivToolbar(Context context) {
        super(context);
        initView(context, null);
    }

    public DivToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }



    public DivToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs);
    }

    private void initView(Context context,AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.div_toolbar, this);
        titleLayout = findViewById(R.id.title_layout);
        leftLayout = findViewById(R.id.rl_left);
        rigthLayout = findViewById(R.id.rl_right);
        leftImage = findViewById(R.id.bar_iv_left);
        rightImage = findViewById(R.id.bar_iv_right);
        centerLeftText = findViewById(R.id.title_bar1);
        centerRightText = findViewById(R.id.title_bar2);
        centerEText = findViewById(R.id.title_et);
        rightText = findViewById(R.id.bar_tv_right);
        parseStyle(context, attrs);
    }

    private void parseStyle(Context context, AttributeSet attrs) {
        if(attrs != null){
//            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.DivToolbar);
//            <attr name="titleBarLeftImage" format="reference"></attr>
//        <attr name="titleBarRightImage" format="reference"></attr>
//        <attr name="titleBarBackgroud" format="reference|color"></attr>
//        <attr name="titleBarTextLightwidth" format="integer"></attr>
//        <attr name="titleBarTextLightPadding" format="integer"></attr>
//        <attr name="titleBarTextLightBackgroud" format="color"></attr>
//        <attr name="titleBarTextLightSize" format="integer"></attr>
//            <attr name="titleBarTextLightValue" format="string"></attr>
//            String titleBarTextLightValue = ta.getString(R.styleable.DivToolbar_titleBarTextLightValue);
//            if(titleBarTextLightValue != null){
//                centerLeftText.setText(titleBarTextLightValue);
//            }
//            int titleBarTextLightWidth = ta.getInteger(R.styleable.DivToolbar_titleBarTextLightwidth,15);
//            centerLeftText.setWidth(titleBarTextLightWidth);
//            int titleBarTextLightPading = ta.getInteger(R.styleable.DivToolbar_titleBarTextLightPadding,0);
//            centerLeftText.setPadding(titleBarTextLightPading,titleBarTextLightPading,titleBarTextLightPading,titleBarTextLightPading);
//            int titleBarTextLightSize = ta.getInteger(R.styleable.DivToolbar_titleBarTextLightSize,20);
//            centerLeftText.setTextSize(titleBarTextLightSize);
//
//            Drawable leftDrawable = ta.getDrawable(R.styleable.DivToolbar_titleBarLeftImage);
//            if(leftDrawable != null){
//                leftImage.setImageDrawable(leftDrawable);
//            }
//
//            Drawable rightDrawable = ta.getDrawable(R.styleable.DivToolbar_titleBarRightImage);
//            if(rightDrawable != null){
//                rightImage.setImageDrawable(rightDrawable);
//            }
//            Drawable titleBagroud = ta.getDrawable(R.styleable.DivToolbar_titleBarBackgroud);
//            if(titleBagroud != null){
//                titleLayout.setBackground(titleBagroud);
//            }
//            ta.recycle();
        }
    }

    public void setLeftImageResource(int resId) {
        leftImage.setImageResource(resId);
    }
    public void setRightImageResource(int resId) {
        rightImage.setImageResource(resId);
    }

    public void setLeftLayoutClickListener(OnClickListener listener){
        leftLayout.setOnClickListener(listener);
    }

    public void setRightLayoutClickListener(OnClickListener listener){
        rigthLayout.setOnClickListener(listener);
    }

    public void setLeftLayoutVisibility(int visibility){
        leftLayout.setVisibility(visibility);
    }

    public void setRightLayoutVisibility(int visibility){
        rigthLayout.setVisibility(visibility);
    }

    public void setCenterETextLayoutVisibility(int visibility){
        centerEText.setVisibility(visibility);
    }
    public void setCenterLeftTextLayoutVisibility(int visibility){
        centerLeftText.setVisibility(visibility);
    }
    public void setCenterRightTextLayoutVisibility(int visibility){
        centerRightText.setVisibility(visibility);
    }

    public void setBackgroundColor(int color){
        titleLayout.setBackgroundColor(color);
    }
}
