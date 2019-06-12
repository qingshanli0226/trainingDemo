package com.example.player.a1610aplayerdemo.utils;

import android.view.Display;

public class Height {
    private Height(){
    }

    private static Height height = new Height();

    public static Height getHeight(){
        return height;
    }

    private Display display;

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }
}
