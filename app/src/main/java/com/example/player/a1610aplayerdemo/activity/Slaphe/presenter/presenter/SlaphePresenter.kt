package com.example.player.a1610aplayerdemo.activity.Slaphe.presenter.presenter

import okhttp3.ResponseBody

class SlaphePresenter {
    internal interface ISlaphePresenter {
        fun getData()
        fun DeView()
    }

    internal interface ISlapheView {
        fun getSuccessData(responseBody: String)
        fun getFailData(code: Int, e: String)
    }
}