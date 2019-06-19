package com.example.player.a1610aplayerdemo.ui.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseFragment
import com.example.player.a1610aplayerdemo.logRegUI.LogActivity
import kotlinx.android.synthetic.main.fragment_my.*
import org.jetbrains.anko.support.v4.startActivity


/**
 * A simple [Fragment] subclass.
 *
 */
class MyFragment : BaseFragment() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniView();
    }

    private fun iniView() {
        tolog.setOnClickListener {

            startActivity(Intent(context, LogActivity::class.java))

        }

    }

    override fun initView(): View? {
        return View.inflate(context,R.layout.fragment_my,null);
    }


}
