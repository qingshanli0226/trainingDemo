package com.example.player.a1610aplayerdemo.ui.activy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseActivity
import com.example.player.a1610aplayerdemo.ui.adapter.VpgFragmentAdp
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.webView

class MainActivity :  BaseActivity() {
    override fun getLayoutId(): Int {

        return R.layout.activity_main



        var adp =  VpgFragmentAdp(supportFragmentManager);
        novpg.adapter = adp

        grp.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.rb1 -> novpg.setCurrentItem(0)
                R.id.rb2 -> novpg.setCurrentItem(1)
                R.id.rb3 -> novpg.setCurrentItem(2)
                R.id.rb4 -> novpg.setCurrentItem(3)
            }
        }
    }




}
