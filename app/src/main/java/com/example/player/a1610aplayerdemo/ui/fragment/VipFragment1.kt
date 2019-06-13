package com.example.player.a1610aplayerdemo.ui.fragment


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager

import android.view.View
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseFragment
import com.example.player.a1610aplayerdemo.bean.VipDateBean
import com.example.player.a1610aplayerdemo.ui.vipadapter.VipAdp
import com.example.player.a1610aplayerdemo.ui.vippresenter.VipInterface
import com.example.player.a1610aplayerdemo.ui.vippresenter.VipPresenterCompl
import kotlinx.android.synthetic.main.fragment_vip.*


class VipFragment : BaseFragment() ,VipInterface.VipView{

    val  adp  = VipAdp()

    var presenter = VipPresenterCompl(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        viprecy.setLayoutManager(layoutManager);

    }

    override fun onGetDataSuccess(bean: List<VipDateBean>) {


        adp.refreshData(bean)

        viprecy.adapter = adp
    }

    override fun onGetDataFailed(errorMsg: String) {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun initView(): View? {

        presenter.getVipData()
        return View.inflate(context, R.layout.fragment_vip,null);
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.detachView()
    }

}
