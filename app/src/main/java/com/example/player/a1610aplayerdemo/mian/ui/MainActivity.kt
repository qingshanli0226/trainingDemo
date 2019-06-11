package com.example.player.a1610aplayerdemo.mian.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.RadioGroup
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.mian.adapter.MainViewPagerAdapter
import com.example.player.a1610aplayerdemo.mian.bean.UserBean
import com.example.player.a1610aplayerdemo.mian.presenter.MainContract
import com.example.player.a1610aplayerdemo.mian.presenter.MainPresenterComple
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //    val items = listOf(
//        "给初学者的RxJava2.0教程（七）: Flowable",
//        "Android之View的诞生之谜",
//        "Android之自定义View的死亡三部曲之Measure",
//        "Using ThreadPoolExecutor in Android ",
//        "Kotlin 泛型定义与 Java 类似，但有着更多特性支持。",
//        "Android异步的姿势，你真的用对了吗？",
//        "Android 高质量录音库。",
//        "Android 边缘侧滑效果，支持多种场景下的侧滑退出。"
//    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mainPresenterComple =  MainPresenterComple();
        mainPresenterComple.getUserInfo();
//        rv_test.layoutManager = LinearLayoutManager(this)
//        var adapter= TestAdapter()
//        rv_test.adapter = adapter
//        adapter.refreshData(items)

    mainViewPager.adapter = MainViewPagerAdapter(supportFragmentManager)
    //为viewpager设置页面滑动监听
    mainViewPager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        }

        override fun onPageSelected(position: Int) {
            //判断滑动后选择的页面设置相应的RadioButton被选中
            when (position) {
                //这里的btn_one two the 分别是布局中的三个RadioButton的id，直接调用其方法进行设置
                0 -> rb1.isChecked = true
                //当只是写btn_one.isChecked获取的是它的选中状态，如果让它 =true 就会默认调用setChecked()方法进行改变状态
                1 -> rb2.isChecked = true
                2 -> rb3.isChecked = true
                3 -> rb4.isChecked = true
            }
        }
    })

    //按钮组的监听器
    rg.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener{
        override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
            when(p1){
                R.id.rb1 -> mainViewPager.currentItem = 0
                R.id.rb2 -> mainViewPager.currentItem = 1
                R.id.rb3 -> mainViewPager.currentItem = 2
                R.id.rb4 -> mainViewPager.currentItem = 3
            }
        }
    })



    }
}
