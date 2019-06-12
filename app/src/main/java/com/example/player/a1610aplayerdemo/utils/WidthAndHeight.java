package com.example.player.a1610aplayerdemo.utils;

import android.view.Display;

public class WidthAndHeight {
    private WidthAndHeight(){
    }

    private static WidthAndHeight height = new WidthAndHeight();

    public static WidthAndHeight getHeight(){
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
