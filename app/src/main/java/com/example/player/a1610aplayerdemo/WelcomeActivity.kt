package com.example.player.a1610aplayerdemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import android.widget.Button
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    var image_list=ArrayList<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        initView()


    }

    fun initView(){

        image_list.add(R.drawable.new_feature_pic1)
        image_list.add(R.drawable.new_feature_pic2)
        image_list.add(R.drawable.new_feature_pic3)
        image_list.add(R.drawable.new_feature_pic4)
        banner.setImageLoader(MyImageLoader())
            .setImages(image_list)
            .setDelayTime(3000)
            .setBannerStyle(BannerConfig.NUM_INDICATOR)
            .isAutoPlay(false)
            .start()
        banner.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(i: Int, v: Float, i1: Int) {
                if (i == 3) {
                    val intent = Intent(this@WelcomeActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }

            override fun onPageSelected(i: Int) {

            }

            override fun onPageScrollStateChanged(i: Int) {

            }
        })


    }
}
