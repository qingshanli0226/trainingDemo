package com.example.player.a1610aplayerdemo


import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.player.a1610aplayerdemo.ui.Fragment.Fragment_Mine
import com.example.player.a1610aplayerdemo.ui.Fragment.Fragment_SelectCourse
import com.example.player.a1610aplayerdemo.ui.Fragment.Fragment_StudyCentre
import com.example.player.a1610aplayerdemo.ui.Fragment.Fragment_VIP



class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        if (v != null) {
            helpImagechoose(v)
        }
    }

    private var mainFragmeLayout: FrameLayout? = null
    private var mainRadioGroup: RadioGroup? = null
    private var mainRB1: RadioButton? = null
    private var mainRB2: RadioButton? = null
    private var mainRB3: RadioButton? = null
    private var mainRB4: RadioButton? = null
    private var recommendPageHelpImage1: ImageView? = null
    private var recommendPageHelpImage2: ImageView? = null
    private var recommendPageHelpImage3: ImageView? = null
    private var recommendPageHelpImage4: ImageView? = null
    private var recommendPageHelpImage5: ImageView? = null
    private var preferences: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null
    private var fSelectCourse: Fragment_SelectCourse? = null
    private var fStudeyCentre: Fragment_StudyCentre? = null
    private var fVIP: Fragment_VIP? = null
    private var fMine: Fragment_Mine? = null
    private var transaction: FragmentTransaction? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        mainRB1?.setChecked(true)
        selectFragment(R.id.mainRB1)
        mainRadioGroup?.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            selectFragment(
                checkedId
            )
        })
    }


    private fun initView() {

        mainFragmeLayout = findViewById<View>(R.id.mainFragmeLayout) as FrameLayout
        mainRadioGroup = findViewById<View>(R.id.mainRadioGroup) as RadioGroup
        recommendPageHelpImage1 = findViewById<View>(R.id.recommendPageHelpImage1) as ImageView
        recommendPageHelpImage1!!.setOnClickListener(this)
        recommendPageHelpImage2 = findViewById<View>(R.id.recommendPageHelpImage2) as ImageView
        recommendPageHelpImage2!!.setOnClickListener(this)
        recommendPageHelpImage3 = findViewById<View>(R.id.recommendPageHelpImage3) as ImageView
        recommendPageHelpImage3!!.setOnClickListener(this)
        recommendPageHelpImage4 = findViewById<View>(R.id.recommendPageHelpImage4) as ImageView
        recommendPageHelpImage4!!.setOnClickListener(this)
        recommendPageHelpImage5 = findViewById<View>(R.id.recommendPageHelpImage5) as ImageView
        recommendPageHelpImage5!!.setOnClickListener(this)
        mainRB1 = findViewById<View>(R.id.mainRB1) as RadioButton
        mainRB2 = findViewById<View>(R.id.mainRB2) as RadioButton
        mainRB3 = findViewById<View>(R.id.mainRB3) as RadioButton
        mainRB4 = findViewById<View>(R.id.mainRB4) as RadioButton
        changeImageSize()


    }
    private fun selectFragment(id: Int) {
        val manager = supportFragmentManager
        transaction = manager.beginTransaction()
        when (id) {
            R.id.mainRB1 -> if (fSelectCourse == null) {
                fSelectCourse = Fragment_SelectCourse(this)
                transaction!!.replace(R.id.mainFragmeLayout, fSelectCourse!!)
            } else {
                transaction!!.replace(R.id.mainFragmeLayout, fSelectCourse!!)
            }
            R.id.mainRB2 -> if (fStudeyCentre == null) {
                fStudeyCentre = Fragment_StudyCentre(this)
                transaction!!.replace(R.id.mainFragmeLayout, fStudeyCentre!!)
            } else {
                transaction!!.replace(R.id.mainFragmeLayout, fStudeyCentre!!)
            }
            R.id.mainRB3 -> if (fVIP == null) {
                fVIP = Fragment_VIP(this)
                transaction!!.replace(R.id.mainFragmeLayout, fVIP!!)
            } else {
                transaction!!.replace(R.id.mainFragmeLayout, fVIP!!)
            }
            R.id.mainRB4 -> if (fMine == null) {
                fMine = Fragment_Mine(this)
                transaction!!.replace(R.id.mainFragmeLayout, fMine!!)
            } else {
                transaction!!.replace(R.id.mainFragmeLayout, fMine!!)
            }
        }
        transaction!!.commit()
    }
    private fun changeImageSize() {
        //定义底部标签图片大小
        val drawableFirst = resources.getDrawable(R.drawable.rb_selector1)
        drawableFirst.setBounds(0, 15, 90, 75)//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        mainRB1?.setCompoundDrawables(null, drawableFirst, null, null)//只放上面

        val drawableSearch = resources.getDrawable(R.drawable.rb_selector2)
        drawableSearch.setBounds(0, 15, 90, 75)//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        mainRB2?.setCompoundDrawables(null, drawableSearch, null, null)//只放上面

        val drawableMe = resources.getDrawable(R.drawable.rb_selector3)
        drawableMe.setBounds(0, 15, 90, 75)//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        mainRB3?.setCompoundDrawables(null, drawableMe, null, null)//只放上面

        val drawableMe4 = resources.getDrawable(R.drawable.rb_selector4)
        drawableMe4.setBounds(0, 15, 90, 75)//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        mainRB4?.setCompoundDrawables(null, drawableMe4, null, null)//只放上面
    }

    private fun helpImagechoose(v: View) {
        when (v.id) {
            R.id.recommendPageHelpImage1 -> recommendPageHelpImage1?.setVisibility(View.INVISIBLE)
            R.id.recommendPageHelpImage2 -> recommendPageHelpImage2?.setVisibility(View.INVISIBLE)
            R.id.recommendPageHelpImage3 -> recommendPageHelpImage3?.setVisibility(View.INVISIBLE)
            R.id.recommendPageHelpImage4 -> recommendPageHelpImage4?.setVisibility(View.INVISIBLE)
            R.id.recommendPageHelpImage5 -> recommendPageHelpImage5?.setVisibility(View.INVISIBLE)
        }
    }

}


