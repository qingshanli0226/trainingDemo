package com.example.player.a1610aplayerdemo.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseFragment
import com.example.player.a1610aplayerdemo.util.Md5Utils
import kotlinx.android.synthetic.main.fragment_study_center.*


/**
 * A simple [Fragment] subclass.
 *
 */
class StudyCenterFragment : BaseFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        var aa = "ew9ngfPvueq1RNxehH2JJU03u6l/wqprpK30xU3JK1feWz/8uEGdLSvFicU2v+vIqwGofd473wVOLXIEAKSjKvbFNJrUGACONVMXlhg+12JBMHnTjjr/VVehnyYsvV0tsngQU8ieRwS/Ppui3Lvzuydclom0b67AaupZ2rNd3/xw1Lb691K7wNxwStVMqx5yBxa1cdJZJ68vYKhrkCflhHA5z5fY1ccLm+prg7COVLw="

        var  s = Md5Utils.MD5(aa);



        jiejie.setOnClickListener {
            hq.setText(s)

        }
    }
    override fun initView(): View? {



        return View.inflate(context,R.layout.fragment_study_center,null);
    }


}
