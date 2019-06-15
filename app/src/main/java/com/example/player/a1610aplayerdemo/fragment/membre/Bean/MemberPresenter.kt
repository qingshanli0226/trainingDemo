package com.example.player.a1610aplayerdemo.fragment.membre.Bean

class MemberPresenter {
    internal interface IMenberPresenter {
        fun getData()
        fun getDeView()
    }

    internal interface IMemberView {
        fun getSuccessData(menmberBean: MenmberBean)
        fun getFailData(e: String)
    }
}