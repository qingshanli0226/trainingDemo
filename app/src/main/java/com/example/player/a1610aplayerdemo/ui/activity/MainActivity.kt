package com.example.player.a1610aplayerdemo.ui.activity

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.widget.FrameLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseActivity
import com.example.player.a1610aplayerdemo.ui.fragment.BuyFragment
import com.example.player.a1610aplayerdemo.ui.fragment.FindFragment
import com.example.player.a1610aplayerdemo.ui.fragment.MemberFragment
import com.example.player.a1610aplayerdemo.ui.fragment.PersonageFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var findradiobutton:RadioButton
    private lateinit var memberradiobutton:RadioButton
    private lateinit var buyradiobutton:RadioButton
    private lateinit var personageradiobutton:RadioButton
    private lateinit var radioGroup: RadioGroup
    private lateinit var framelayout:FrameLayout
    private lateinit var transaction:FragmentTransaction
    private  var  findFragment: FindFragment? = null
    private  var memberFragment: MemberFragment? = null
    private  var buyFragment: BuyFragment? = null
    private  var personageFragment: PersonageFragment? = null


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }


    override fun initData() {
        findradiobutton = findViewById(R.id.rb1)
        memberradiobutton = findViewById(R.id.rb2)
        buyradiobutton = findViewById(R.id.rb3)
        personageradiobutton = findViewById(R.id.rb4)
        radioGroup = findViewById(R.id.rg)
        framelayout = findViewById(R.id.fl)
    }


    override fun initListener() {
        radioGroup.setOnCheckedChangeListener(object :RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                val supportFragmentManager:FragmentManager = supportFragmentManager
                transaction = supportFragmentManager.beginTransaction()
                hideFragment()
                when (checkedId) {
                    R.id.rb1 -> {

                        findFragment = FindFragment()
                        transaction.add(R.id.fl, findFragment!!)
                        transaction.show(findFragment!!)
                    }
                    R.id.rb2 -> {
                        memberFragment = MemberFragment()
                        transaction.add(R.id.fl, memberFragment!!)
                        transaction.show(memberFragment!!)
                    }
                    R.id.rb3 -> {
                        buyFragment = BuyFragment()
                        transaction.add(R.id.fl, buyFragment!!)
                        transaction.show(buyFragment!!)
                    }
                    R.id.rb4 -> {
                        personageFragment = PersonageFragment()
                        transaction.add(R.id.fl, personageFragment!!)
                        transaction.show(personageFragment!!)
                    }
                }
                transaction.commit()
            }

        })
        rg.check(R.id.rb1)
    }


    private fun hideFragment() {
        if (findFragment!=null){
            transaction.hide(findFragment!!)
        }
        if (memberFragment!=null){
            transaction.hide(memberFragment!!)
        }
        if (buyFragment!=null){
            transaction.hide(buyFragment!!)
        }
        if (personageFragment!=null){
            transaction.hide(personageFragment!!)
        }

    }
}
