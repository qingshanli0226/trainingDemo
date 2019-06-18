package com.example.player.a1610aplayerdemo.presenter.find_category_presenter;

import com.example.player.a1610aplayerdemo.base.BasePresenter;
import com.example.player.a1610aplayerdemo.bean.LiveBean;
import com.example.player.a1610aplayerdemo.bean.TeacherTypeBean;

import java.lang.reflect.Type;
import java.util.HashMap;

public class CategoryTeacherPresenter extends BasePresenter<TeacherTypeBean.DataBean>{
    @Override
    public String getAPIPath1() {
        return "szrz";
    }

    @Override
    public String getAPIPath2() {
        return "getCategory";
    }

    @Override
    public Type getDataType() {
        return TeacherTypeBean.class;
    }


}
