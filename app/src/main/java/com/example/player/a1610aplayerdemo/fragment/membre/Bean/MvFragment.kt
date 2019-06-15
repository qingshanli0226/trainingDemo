package com.example.player.a1610aplayerdemo.fragment.membre.Bean


import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup

import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseFragment
import com.example.player.a1610aplayerdemo.utils.ToolbarManger
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_mv.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.find
import java.nio.file.Files.find

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MvFragment : BaseFragment() ,MemberPresenter.IMemberView{


    val adapter= MemberAdapter()
    val presenter=MemberPresenterCompl(this)



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
