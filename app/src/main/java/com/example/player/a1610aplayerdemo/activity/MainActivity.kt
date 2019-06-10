package com.example.player.a1610aplayerdemo.activity

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.utils.ToolbarManger
import com.example.player.a1610aplayerdemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find

class MainActivity : BaseActivity(), ToolbarManger {
    override fun getLayoutId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return R.layout.activity_main
    }

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun initdata() {
        super.initdata()
        initMainToolbar()
    }
    override fun initlistener() {
        super.initlistener()
        bottomBar.setOnTabSelectListener { tabId ->
            val transaction=supportFragmentManager.beginTransaction()
//            transaction.replace(R.id.main_frameLayout,FragmentUtil)
        }

    }

}
