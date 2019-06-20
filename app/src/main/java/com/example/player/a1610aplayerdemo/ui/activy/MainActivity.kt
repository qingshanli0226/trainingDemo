package com.example.player.a1610aplayerdemo.ui.activy

import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseActivity
import com.example.player.a1610aplayerdemo.ui.adapter.VpgFragmentAdp
import com.example.player.a1610aplayerdemo.ui.fragment.MyFragment
import com.example.player.a1610aplayerdemo.ui.fragment.StudyCenterFragment
import com.example.player.a1610aplayerdemo.ui.huiyuan.VipFragment
import com.example.player.a1610aplayerdemo.ui.xuanke.XuanKeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :  BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var date = listOf<Fragment>(XuanKeFragment(), StudyCenterFragment(),
            VipFragment(),MyFragment())
        novpg.adapter  = VpgFragmentAdp(supportFragmentManager,date)

        grp.setOnCheckedChangeListener {group, checkedId ->
            when(checkedId){
                R.id.rb1 -> novpg.setCurrentItem(0)
                R.id.rb2 -> novpg.setCurrentItem(1)
                R.id.rb3 -> novpg.setCurrentItem(2)
                R.id.rb4 -> novpg.setCurrentItem(3)
            }
        }
    }

    override fun getLayoutId(): Int {

        return R.layout.activity_main
    }


}
