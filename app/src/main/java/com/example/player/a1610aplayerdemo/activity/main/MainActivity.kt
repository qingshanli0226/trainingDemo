package com.example.player.a1610aplayerdemo.activity.main


import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.activity.main.adapter.MainVpAdapter
import com.example.player.a1610aplayerdemo.net.Contant
import com.example.player.a1610aplayerdemo.net.ResEntity
import com.example.player.a1610aplayerdemo.net.RetrofitCreator
import com.example.player.a1610aplayerdemo.token.SpUtils
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
    lateinit var m_bnv: BottomNavigationView

    // 申明自定义 adapter 类
  lateinit var mainVpAdapter:MainVpAdapter

    // BottomNavigationView 的选择事件，可控制fragment的选择
   private val  monna = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId){
            R.id.i_rb_select ->{
                m_vp.setCurrentItem(0)
                return@OnNavigationItemSelectedListener true
            }
            R.id.i_rb_study ->{
                m_vp.setCurrentItem(1)
                return@OnNavigationItemSelectedListener true
            }
            R.id.i_rb_member ->{
                m_vp.setCurrentItem(2)
                return@OnNavigationItemSelectedListener true
            }
            R.id.i_rb_aboutMe ->{
                m_vp.setCurrentItem(3)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
          init();

        m_bnv.setOnNavigationItemSelectedListener(monna)
        initListener()
        initUser();
    }
//  进入主页面， 获取用户信息， 可以拿到token
    private fun initUser() {
        var paramMap:Map<String,String> = mapOf(Pair("DeviceKey", Contant.DEVICEKEY),
            Pair("Android-VersionCode","43"),
            Pair("Android-channel","guoyun"),Pair("Tingyun_Process","true")
        )

    var paramMap2:Map<String,String> = mapOf(
        Pair("DeviceKey", Contant.DEVICEKEY),
        Pair("device",Build.DEVICE),
        Pair("sdkVersion","${Build.VERSION.SDK_INT}"),
        Pair("brand",Build.BOARD), Pair("product",Build.PRODUCT)
    )


    RetrofitCreator.getInstance().retrofitApiService.getUserData(paramMap,paramMap2)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :Observer<ResEntity<UserBean.DataBean>>{
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: ResEntity<UserBean.DataBean>) {
                    val accessToken = t.data.accessToken
                    // 保存token
                    println(t.data.accessToken);
                    SpUtils.getSpUtils().saveToken(accessToken)

                    println(accessToken);
                }

                override fun onError(e: Throwable) {
                    println(e.toString())
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
            // = m_rg.check(m_rg.getChildAt(p0).id)
            override fun onPageSelected(p0: Int) {
                if (p0 == 0){
                    m_bnv.selectedItemId = R.id.i_rb_select
                }else if( p0 == 1){
                    m_bnv.selectedItemId = R.id.i_rb_study
                }else if( p0 == 2){
                    m_bnv.selectedItemId = R.id.i_rb_member
                }else if( p0 == 3){
                    m_bnv.selectedItemId = R.id.i_rb_aboutMe
                }
            }
        })
    }

    private fun initView() {
        m_vp = findViewById(R.id.m_vp)
        m_rg = findViewById(R.id.m_rg)
        rb_select_class = findViewById(R.id.rb_select_class)
        rb_study = findViewById(R.id.rb_study)
        rb_menmber = findViewById(R.id.rb_member)
        rb_aboutMe = findViewById(R.id.rb_aboutMy)
        m_bnv = findViewById(R.id.m_bnv)
    }

    private fun init() {
        // 实例化自定义的  Fragmnetpageradapter
        mainVpAdapter = MainVpAdapter(supportFragmentManager);
        //  给viewpager 设置适配器
        m_vp.adapter = mainVpAdapter;

    }
}





