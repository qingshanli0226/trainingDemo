package com.example.player.a1610aplayerdemo.ui.masterpresenter

import com.example.player.a1610aplayerdemo.bean.MasterDateBean
import com.example.player.a1610aplayerdemo.bean.TuiJianDateBean


import com.example.player.a1610aplayerdemo.view.BaseView

class MasterInterface {
    interface IMasterPresenter {
        fun getMasterData(s:String)

        fun detachView()
    }

    interface MasterView {

        fun onGetDataSuccess(bean: MasterDateBean)
        fun onGetDataFailed(errorMsg: String)


    }
}