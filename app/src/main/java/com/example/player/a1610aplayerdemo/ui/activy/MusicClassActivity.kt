package com.example.player.a1610aplayerdemo.ui.activy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.bean.MusicClassBean
import com.example.player.a1610aplayerdemo.ui.musicpresenter.MusicClassAdp
import com.example.player.a1610aplayerdemo.ui.musicpresenter.MusicClassInterface
import com.example.player.a1610aplayerdemo.ui.musicpresenter.MusicClassPresenterCompl
import kotlinx.android.synthetic.main.activity_music_class.*

class MusicClassActivity : AppCompatActivity(),MusicClassInterface.MusicClassView{
    var presenter = MusicClassPresenterCompl(this)

    override fun hideLoading() {
    }
    override fun showLoading() {
    }
    override fun onGetDataFailed(errorMsg: String) {

    }

    override fun onGetDataSuccess(bean: List<MusicClassBean>) {

        adp.updateData(bean)
        music_gv.adapter = adp

    }

    var adp = MusicClassAdp()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_class)
        val intent = intent
        val id = intent.getStringExtra("musicclass_num1")

        presenter.getMusicClassData(id)

    }
}
