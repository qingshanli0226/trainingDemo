package com.example.player.a1610aplayerdemo.ui.tuijianpresenter

import com.example.player.a1610aplayerdemo.bean.TuiJianDateBean


import com.example.player.a1610aplayerdemo.view.BaseView

class TuiJianInterface {
    interface ITuiJianPresenter {
        fun getTuiJianData(s:String)

        fun detachView()
    }

    interface TuiJianView : BaseView {

        fun onGetDataSuccess(bean: TuiJianDateBean)
        fun onGetDataFailed(errorMsg: String)


    }
}