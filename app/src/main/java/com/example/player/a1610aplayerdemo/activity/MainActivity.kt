package com.example.player.a1610aplayerdemo.activity

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.activity.present.NetBean
import com.example.player.a1610aplayerdemo.utils.ToolbarManger
import com.example.player.a1610aplayerdemo.base.BaseActivity
import com.example.player.a1610aplayerdemo.net.RetrofitCreate
import com.example.player.a1610aplayerdemo.utils.FragmentUtils
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find
import java.util.*
import kotlin.collections.HashMap

class MainActivity : BaseActivity(), ToolbarManger {
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun getLayoutId(): Int {
        return R.layout.activity_main

    }


    override fun initdata() {
        super.initdata()
        initMainToolbar()

    }
    override fun initlistener() {

        bottomBar.setOnTabSelectListener { tabId ->

            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_frameLayout, FragmentUtils.fragmentUtils.getFragment(tabId),tabId.toString())
            transaction.commit()
        }

    }

    fun getDevice(){
//        hasm
//        RetrofitCreate.getNetApiService().FirstInAndGetToken()
//            .observeOn(AndroidSchedulers.mainThread())
////            .subscribeOn(Scheduler.io)
//            .subscribe( object  : Observer<NetBean>{
//                override fun onComplete() {
//                }
//
//                override fun onSubscribe(d: Disposable?) {
//                }
//
//                override fun onNext(value: NetBean?) {
//                }
//
//                override fun onError(e: Throwable?) {
//                }
//
//            })

    }


}
