package com.example.player.a1610aplayerdemo.mian.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.player.a1610aplayerdemo.MyFragment
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.StudyFragment
import com.example.player.a1610aplayerdemo.mian.presenter.MainPresenterComple
import com.example.player.a1610aplayerdemo.selectclass.ui.SelectClassFragment
import com.example.player.a1610aplayerdemo.vip.VipFragment
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
        var mainPresenterComple =  MainPresenterComple()
        mainPresenterComple.getUserInfo()

        var currentFragment:Fragment = SelectClassFragment()
        supportFragmentManager.beginTransaction().add(R.id.mainViewPager,currentFragment).commit()
            //按钮组的监听器
        rg.setOnCheckedChangeListener { p0, p1 ->
            when(p1){
                R.id.rb1 -> currentFragment = SelectClassFragment()
                R.id.rb2 -> currentFragment = VipFragment()
                R.id.rb3 -> currentFragment = StudyFragment()
                R.id.rb4 -> currentFragment = MyFragment()
            }
            supportFragmentManager.beginTransaction().replace(R.id.mainViewPager,currentFragment).commit()
        }


    }
}
