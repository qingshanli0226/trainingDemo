package com.example.player.a1610aplayerdemo.ui.activity

import android.content.Intent
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.adapter.GuidePagerAdapter
import com.example.player.a1610aplayerdemo.base.BaseActivity
import com.example.player.a1610aplayerdemo.util.SharedPreferencesUtil

class GuideActivity: BaseActivity(){
    override fun initListener() {

    }


    var sharedPreferencesUtil: SharedPreferencesUtil = SharedPreferencesUtil(this@GuideActivity)
    private lateinit var btn_jump:Button
    private lateinit var btn_ljty:Button
    private lateinit var vp:ViewPager


    override fun getLayoutId(): Int {
       return R.layout.activity_guide
    }


    override fun initData() {
        vp = findViewById(R.id.guide_vp)
        btn_jump = findViewById(R.id.guide_jump)
        btn_ljty = findViewById(R.id.guide_ty)

        val pics = arrayOf(R.drawable.jmqs1, R.drawable.jmqs2, R.drawable.jmqs3, R.drawable.jmqs4)
        val picsList:MutableList<ImageView> = arrayListOf()
        for (i in pics.indices) {
            val  imageView = ImageView(this)
            imageView.setImageResource(pics[i])
            picsList.add(imageView)
        }

        vp.adapter = GuidePagerAdapter(this, picsList)
        vp.currentItem = 0

        vp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                if (position==3){
                    btn_ljty.visibility = View.VISIBLE
                    btn_jump.visibility = View.GONE
                }else{
                    btn_ljty.visibility = View.GONE
                    btn_jump.visibility = View.VISIBLE
                }
            }
        })

        btn_ljty.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                sharedPreferencesUtil.SharedPreferencesSave2String("进入","进了")
                var intent  = Intent()
                intent.setClass(this@GuideActivity,MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                this@GuideActivity.startActivity(intent)
            }
        })

        btn_jump.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                sharedPreferencesUtil.SharedPreferencesSave2String("进入","进了")
                var intent  = Intent()
                intent.setClass(this@GuideActivity,MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                this@GuideActivity.startActivity(intent)
            }
        })
    }
}