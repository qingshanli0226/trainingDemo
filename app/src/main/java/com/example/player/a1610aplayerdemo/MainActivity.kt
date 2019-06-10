package com.example.player.a1610aplayerdemo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.ImageView
import com.example.player.a1610aplayerdemo.activity.HomeActivity
import com.example.player.a1610aplayerdemo.adapter.guides.MyGuidesAdapter
import com.example.player.a1610aplayerdemo.url.Website
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var guides:ArrayList<View>? = null
    private var myGuidesAdapter:MyGuidesAdapter? = null
    private var sharedPreferences:SharedPreferences? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreferences = getSharedPreferences("2019_06_10", Context.MODE_PRIVATE);
        var ischeck: Boolean? = sharedPreferences?.getBoolean("ischeck",true);
        if(ischeck!!){
            initdata()
            initadpter()
        }else{
            main_guide_vp.visibility = View.GONE
            main_greet_iv.visibility = View.VISIBLE
            Picasso.with(this@MainActivity).load(Website.GREET).into(main_greet_iv)
            main_greet_tv.visibility = View.VISIBLE
            main_greet_tv.setOnClickListener(object:View.OnClickListener {
                override fun onClick(p0: View?) {
                    val intent:Intent = Intent(this@MainActivity,HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            })
        }
    }

    private fun initadpter(){
        myGuidesAdapter = MyGuidesAdapter(this,guides);
        main_guide_vp.adapter = myGuidesAdapter

        val guide_vp:ViewPager = findViewById(R.id.main_guide_vp)
        guide_vp.setOnPageChangeListener(object:ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(p0: Int) {
                if(p0 == guides?.size!!-1){
                    main_guide_btn.visibility = View.VISIBLE
                    main_guide_btn.setOnClickListener {
                        var editor:SharedPreferences.Editor = sharedPreferences!!.edit()
                        editor.putBoolean("ischeck",false)
                        editor.commit();
                        val intent:Intent = Intent(this@MainActivity,HomeActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }else{
                    main_guide_btn.visibility = View.GONE
                }
            }
        })
    }

    private fun initdata(){
        guides = arrayListOf();
        var image = ImageView(this);
        image.setImageResource(R.drawable.guide_1);
        image.scaleType = ImageView.ScaleType.CENTER_CROP
        guides?.add(image);
        var image2 = ImageView(this);
        image2.setImageResource(R.drawable.guide_2);
        image2.scaleType = ImageView.ScaleType.CENTER_CROP
        guides?.add(image2);
        var image3 = ImageView(this);
        image3.setImageResource(R.drawable.guide_3);
        image3.scaleType = ImageView.ScaleType.CENTER_CROP
        guides?.add(image3);
        var image4 = ImageView(this);
        image4.setImageResource(R.drawable.guide_4);
        image4.scaleType = ImageView.ScaleType.CENTER_CROP
        guides?.add(image4);
    }
}
