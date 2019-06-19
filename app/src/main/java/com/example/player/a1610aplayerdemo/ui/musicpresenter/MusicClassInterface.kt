package com.example.player.a1610aplayerdemo.ui.musicpresenter

import com.example.player.a1610aplayerdemo.bean.MusicClassBean
import com.example.player.a1610aplayerdemo.bean.TuiJianDateBean


import com.example.player.a1610aplayerdemo.view.BaseView

class MusicClassInterface {
    interface IMusicClassPresenter {
        fun getMusicClassData(s:String)

        fun detachView()
    }

    interface MusicClassView : BaseView {

        fun onGetDataSuccess(bean: List<MusicClassBean>)
        fun onGetDataFailed(errorMsg: String)


    }
}