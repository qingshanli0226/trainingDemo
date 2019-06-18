package com.example.player.a1610aplayerdemo.ui.activity

import android.content.Context
import android.content.res.Configuration
import android.support.v7.widget.ActivityChooserView
import android.view.View
import com.bumptech.glide.Glide
import com.dou361.ijkplayer.R.id.iv_trumb
import com.dou361.ijkplayer.listener.OnShowThumbnailListener
import com.dou361.ijkplayer.widget.PlayStateParams
import com.dou361.ijkplayer.widget.PlayerView
import com.example.player.a1610aplayerdemo.MyApplication
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseActivity
import org.jetbrains.anko.layoutInflater
import tv.danmaku.ijk.media.player.IjkMediaPlayer

/**
 * Created by Lmz on 2019/06/17
 *   商品详情页面1
 */
class GoodsInfoActivity :BaseActivity(){
    var vidioUrl="http://qukufile2.qianqian.com/data2/video/3bb92059a78e3c1bdc18b6a603a7d01d/607962660/607962660.mp4"
    lateinit var player:PlayerView
    override fun getLayoutId(): Int {
        return R.layout.activity_goodsinfo
    }

    override fun initlistener() {
        super.initlistener()


        player = PlayerView(this).setTitle("燃烧我的卡路里")
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .showThumbnail(OnShowThumbnailListener {
                    Glide.with(MyApplication.getContext())
                            .load("http://i5.3conline.com/images/piclib/201207/05/batch/1/139696/13414780463848u9bvk9q1w_medium.jpg")
                            .placeholder(R.color.Grey_50)
                            .error(R.color.Grey_100)

                })
                .setPlaySource(vidioUrl)
                .startPlay()
    }

    override fun onDestroy() {

        super.onDestroy()
        player.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        player.onResume()

    }

    override fun onPause() {
        super.onPause()
        if(player!=null){
            player.onPause()
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        player.onConfigurationChanged(newConfig)
    }




}