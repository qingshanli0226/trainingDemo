package com.example.player.a1610aplayerdemo.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseActivity
import com.example.player.a1610aplayerdemo.utils.FragmentUtils
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    override fun getLayoutId(): Int {
      return R.layout.activity_main
    }

    override fun initlistener() {
        super.initlistener()
       main_tottombar.setOnTabSelectListener {
             var fragment= FragmentUtils.fragmentUtils.SelectFragment(it)
              var traceElement=  supportFragmentManager.beginTransaction()
                traceElement.replace(R.id.main_fragelayout,fragment).commit()
       }
    }
}
