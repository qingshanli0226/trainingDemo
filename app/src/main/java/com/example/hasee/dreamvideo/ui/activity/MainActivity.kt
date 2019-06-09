package com.example.hasee.dreamvideo.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.example.hasee.dreamvideo.R
import com.example.hasee.dreamvideo.base.BaseActivity
import com.example.hasee.dreamvideo.utils.FragmentUtils
import com.example.hasee.dreamvideo.utils.ToolbarManger
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find
import android.support.annotation.IdRes
import com.roughike.bottombar.OnTabSelectListener
import com.example.hasee.dreamvideo.R.id.bottomBar



class MainActivity : BaseActivity(), ToolbarManger {
    //这里是 惰性加载  就是需要的时候初始化 不需要的时候就不用初始化   属于线程安全的操作
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initdata() {
        super.initdata()
        initMainToolbar() //调用我们设置好的
    }

    override fun initlistener() {

        bottomBar.setOnTabSelectListener { tabId ->
            //在这里写点击事件 和fragment联动
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_framelayout,FragmentUtils.fragmentUtils.getFragment(tabId),tabId.toString())
            transaction.commit()
        }
    }

}
