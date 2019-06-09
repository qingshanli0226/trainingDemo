package com.example.hasee.dreamvideo.utils

import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Toast
import com.example.hasee.dreamvideo.R
import com.example.hasee.dreamvideo.ui.activity.SettingActivity
import org.jetbrains.anko.startActivity

/**
 * Created by Lmz on 2019/06/08
 *  创建所有界面的 toolbar 管理类
 */
interface ToolbarManger {
    val toolbar: Toolbar
    /**
     * 初始化 主界面toolbar
     */
   fun initMainToolbar(){
        toolbar.setTitle("梦真影音")
        toolbar.inflateMenu(R.menu.main)
        toolbar.setOnMenuItemClickListener(object :Toolbar.OnMenuItemClickListener{
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                //item 后面加个？ 等于非空判断 如果为空 不执行， 不加会报错
                when(item?.itemId){
                    R.id.setting->{
                        //这里跳转到设置界面
                        toolbar.context.startActivity<SettingActivity>()
                    }
                }
                return true
            }
        })

     /*   toolbar.setOnMenuItemClickListener {a->
            println("item==${a}")
            //这里跳转到设置界面
            toolbar.context.startActivity<SettingActivity>()
             true
        }*/
    }
    /**
     *  初始化 设置界面的 toolbar
     */
    fun initSettingToolbar(){
        toolbar.setTitle("设置")
    }
}