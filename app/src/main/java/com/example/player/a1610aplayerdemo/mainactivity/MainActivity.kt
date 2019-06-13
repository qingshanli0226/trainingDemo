package com.example.player.a1610aplayerdemo.mainactivity

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.mainactivity.adapter.MainVpAdapter
import com.example.player.a1610aplayerdemo.net.Contance
import com.example.player.a1610aplayerdemo.net.RetrofitCreator
import com.example.player.a1610aplayerdemo.token.UserBean
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
 // 声明控件
    lateinit var m_rg : RadioGroup
    lateinit var rb_select_class: RadioButton
    lateinit var rb_study: RadioButton
    lateinit var rb_menmber : RadioButton
    lateinit var rb_aboutMe : RadioButton
    lateinit var m_vp : ViewPager
    // 申明自定义 adapter 类
  lateinit var mainVpAdapter:MainVpAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
          init();
        initListener()
        initUser();
    }
//  进入主页面， 获取用户信息， 可以拿到token
    private fun initUser() {
        var paramMap:Map<String,String> = mapOf(Pair("DeviceKey",Contance.DEVICEKEY),
            Pair("Android-VersionCode","43"),
            Pair("Android-channel","guoyun"),Pair("Tingyun_Process","true")
        )
       RetrofitCreator.getInstance().retrofitApiService.getUserData(paramMap)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :Observer<Result<UserBean>>{
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: Result<UserBean>) {

                }

                override fun onError(e: Throwable) {

                }

            })
    }

    private fun initListener() {
        //  radiogroup 中 radiobutton 的点击与 viewpager 中的页面联动
        m_rg.setOnCheckedChangeListener{ radioGroup: RadioGroup?, i: Int ->
            when(i){
                rb_select_class.id  -> m_vp.setCurrentItem(0)
                rb_study.id  -> m_vp.setCurrentItem(1)
                rb_menmber.id  -> m_vp.setCurrentItem(2)
                rb_aboutMe.id  -> m_vp.setCurrentItem(3)
            }
        }
//    viewpager 的滑动事件
        m_vp.setOnPageChangeListener(object:ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int){

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            //  选中对应的radiobutton
            override fun onPageSelected(p0: Int)  = m_rg.check(m_rg.getChildAt(p0).id)
        })
    }

    private fun initView() {
        m_vp = findViewById(R.id.m_vp)
        m_rg = findViewById(R.id.m_rg)
        rb_select_class = findViewById(R.id.rb_select_class)
        rb_study = findViewById(R.id.rb_study)
        rb_menmber = findViewById(R.id.rb_member)
        rb_aboutMe = findViewById(R.id.rb_aboutMy)
    }

    private fun init() {
        // 实例化自定义的  Fragmnetpageradapter
        mainVpAdapter = MainVpAdapter(supportFragmentManager);
        //  给viewpager 设置适配器
        m_vp.adapter = mainVpAdapter;

    }
}

private fun Any.subscribe(observer: Observer<Result<UserBean>>) {

}

