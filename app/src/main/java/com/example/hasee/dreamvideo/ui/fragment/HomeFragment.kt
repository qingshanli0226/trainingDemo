package com.example.hasee.dreamvideo.ui.fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.hasee.dreamvideo.Presenter.ContextPresentor
import com.example.hasee.dreamvideo.R
import com.example.hasee.dreamvideo.adapter.HomeAdapter
import com.example.hasee.dreamvideo.base.BaseFragment
import com.example.hasee.dreamvideo.bean.HomeBean
import com.scwang.smartrefresh.header.BezierCircleHeader
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by Lmz on 2019/06/09
 */
class HomeFragment: BaseFragment(),ContextPresentor.IHomeView {
    val presenter by lazy {   HomePresenter(this) }
    val adapter by lazy { HomeAdapter() }
    var page =1
    var isLoad =false
    override fun initview(): View? {
         return View.inflate(context, R.layout.fragment_home,null)
    }

    override fun initlistener() {
        //  初始化  recyclerview
        home_recyclerview.layoutManager = LinearLayoutManager(context)
        //适配
        home_recyclerview.adapter = adapter
        LoadUpdate()

        //初始化 刷新控件
        // 刷新样式
        home_smart.setRefreshHeader(BezierCircleHeader(context))
        //加载样式
        home_smart.setRefreshFooter(ClassicsFooter(context))
        //设置 刷新事件
        home_smart.setOnRefreshListener {
            page = 1
            presenter.getHomeinfo(""+20,""+page);
            isLoad = false
        }
        home_smart.setOnLoadmoreListener {
            page++
            presenter.getHomeinfo(""+20,""+page)
            isLoad = true
        }

    }

    private fun LoadUpdate(){
        presenter.getHomeinfo(""+20,""+page)
    }


    override fun getHomeInfoSuccess(bean: HomeBean?) {
        StopRefreshAndLoadmore()
        println("成功"+bean.toString())
        var list=bean?.data?.list
        if (isLoad){
            adapter.LoadMore(list!!)
        }else{
            adapter.Refresh(list!!)
        }

    }

    override fun getHomeInfoFailure(mess: String?) {
        StopRefreshAndLoadmore()
        myToast("数据获取失败了")
    }

    /**
     * 定义  刷新加载完成之后的 结束动画类
     */
    fun StopRefreshAndLoadmore(){
        home_smart.finishLoadmore()
        home_smart.finishRefresh()
    }
}