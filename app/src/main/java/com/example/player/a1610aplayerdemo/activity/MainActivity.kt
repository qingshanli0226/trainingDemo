package com.example.player.a1610aplayerdemo.activity

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.utils.ToolbarManger
import com.example.player.a1610aplayerdemo.base.BaseActivity
import com.example.player.a1610aplayerdemo.utils.FragmentUtils
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find

class MainActivity : BaseActivity(), ToolbarManger {
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }


    override fun initdata() {
        super.initdata()
        initMainToolbar()
    }
    override fun initlistener() {
        bottomBar.setOnTabSelectListener { tabId ->
            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_frameLayout, FragmentUtils.fragmentUtils.getFragment(tabId),tabId.toString())
            transaction.commit()
        }

    }

}
