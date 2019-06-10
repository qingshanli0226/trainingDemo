package com.example.player.a1610aplayerdemo.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseFragment
import com.example.player.a1610aplayerdemo.bean.XuanKeDateBean
import com.example.player.a1610aplayerdemo.ui.xuankepresenter.XuanKeInterface
import kotlinx.android.synthetic.main.fragment_xuan_ke.*
import android.support.v7.widget.LinearLayoutManager
import com.example.player.a1610aplayerdemo.ui.xuankeadapter.XuanKeAdp


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class XuanKeFragment : BaseFragment(),XuanKeInterface.XuanKeView {

    val  adp = XuanKeAdp();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        xry.setLayoutManager(layoutManager);

        xry.adapter = adp
    }

    override fun onGetDataSuccess(bean: XuanKeDateBean) {
        adp.addBannerDate(bean.data.homeBanner)


    }

    override fun onGetDataFailed(errorMsg: String) {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun initView(): View? {
        return View.inflate(context, com.example.player.a1610aplayerdemo.R.layout.fragment_xuan_ke,null);
    }



}
