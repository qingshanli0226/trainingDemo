package com.example.player.a1610aplayerdemo.utils

import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.activity.SettingActivity
import org.jetbrains.anko.startActivity

interface ToolbarManger {
    val toolbar:Toolbar
    fun initMainToolbar(){
        toolbar.setTitle("喜慧")
        toolbar.inflateMenu(R.menu.main)
        toolbar.setOnMenuItemClickListener(object :Toolbar.OnMenuItemClickListener{
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                when(item?.itemId){
                    R.id.setting -> {
                        toolbar.context.startActivity<SettingActivity>()
                    }
                }
                return true
            }

        })
    }
    fun initSettingToolbar(){
        toolbar.setTitle("设置")
    }
}