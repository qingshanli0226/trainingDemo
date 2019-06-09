package com.example.hasee.dreamvideo.ui.activity

import android.preference.PreferenceManager
import android.support.v7.widget.Toolbar
import com.example.hasee.dreamvideo.R
import com.example.hasee.dreamvideo.base.BaseActivity
import com.example.hasee.dreamvideo.utils.ToolbarManger
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

/**
 * Created by Lmz on 2019/06/08
 */
class SettingActivity: BaseActivity(),ToolbarManger {
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }
    override fun getLayoutId(): Int {
        //PreferenceFragment  PreferenceActivity

        return R.layout.activity_setting
    }

    override fun initdata() {
        initSettingToolbar()
        //判断推送是否被选中
        val sp = PreferenceManager.getDefaultSharedPreferences(this)
        val boolean = sp.getBoolean("push", false)  //根据我们设置的 key值 去获取 状态  ！！系统会自动保存状态
        toast(""+boolean)
    }
}