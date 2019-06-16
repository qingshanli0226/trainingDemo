package com.example.player.a1610aplayerdemo.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearLayoutManager.VERTICAL
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.adapter.FindAdapter
import com.example.player.a1610aplayerdemo.base.BaseFragment
import com.example.player.a1610aplayerdemo.base.IBaseView
import com.example.player.a1610aplayerdemo.bean.HomeBean
import com.example.player.a1610aplayerdemo.ui.activity.LoginActivity
import com.example.player.a1610aplayerdemo.utils.SharePresenterUtils
import kotlinx.android.synthetic.main.fragment_find.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * Created by Lmz on 2019/06/11
 */
class FindFragment :BaseFragment(),IBaseView<HomeBean> {



    val presenter = FindPresenter()
    override fun initview(): View? {
        return View.inflate(context,R.layout.fragment_find,null)
    }

    override fun initlistener() {
        super.initlistener()
        //展示头像
        Glide.with(context).load(SharePresenterUtils.getAvatar()).into(find_heard_avatar)
        var manger  = LinearLayoutManager(context)
        manger.orientation=VERTICAL
        find_recyclerview.layoutManager = manger

        find_heard_avatar.setOnClickListener {
            startActivity<LoginActivity>()
        }

        presenter.attachView(this)
        presenter.getData()
    }


    override fun loadDataFailure(code: Int, ErrorMess: String?) {
        myToast(ErrorMess.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }


    override fun loadDataSuccess(bean: HomeBean?) {
        val adapter  = FindAdapter(context,bean)
        find_recyclerview.adapter = adapter
    }

    override fun LoadListDataSuccess(data: MutableList<HomeBean>?) {

    }

}