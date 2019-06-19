package com.example.player.a1610aplayerdemo.mvvm.databinding.book;

import com.example.player.a1610aplayerdemo.mvvm.databinding.base.BaseMode;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class MovementMode extends BaseMode<List<MovementBean>> {
    @Override
    public String getAPIPath() {
        return "movement.json";
    }

    @Override
    public Type getDataType() {
        return new TypeToken<List<MovementBean>>(){}.getType();
    }
}
