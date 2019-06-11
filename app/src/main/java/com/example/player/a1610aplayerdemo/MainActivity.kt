package com.example.player.a1610aplayerdemo

import android.content.res.Resources
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import com.example.player.a1610aplayerdemo.bean.Bean
import com.example.player.a1610aplayerdemo.bean.UserBean
import com.example.player.a1610aplayerdemo.main.MainViewPagerAdapter
import com.example.player.a1610aplayerdemo.net.RetrofitCreator
import com.example.player.a1610aplayerdemo.utils.TokenSp
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import io.reactivex.internal.operators.observable.ObservableOnErrorNext
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_titlebar.*
import kotlin.math.log
import io.reactivex.Observer as Observer

class MainActivity : AppCompatActivity() {
    var linear_main_choice_flag: Boolean = true
    var linear_main_study_flag: Boolean = false
    var linear_main_vip_flag: Boolean = false
    var linear_main_my_flag: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        getUserData()

        main_vp.adapter = MainViewPagerAdapter(supportFragmentManager)

        fun setRadioButtonBg(flag: Boolean, img: ImageView, rb: RadioButton, linear: LinearLayout) {
            if (flag) {
                //白色
                rb.setTextColor(Color.rgb(89, 172, 255))
                img.setColorFilter(Color.rgb(89, 172, 255))
                //蓝色89172255
            } else {
                rb.setTextColor(Color.rgb(192, 192, 192))
                img.setColorFilter(Color.rgb(192, 192, 192))
            }
        }
        fun diao(){
            setRadioButtonBg(linear_main_choice_flag, iv_main_choice, rb_main_choice, linear_main_choice)
            setRadioButtonBg(linear_main_study_flag, iv_main_study, rb_main_study, linear_main_study)
            setRadioButtonBg(linear_main_vip_flag, iv_main_VIP, rb_main_VIP, linear_main_vip)
            setRadioButtonBg(linear_main_my_flag, iv_main_my, rb_main_my, linear_main_my)

        }
        linear_main_choice.setOnClickListener {
            if (!linear_main_choice_flag) {
                linear_main_choice_flag = true
                linear_main_study_flag = false
                linear_main_vip_flag = false
                linear_main_my_flag = false
            }
            diao()
            main_vp.setCurrentItem(0)
        }
        linear_main_study.setOnClickListener {
            if (!linear_main_study_flag) {
                linear_main_choice_flag = false
                linear_main_study_flag = true
                linear_main_vip_flag = false
                linear_main_my_flag = false

            }
            diao()
            main_vp.setCurrentItem(1)

        }
        linear_main_vip.setOnClickListener {
            if (!linear_main_vip_flag) {
                linear_main_choice_flag = false
                linear_main_study_flag = false
                linear_main_vip_flag = true
                linear_main_my_flag = false
            }
            diao()
            main_vp.setCurrentItem(2)

        }
        linear_main_my.setOnClickListener {
            if (!linear_main_my_flag) {
                linear_main_choice_flag = false
                linear_main_study_flag = false
                linear_main_vip_flag = false
                linear_main_my_flag = true
            }
            diao()
            main_vp.setCurrentItem(3)
        }

    }

    private fun getUserData() {
        RetrofitCreator.getInstance().iServiceApi
            .getUser("/restapi/account/createNew")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :Observer<Bean<UserBean>>{
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                }

                override fun onNext(t: Bean<UserBean>) {
                    var data = t.data
                    var accessToken = data.accessToken
                    TokenSp.getInstance().saveToken(accessToken)
                }
            })
    }
}
