@file:Suppress("DEPRECATION")

package com.example.player.a1610aplayerdemo.welcomeactivity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.ImageView
import android.widget.RadioGroup
import com.example.player.a1610aplayerdemo.MainActivity
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.welcomeactivity.welcomeAdapter.WelcomeVpAdapter
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {
    lateinit var welcomeadapter:WelcomeVpAdapter
    lateinit var wel_vp:ViewPager
    lateinit var wel_rg:RadioGroup
    lateinit var  sp:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
           sp  = getSharedPreferences("isFirst", Context.MODE_WORLD_READABLE);
           initreadHistory()
    }

    private fun initreadHistory() {

        val boolean = sp.getBoolean("first", true)
        if (boolean){
            initView();
            inwelcome()
            initData()
            initListener()
        }else{
            var t = Thread(){
                Thread.sleep(3000)
                runOnUiThread(){
                    tiao()
                }
            }.start()
        // 跳转欢迎页跳转的点击事件
           tv_tiao0.setOnClickListener{
               tiao()
           }
        }
    }

    private fun initListener() {
        wel_rg.setOnCheckedChangeListener{ radioGroup: RadioGroup?, i: Int ->
            when (i){
                paint_1.id -> wel_vp.setCurrentItem(0)
                paint_2.id -> wel_vp.setCurrentItem(1)
                paint_3.id -> wel_vp.setCurrentItem(2)
                paint_4.id -> wel_vp.setCurrentItem(3)
            }
         }

        wel_vp.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(p0: Int) {
                if (wel_vp.currentItem == 3){
                    ljjr.visibility = View.VISIBLE
                }
               return wel_rg.check(wel_rg.getChildAt(p0).id)
            }

        })

        tv_tiao1.setOnClickListener {
           tiao()
        }

        ljjr.setOnClickListener(){
            tiao()
        }
    }

    private fun tiao(){
        var intent = Intent()
        intent.setClass(this,MainActivity::class.java)
        val edit = sp.edit()
        edit.putBoolean("first",false)
        edit.commit()

        startActivity(intent)
    }

    private fun inwelcome() {
       var t = Thread(){
           Thread.sleep(3000)
           runOnUiThread(){
               wel_rl.visibility = View.GONE
           }

       }.start()
        //  导航页的跳转
        tv_tiao1.setOnClickListener {
            runOnUiThread(){
                tiao()
            }
        }

    }

    private fun initData() {
       var img1:ImageView = ImageView(this);
        img1.setImageResource(R.drawable.zjgq1)
        img1.scaleType = ImageView.ScaleType.CENTER_CROP
        var img2:ImageView = ImageView(this);
        img2.setImageResource(R.drawable.tu2)
        img2.scaleType = ImageView.ScaleType.CENTER_CROP
        var img3:ImageView = ImageView(this);
        img3.setImageResource(R.drawable.tu3)
        img3.scaleType = ImageView.ScaleType.CENTER_CROP
        var img4:ImageView = ImageView(this);
        img4.setImageResource(R.drawable.tu4)
        img4.scaleType = ImageView.ScaleType.CENTER_CROP
        var list:List<View> = listOf(img1,img2,img3,img4);
        welcomeadapter.setViews(list);
        wel_vp.adapter = welcomeadapter
    }

    private fun initView() {
        wel_vp = findViewById(R.id.wel_vp)
        wel_rg = findViewById(R.id.wel_rg)
        welcomeadapter = WelcomeVpAdapter();
    }
}
