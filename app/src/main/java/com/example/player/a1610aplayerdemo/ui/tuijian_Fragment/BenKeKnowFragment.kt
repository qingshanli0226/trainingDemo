package com.example.player.a1610aplayerdemo.ui.tuijian_Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseFragment
import com.example.player.a1610aplayerdemo.bean.TuiJianDateBean
import com.example.player.a1610aplayerdemo.ui.tuijianpresenter.TuiJianInterface
import com.example.player.a1610aplayerdemo.ui.tuijianpresenter.TuiJianPresenterCompl
import com.example.player.a1610aplayerdemo.util.SpUtil
import kotlinx.android.synthetic.main.fragment_ben_ke_know.*


/**
 * A simple [Fragment] subclass.
 *
 */
class BenKeKnowFragment : BaseFragment(),TuiJianInterface.TuiJianView{
    var presenter = TuiJianPresenterCompl(this)
    override fun hideLoading() {
    }

    override fun showLoading() {
    }

    override fun onGetDataFailed(errorMsg: String) {

    }

    override fun onGetDataSuccess(bean: TuiJianDateBean) {

        erjituijian_nerong.setText(bean.courseIntroduce)
    }

    override fun initView(): View? {

        val getid = SpUtil.getid();

        presenter.getTuiJianData(getid)

        return View.inflate(context,R.layout.fragment_ben_ke_know,null);
    }


}
