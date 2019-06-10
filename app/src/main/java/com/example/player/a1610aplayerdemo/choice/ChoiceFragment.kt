package com.example.player.a1610aplayerdemo.choice

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.player.a1610aplayerdemo.R
import kotlinx.android.synthetic.main.layout_titlebar.*

class ChoiceFragment :Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_choice,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        titlebar_left.setImageResource(R.drawable.ic_action_main_my)
    }
}