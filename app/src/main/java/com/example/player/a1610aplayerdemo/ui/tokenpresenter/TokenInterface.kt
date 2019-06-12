package com.example.player.a1610aplayerdemo.ui.tokenpresenter

import com.example.player.a1610aplayerdemo.bean.TokenDateBean
import com.example.player.a1610aplayerdemo.bean.VipDateBean

import com.example.player.a1610aplayerdemo.view.BaseView
import okhttp3.ResponseBody

class TokenInterface {
    interface ItokenPresenter {
        fun getTokenData()

        fun detachView()
    }

    interface TokenView : BaseView {

        fun onGetDataSuccess(bean: TokenDateBean)
        fun onGetDataFailed(errorMsg: String)


    }
}