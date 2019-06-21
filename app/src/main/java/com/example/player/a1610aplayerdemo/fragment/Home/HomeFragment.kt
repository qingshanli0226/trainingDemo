package com.example.player.a1610aplayerdemo.fragment.Home


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.telecom.TelecomManager
import android.telephony.TelephonyManager
import android.util.Log
import android.view.View
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseFragment
import com.example.player.a1610aplayerdemo.fragment.Home.adapter.SelectorAdapter
import com.example.player.a1610aplayerdemo.fragment.Home.adapter.SelectorAdapter1
import com.example.player.a1610aplayerdemo.fragment.Home.bean.SelectorBean
import com.example.player.a1610aplayerdemo.fragment.Home.present.SelectPresenter
import com.example.player.a1610aplayerdemo.fragment.Home.present.SelectorPresentCompl
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.support.v4.intentFor
import kotlin.math.log

//// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : BaseFragment(),SelectPresenter.ISelectorView{

    var presenter=SelectorPresentCompl(this)
    val myadapter=SelectorAdapter()
    val myadapter1=SelectorAdapter1()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var  layoutManager=LinearLayoutManager(context)
        layoutManager.orientation=LinearLayoutManager.VERTICAL
        xry.setLayoutManager(layoutManager)
//        xry.layoutManager
//        xry.setOnClickListener(View.OnClickListener {  })
//        xry.adapter=myadapter
        xry.adapter=myadapter1
//        hashMapOf<String,String>()

    }

    override fun initView(): View? {
        presenter.getSelectorData()
        return View.inflate(context, R.layout.fragment_home,null)

    }


    //    val adp=xSe
    override fun onGetDataSuccess(bean: SelectorBean) {
//        List(val )
//        myadapter.addBean(bean.homeCategory)
//        myadapter.addZhuanLan(bean.zlList)
//        myadapter.addTuiJian(bean.courseRecommends)
//        myadapter.addVip(bean.vipRecommend)
//        myadapter.addDaShi(bean.masterLives)
    }

    override fun onGetDataFailed(errorMsg: String) {
            Log.d("Zys",""+errorMsg)
    }

    override fun hideLoading() {

    }

    override fun showLoading() {

    }



    @SuppressLint("ServiceCast", "MissingPermission")
    fun getDeviceKey():String{
        var deviceKey=null
        var te: TelephonyManager = context!!.getSystemService(Context.TELECOM_SERVICE) as TelephonyManager
        deviceKey= te.simSerialNumber as Nothing?
        return deviceKey.toString()
    }



}
