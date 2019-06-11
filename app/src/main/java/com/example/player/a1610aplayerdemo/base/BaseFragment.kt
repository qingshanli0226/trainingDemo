package com.example.player.a1610aplayerdemo.base
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.player.a1610aplayerdemo.R
import org.jetbrains.anko.runOnUiThread
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast

/**
 * Created by Lmz on 2019/06/10
 */
public abstract class BaseFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }
    /**
     *  fragment 初始化
     */
    protected fun init() {

    }

    /**
     * 获取 布局
     */
    abstract fun initview(): View?

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return initview()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initlistener()
        initdata()
    }

    /**
     * 进行 adapter 和 listener 操作
     * 非必须
     */
    protected fun initlistener(){}

    /**
     * 初始化数据
     * 非必须
     */
    protected fun  initdata(){

    }

    /**
     * 线程安全的吐司
     */
    fun myToast(msg:String){
        // 加上2个感叹号 代表不可以为null
        context!!.runOnUiThread {
            toast(msg)
        }
    }


}