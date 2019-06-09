package com.example.hasee.dreamvideo.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.example.hasee.dreamvideo.R
import com.example.hasee.dreamvideo.bean.HomeBean
import kotlinx.android.synthetic.main.item_home.view.*

/**
 * Created by Lmz on 2019/06/09
 *  创建home 页面 recyclerview 里面的每一个的子布局
 */
class HomeItemView : RelativeLayout {


    //复写构造方法
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    /**
     * 初始化方法
     */
    init{
        View.inflate(context, R.layout.item_home,this)
        //   上面 传入 this 就省去一步  addView  。
    }
    fun setData(data: HomeBean.DataBean.ListBean) {
        // 设置歌手名字
        item_home_author.setText(data.singers[0].name)
        //设置 歌曲名字
        item_home_singename.setText(data.title)
        //设置图片
        Glide.with(context).load(data.picurl).into(item_home_bg_img)


    }
}