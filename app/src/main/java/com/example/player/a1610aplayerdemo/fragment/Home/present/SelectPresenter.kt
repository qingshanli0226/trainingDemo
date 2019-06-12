package com.example.player.a1610aplayerdemo.fragment.Home.present

import com.example.player.a1610aplayerdemo.fragment.Home.bean.SelectorBean
import com.example.player.a1610aplayerdemo.view.BaseView

class SelectPresenter {
    interface ISelectPresener{
        fun getSelectorData()
        fun DetachView()
    }
    interface ISelectorView : BaseView {

        fun onGetDataSuccess(bean: SelectorBean)
        fun onGetDataFailed(errorMsg: String)

    }
}