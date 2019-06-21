package com.example.player.a1610aplayerdemo.fragment.membre.Bean


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.View

import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseFragment
import com.example.player.a1610aplayerdemo.fragment.membre.Bean.adapter.MemberAdapter
import com.example.player.a1610aplayerdemo.fragment.membre.Bean.bean.MenmberBean
import com.example.player.a1610aplayerdemo.fragment.membre.Bean.presenter.MemberPresenter
import com.example.player.a1610aplayerdemo.fragment.membre.Bean.presenter.MemberPresenterCompl
import kotlinx.android.synthetic.main.fragment_mv.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MvFragment : BaseFragment() , MemberPresenter.IMemberView{


    val adapter= MemberAdapter()
    val presenter= MemberPresenterCompl(this)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var linearLayoutManager=LinearLayoutManager(context)
        linearLayoutManager.orientation=LinearLayoutManager.VERTICAL
        member_rv.layoutManager=linearLayoutManager
        member_rv.adapter=adapter
//        toolbar.visibility=GONE
    }


    override fun initView(): View? {
        presenter.getData()
        return View.inflate(context,R.layout.fragment_mv,null)
    }
    override fun getSuccessData(menmberBean: MenmberBean) {
        adapter.refresh(menmberBean.data)

    }


    override fun getFailData(e: String) {

    }



}
