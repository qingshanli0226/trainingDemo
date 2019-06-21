package com.example.player.a1610aplayerdemo.ui.mastercourse.masterpresenter

import com.example.player.a1610aplayerdemo.bean.MasterDateBean

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