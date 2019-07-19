package com.example.player.a1610aplayerdemo.ui.fragment


import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Toast
import com.example.player.a1610aplayerdemo.MyApp

import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseFragment
import com.example.player.a1610aplayerdemo.bean.LoginOutBean
import com.example.player.a1610aplayerdemo.bean.UpdateVersionBean
import com.example.player.a1610aplayerdemo.logregistui.LoginActivity
import com.example.player.a1610aplayerdemo.net.MVPObserver
import com.example.player.a1610aplayerdemo.net.MyNetFunction
import com.example.player.a1610aplayerdemo.net.ResEntity
import com.example.player.a1610aplayerdemo.net.RetrofitCreator
import com.example.player.a1610aplayerdemo.ui.activy.MainActivity
import com.example.player.a1610aplayerdemo.ui.setting.SettingActivity
import com.example.player.a1610aplayerdemo.util.DeviceKye
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_my.*
import org.jetbrains.anko.support.v4.startActivity
import java.util.HashMap


/**
 * A simple [Fragment] subclass.
 *
 */
class MyFragment : BaseFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniView();
        my_setting.setOnClickListener {
            startActivity(Intent(context,SettingActivity::class.java))
        }
        checkversion.setOnClickListener {
            banben();
        }
    }
    private fun banben() {

        val headmap = HashMap<String, String>()

        headmap["Android-VersionCode"] = "43"
        headmap["Accept-Encoding"] = "gzip"
        headmap["User-Agent"] = "Dalvik/2.1.0 (Linux; U; Android 5.1.1; sm-j700f Build/LMY47I)"
        headmap["Content-Type"] = "application/x-www-form-urlencoded"
        headmap["Android-channel"] = "guoyun"
        headmap["Host"] = "api.immedc.com"
        headmap["Tingyun_Process"] = "true"
        headmap["X-Tingyun-Id"] = "oNIzcYZpC5c;c=2;r=410222270"
        headmap["deviceKey"] = DeviceKye.getDeviceKye()
        val fmap = HashMap<String, String>()


        RetrofitCreator.getApiService().getVersionUpdate1(headmap, fmap)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MVPObserver<UpdateVersionBean>() {
                override fun onNext(updateVersionBean: UpdateVersionBean) {
                    super.onNext(updateVersionBean)
                    val login = updateVersionBean.isForceUpdate
                    if (login == false) {


                        Toast.makeText(context, "版本不需要更新", Toast.LENGTH_SHORT).show()

//                     var  build =   AlertDialog.Builder(MyApp.instance);
//
//                        build.setTitle("已是最新版本")
//
//
//                       var b = build.create()
//
//                        b.show()

                    } else {

                        Toast.makeText(context, "版本需要更新", Toast.LENGTH_SHORT).show()



                    }
                }
            })


    }

    private fun iniView() {
        tolog.setOnClickListener {

            startActivity(Intent(context, LoginActivity::class.java))

        }

    }

    override fun initView(): View? {
        return View.inflate(context,R.layout.fragment_my,null);
    }


}
