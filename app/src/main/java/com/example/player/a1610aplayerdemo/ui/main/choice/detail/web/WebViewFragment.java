package com.example.player.a1610aplayerdemo.ui.main.choice.detail.web;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.example.player.a1610aplayerdemo.R;

public class WebViewFragment extends Fragment {
    WebView webView;
    String standard;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.details_vp_web, container, false);
        webView = inflate.findViewById(R.id.detail_web);
        return inflate;
    }

    public void setData(String s) {
        Log.e("web", "setData: " + s);

        standard = "<html> \n" +
                "<head> \n" +
                "<style type=\"text/css\"> \n" +
                "body {font-size:13px;}\n" +
                "</style> \n" +
                "</head> \n" +
                "<body>" +
                "<script type='text/javascript'>" +
                "window.onload = function(){\n" +
                "var $img = document.getElementsByTagName('img');\n" +
                "for(var p in  $img){\n" +
                " $img[p].style.width = '100%%';\n" +
                "$img[p].style.height ='auto'\n" +
                "}\n" +
                "}" +
                "</script>" +
                s
                + "</body>" +
                "</html>";


//        if(standard != null){
//            Log.e("qwe", "setData:字符串不是空 ");
//            if(webView != null){
//                Log.e("qwe", "setData: web不为空" );
        webView.loadDataWithBaseURL(null, standard, "text/html", "utf-8", null);
//            }else{
//                Log.e("qwe", "setData: web空" );
//
//            }
//        }else{
//            Log.e("qwe", "setData:字符串空 ");
//        }

    }

}
