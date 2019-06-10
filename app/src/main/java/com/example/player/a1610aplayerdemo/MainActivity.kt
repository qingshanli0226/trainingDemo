package com.example.player.a1610aplayerdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem

class MainActivity : AppCompatActivity() {
    private var vp: ViewPager? = null
    private var nBar: BottomNavigationBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        vp = findViewById(R.id.vp) as ViewPager
        nBar = findViewById(R.id.nBar) as BottomNavigationBar
        nBar!!.setActiveColor("#808080")
            .setInActiveColor("#FF8000")
            .addItem(BottomNavigationItem(R.drawable.ic01, ""))
            .addItem(BottomNavigationItem(R.drawable.ic02, ""))
            .addItem(BottomNavigationItem(R.drawable.ic03, ""))
            .addItem(BottomNavigationItem(R.drawable.ic04, ""))
            .setFirstSelectedPosition(0)
            .initialise()

    }
}
