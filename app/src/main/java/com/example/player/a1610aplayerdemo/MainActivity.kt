package com.example.player.a1610aplayerdemo

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.example.player.a1610aplayerdemo.activity.InterfaceActivity
import com.example.player.a1610aplayerdemo.adapter.GuidePageAdapter

class MainActivity : AppCompatActivity() ,ViewPager.OnPageChangeListener{
    private var main_pager:ViewPager?=null;
    private var imageIdArray: IntArray? = null//图片资源的数组
    private var viewList: MutableList<View>? = null//图片资源的集合
    private var vg: ViewGroup? = null//放置圆点
    //实例化圆点view
    private var iv_point: ImageView? = null
    private var ivPointArray: Array<ImageView?>? = null



    //最后一页的按钮
    private var ib_start: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (use()) {
            val intent: Intent =Intent(this,InterfaceActivity::class.java)
            startActivity(intent)
        }
        ib_start = findViewById(R.id.guide_ib_start) as Button
        ib_start!!.setOnClickListener {
            val intent: Intent =Intent(this,InterfaceActivity::class.java)
            val sharedPreferences = getSharedPreferences("guide1", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean("guide", true)
            editor.commit()
            startActivity(intent)
            finish();
        }
        initViewPager();
        initPoint();
    }
    fun use(): Boolean {
        val sharedPreferences = getSharedPreferences("guide1", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("guide", false)
    }
    private fun initPoint() {
        //这里实例化LinearLayout
        vg = findViewById(R.id.guide_ll_point) as ViewGroup
        //根据ViewPager的item数量实例化数组
        ivPointArray = arrayOfNulls(viewList!!.size)
        //循环新建底部圆点ImageView，将生成的ImageView保存到数组中
        val size = viewList!!.size
        for (i in 0..size - 1) {
            iv_point = ImageView(this)
            iv_point!!.layoutParams = ViewGroup.LayoutParams(50, 50)
            iv_point!!.setPadding(20, 0, 20, 150)//left,top,right,bottom
            ivPointArray!![i] = iv_point!!
            //第一个页面需要设置为选中状态，这里采用两张不同的图片
            if (i == 0) {
                iv_point!!.setBackgroundResource(R.mipmap.aa2)
            } else {
                iv_point!!.setBackgroundResource(R.mipmap.aa1)
            }
            //将数组中的ImageView加入到ViewGroup
            vg!!.addView(ivPointArray!![i])
        }
    }
    private fun initViewPager() {
        main_pager = findViewById(R.id.main_pager) as ViewPager
        //实例化图片资源
        imageIdArray = intArrayOf(R.mipmap.tp01, R.mipmap.tp02, R.mipmap.tp03,R.mipmap.tp04);
        viewList = ArrayList()

        //循环创建View并加入到集合中
        val len = imageIdArray!!.size
        for (i in 0..len - 1) {
            //new ImageView并设置全屏和图片资源
            val imageView = ImageView(this)
            viewList!!.add(imageView)
        }

        //View集合初始化好后，设置Adapter
        main_pager!!.adapter = GuidePageAdapter(viewList)
        main_pager!!.offscreenPageLimit=9
//        //设置滑动监听
        main_pager!!.setOnPageChangeListener(this)
    }
     override fun onPageSelected(position:Int){
        val  length=imageIdArray!!.size;
         for (i in 0..length-1){
             ivPointArray!![position]!!.setBackgroundResource(R.mipmap.aa2)
             if (position != i) {
                 ivPointArray!![i]!!.setBackgroundResource(R.mipmap.aa1)
             }
         }
         //判断是否是最后一页，若是则显示按钮
         if (position == imageIdArray!!.size - 1) {
             ib_start!!.visibility = View.VISIBLE
             vg!!.visibility=View.GONE;
         } else {
             ib_start!!.visibility = View.GONE
             vg!!.visibility=View.VISIBLE;
         }
     }
    override fun onPageScrollStateChanged(p0: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
