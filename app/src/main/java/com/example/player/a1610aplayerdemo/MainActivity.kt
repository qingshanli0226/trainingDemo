package com.example.player.a1610aplayerdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.player.a1610aplayerdemo.adapter.MainVpAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  lateinit var mainVpAdapter:MainVpAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
          init();
    }

    private fun init() {
        mainVpAdapter = MainVpAdapter(supportFragmentManager);
        m_vp.adapter = mainVpAdapter;
        m_tb.setupWithViewPager(m_vp)
    }
}
