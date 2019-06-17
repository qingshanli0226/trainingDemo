package com.example.player.a1610aplayerdemo.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.adapter.VipView_Adapter
import com.example.player.a1610aplayerdemo.base.BaseFragment
import com.example.player.a1610aplayerdemo.base.IBaseView
import com.example.player.a1610aplayerdemo.bean.MemberBean
import com.example.player.a1610aplayerdemo.utils.SharePresenterUtils
import kotlinx.android.synthetic.main.fragment_vip.*

/**
 * Created by Lmz on 2019/06/11
 */
class VipFragment :BaseFragment(),IBaseView<MemberBean.DataBean> {


    var presenter= VipPresenter()
    var adapter = VipView_Adapter()
    override fun initview(): View? {
        return View.inflate(context, R.layout.fragment_vip,null);
    }

    override fun initlistener() {
        super.initlistener()
        presenter.attachView(this)
        presenter.setParams("0","20")
        presenter.getData()
    }

    override fun initdata() {
        super.initdata()
        var user = SharePresenterUtils.getUserInfo()
        if (user!=null){
            //这里显示 登录之后的视图
        }
        var manager = LinearLayoutManager(context)
        manager.orientation = LinearLayoutManager.VERTICAL
        vip_recycler.layoutManager=manager
        vip_recycler.adapter=adapter
    }



    override fun loadDataFailure(code: Int, ErrorMess: String?) {
        myToast(ErrorMess!!);
    }

    override fun onDestroy() {
        super.onDestroy()
        //置为 null
        presenter.detachView()
    }




    override fun loadDataSuccess(bean: MemberBean.DataBean?) {
    }

    override fun LoadListDataSuccess(data: MutableList<MemberBean.DataBean>?) {
        adapter.Refresh(data)
    }

}