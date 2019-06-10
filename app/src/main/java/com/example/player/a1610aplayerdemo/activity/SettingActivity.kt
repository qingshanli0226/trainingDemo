package com.example.player.a1610aplayerdemo.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.widget.Toolbar
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseActivity
import com.example.player.a1610aplayerdemo.utils.ToolbarManger
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

class SettingActivity : BaseActivity(),ToolbarManger {

    override val toolbar by lazy{ find<Toolbar>(R.id.toolbar) }
    override fun getLayoutId(): Int {

        return R.layout.activity_setting

    }

    override fun initdata() {
        initSettingToolbar()
        val sp=PreferenceManager.getDefaultSharedPreferences(this)
        val boolean=sp.getBoolean("push",false)
        toast(""+boolean)
    }

}
