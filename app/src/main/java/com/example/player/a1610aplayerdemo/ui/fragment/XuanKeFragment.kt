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



class XuanKeFragment : BaseFragment(),XuanKeInterface.XuanKeView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        xry.setLayoutManager(layoutManager);

        xry.adapter = adp
    }

    val  adp = XuanKeAdp();

    override fun onGetDataSuccess(bean: XuanKeDateBean) {
        adp.addBannerDate(bean.data.homeBanner)
        adp.addBean(bean.data.homeCategory)
        adp.addZhuanLan(bean.data.zlList)
        adp.addTuiJian(bean.data.courseRecommends)
        adp.addDaShi(bean.data.masterLives)

    }

    override fun onGetDataFailed(errorMsg: String) {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun initView(): View? {


        return View.inflate(context, R.layout.fragment_xuan_ke,null);
    }



}
