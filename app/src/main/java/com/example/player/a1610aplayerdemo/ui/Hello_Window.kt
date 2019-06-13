package com.example.player.a1610aplayerdemo.ui

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.example.player.a1610aplayerdemo.R
import kotlinx.android.synthetic.main.activity_hello__window.*

class Hello_Window : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_hello__window)


        var preferences = getSharedPreferences("isFirstUse", Context.MODE_WORLD_READABLE)
        var isFirstUse = preferences.getBoolean("isFirstUse",true)

        hello_btn.setOnClickListener{
            if (isFirstUse){
                var welcome = Intent()
                welcome.setClass(this, Welcome_Activity::class.java)
                startActivity(welcome)
            }else{
                var intent = Intent()
                intent.setClass(this, MainActivity::class.java)
                startActivity(intent)
            }
            //TODO 关掉 hello_window界面
            finish()


            var editor = preferences.edit()
            //TODO 本地记录是否第一次进入软件
            editor.putBoolean("isFirstUse",false)

            editor.commit()
        }
    }
}