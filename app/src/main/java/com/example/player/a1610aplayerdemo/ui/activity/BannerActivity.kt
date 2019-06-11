package com.example.player.a1610aplayerdemo.ui.activity

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.R.id.splash_banner
import com.example.player.a1610aplayerdemo.R.id.splash_go
import com.example.player.a1610aplayerdemo.adapter.GuidePageAdapter
import com.example.player.a1610aplayerdemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_banner.*
import org.jetbrains.anko.support.v4.onPageChangeListener

/**
 * Created by Lmz on 2019/06/11
 *  这里写 banner 欢迎页面
 */
class BannerActivity:BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_banner
    }
    //  把引导页面的 banner 添加到数组中去
    var imgPath :Array<Int> = arrayOf(R.mipmap.splash_banner1,R.mipmap.splash_banner2,R.mipmap.splash_banner3,R.mipmap.splash_banner4)
    //图片 视图的集合

    override fun initlistener() {
        super.initlistener()
        var viewlist = arrayListOf<View>()
        // 设置布局参数为 全屏
        var params =LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT)
        for (id in imgPath){
            var img=ImageView(this)
            img.layoutParams=params
            img.setBackgroundResource(id)
            viewlist.add(img)
        }
        var adapter = GuidePageAdapter(viewlist)
        splash_banner.adapter =adapter


        //设置点击事件
        splash_banner.onPageChangeListener {
            this.onPageSelected {
                Log.d("lmz","当前页面"+it);
                if (it==3){
                    splash_go.visibility=View.VISIBLE
                }else{
                    splash_go.visibility=View.GONE
                }

            }


        }

        splash_go.setOnClickListener {
                startActivityAndFinainsh<MainActivity>()
        }
    }

}