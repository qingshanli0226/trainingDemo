package com.example.player.a1610aplayerdemo.welcome

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.mian.ui.MainActivity
import com.squareup.picasso.Picasso
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.activity_we_come.*

class WeComeActivity : AppCompatActivity() {
    var imagePath = listOf<Int>(R.drawable.tu2,R.drawable.tu3,R.drawable.tu4,R.drawable.tu5)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_we_come)

        banner_welcome.isAutoPlay(false)
        banner_welcome.setImageLoader(MyImagerLoader())
        banner_welcome.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        banner_welcome.setBannerAnimation(Transformer.ZoomOutSlide)
        //设置指示器的位置，小点点，居中显示
        banner_welcome.setIndicatorGravity(BannerConfig.CENTER)
        banner_welcome.setImages(imagePath)
            .start()

        btn_jump.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                var intent = Intent(this@WeComeActivity, MainActivity::class.java)

                startActivity(intent)
            }

        })
    }


    class MyImagerLoader : ImageLoader() {
        override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
            Picasso.get()
                .load(path.toString().toInt())
                .into(imageView)
        }

    }
}
