package com.example.player.a1610aplayerdemo.ui.xuankepresenter

import com.example.player.a1610aplayerdemo.bean.XuanKeDateBean
import com.example.player.a1610aplayerdemo.view.BaseView

class XuanKeInterface {
    interface IxuankePresenter {
        fun getXkData()
    }

    interface XuanKeView : BaseView {
        fun onGetDataSuccess(bean: XuanKeDateBean)

        fun onGetDataFailed(errorMsg: String)


    }
}