package com.example.player.a1610aplayerdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.player.a1610aplayerdemo.adapter.guides.MyGuidesAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var guides:ArrayList<View>? = null
    private var myGuidesAdapter:MyGuidesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initdata()
        initadpter()
    }

    private fun initadpter(){
        myGuidesAdapter = MyGuidesAdapter(this,guides);
        main_guide_vp.adapter = myGuidesAdapter
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
