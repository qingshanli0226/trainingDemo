package com.example.player.a1610aplayerdemo.ui.vippresenter

import com.example.player.a1610aplayerdemo.bean.VipDateBean

import com.example.player.a1610aplayerdemo.view.BaseView

class VipInterface {
    interface IvipPresenter {
        fun getVipData()

        fun detachView()
    }

    interface VipView : BaseView {

        fun onGetDataSuccess(bean: VipDateBean)
        fun onGetDataFailed(errorMsg: String)


    }
}