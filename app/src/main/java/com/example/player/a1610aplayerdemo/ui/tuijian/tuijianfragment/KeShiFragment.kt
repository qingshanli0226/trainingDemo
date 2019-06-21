package com.example.player.a1610aplayerdemo.ui.tuijian.tuijianfragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.player.a1610aplayerdemo.MyApp

import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseAdapter
import com.example.player.a1610aplayerdemo.base.BaseFragment
import com.example.player.a1610aplayerdemo.bean.TuiJianDateBean
import com.example.player.a1610aplayerdemo.ui.tuijian.tuijianpresenter.TuiJianInterface
import com.example.player.a1610aplayerdemo.ui.tuijian.tuijianpresenter.TuiJianPresenterCompl
import com.example.player.a1610aplayerdemo.util.SpUtil
import kotlinx.android.synthetic.main.fragment_ke_shi.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */

class KeShiFragment : BaseFragment(), TuiJianInterface.TuiJianView,BaseAdapter.Onckitem {


    override fun dianji(i: Int) {

    }

    var presenter = TuiJianPresenterCompl(this)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val linearLayoutManager = LinearLayoutManager(MyApp.instance)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        tuijian_erji_recy.layoutManager = linearLayoutManager

        tuijian_erji_recy.adapter = adp;

    }

    override fun onGetDataSuccess(bean: TuiJianDateBean) {

        adp.refreshData(bean.chapters)

    }

    override fun onGetDataFailed(errorMsg: String) {
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    var adp = TuiJianClassAdp();
    override fun initView(): View? {
        val getid = SpUtil.getid();

        presenter.getTuiJianData(getid)
        return View.inflate(context,R.layout.fragment_ke_shi,null);


    }

}
