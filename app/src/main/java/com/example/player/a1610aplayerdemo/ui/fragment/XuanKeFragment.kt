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
import com.example.player.a1610aplayerdemo.ui.xuankepresenter.XuanKePresenterCompl


class XuanKeFragment : BaseFragment(),XuanKeInterface.XuanKeView {

    val  adp = XuanKeAdp();

    var presenter = XuanKePresenterCompl(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        xry.setLayoutManager(layoutManager);
        xry.adapter = adp
    }

    override fun onGetDataSuccess(bean: XuanKeDateBean) {
        adp.addBannerDate(bean.homeBanner)
        adp.addBean(bean.homeCategory)
        adp.addVip(bean.vipRecommend)
        adp.addZhuanLan(bean.zlList)
        adp.addTuiJian(bean.courseRecommends)
        adp.addDaShi(bean.masterLives)

    }

    override fun onGetDataFailed(errorMsg: String) {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun initView(): View? {
        presenter.getXkData()

        return View.inflate(context, com.example.player.a1610aplayerdemo.R.layout.fragment_xuan_ke,null);
    }


    override fun onDestroy() {
        super.onDestroy()

        presenter.detachView()
    }


}
