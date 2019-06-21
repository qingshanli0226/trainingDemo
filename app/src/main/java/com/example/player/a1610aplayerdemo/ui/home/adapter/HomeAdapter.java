package com.example.player.a1610aplayerdemo.ui.home.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.ui.home.adapter.banner.BannerView;
import com.example.player.a1610aplayerdemo.ui.home.adapter.category.CategoryAdapter;
import com.example.player.a1610aplayerdemo.ui.home.adapter.category.CategoryView;
import com.example.player.a1610aplayerdemo.ui.home.adapter.courserecommends.CourserecommendsAdapter;
import com.example.player.a1610aplayerdemo.ui.home.adapter.courserecommends.CourserecommendsView;
import com.example.player.a1610aplayerdemo.ui.home.adapter.masterlives.MasterlivesAdapter;
import com.example.player.a1610aplayerdemo.ui.home.adapter.masterlives.MasterlivesView;
import com.example.player.a1610aplayerdemo.ui.home.adapter.viprecommend.VipRecommendAdapter;
import com.example.player.a1610aplayerdemo.ui.home.adapter.viprecommend.ViprecommendView;
import com.example.player.a1610aplayerdemo.ui.home.adapter.zllist.ZlListAdapter;
import com.example.player.a1610aplayerdemo.ui.home.adapter.zllist.ZlListView;
import com.example.player.a1610aplayerdemo.ui.home.bean.HomeBean;

import java.util.List;

public class HomeAdapter extends BaseRecyclerViewAdapter<Object, View> {
    private static final int BANNNER = 0;
    private static final int CATEGORY = 1;
    private static final int VIPRECOMMEND = 2;
    private static final int ZLLIST = 3;
    private static final int COURSERECOMMENDS = 4;
    private static final int MASTERLIVES = 5;

    @Override
    protected View getItemView(Context context,int viewtype) {
        switch (viewtype){
            case BANNNER:
                return new BannerView(context);
            case CATEGORY:
               return new CategoryView(context);
            case VIPRECOMMEND:
                return new ViprecommendView(context);
            case ZLLIST:
                return new ZlListView(context);
            case COURSERECOMMENDS:
                return new CourserecommendsView(context);
            case MASTERLIVES:
                return new MasterlivesView(context);
                default:
                    break;
        }
        return new MasterlivesView(context);
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0:
                return BANNNER;
            case 1:
                return CATEGORY;
            case 2:
                return VIPRECOMMEND;
            case 3:
                return ZLLIST;
            case 4:
                return COURSERECOMMENDS;
            case 5:
                return MASTERLIVES;
                default:
                    return MASTERLIVES;
        }
    }

    @Override
    protected void refreshItemUi(final View itemView, Object o, final int i) {
        switch (i){
            case 0:
                List<HomeBean.DataBean.HomeBannerBean> bannerlist = (List<HomeBean.DataBean.HomeBannerBean>) o;
                BannerView bannerView = (BannerView) itemView;
                bannerView.setdata(bannerlist);
                break;
            case 1:
                List<HomeBean.DataBean.HomeCategoryBean> categorylist = (List<HomeBean.DataBean.HomeCategoryBean>) o;
                CategoryAdapter categoryadapter = new CategoryAdapter();
                categoryadapter.updateData(categorylist);
                RecyclerView categoryrv = itemView.findViewById(R.id.rv_category);
                GridLayoutManager categorymanager = new GridLayoutManager(itemView.getContext(),4);
                categoryrv.setLayoutManager(categorymanager);
                categoryrv.setAdapter(categoryadapter);
                break;
            case 2:
                List<HomeBean.DataBean.VipRecommendBean> viprecommendlist = (List<HomeBean.DataBean.VipRecommendBean>) o;
                VipRecommendAdapter viprecommendadapter = new VipRecommendAdapter();
                viprecommendadapter.updateData(viprecommendlist);
                RecyclerView viprecommendrv = itemView.findViewById(R.id.rv_vip);
                GridLayoutManager viprecommendmanager = new GridLayoutManager(itemView.getContext(),2);
                viprecommendrv.setLayoutManager(viprecommendmanager);
                viprecommendrv.setAdapter(viprecommendadapter);
                break;
            case 3:
                List<HomeBean.DataBean.ZlListBean> zllistlist = (List<HomeBean.DataBean.ZlListBean>) o;
                ZlListAdapter zllistadapter = new ZlListAdapter();
                zllistadapter.updateData(zllistlist);
                RecyclerView zllistrv = itemView.findViewById(R.id.rv_zllist);
                GridLayoutManager zllistmanager = new GridLayoutManager(itemView.getContext(),2);
                zllistrv.setLayoutManager(zllistmanager);
                zllistrv.setAdapter(zllistadapter);
                break;
            case 4:
                List<HomeBean.DataBean.CourseRecommendsBean> courserecommendslist = (List<HomeBean.DataBean.CourseRecommendsBean>) o;
                CourserecommendsAdapter courserecommendsadapter = new CourserecommendsAdapter();
                courserecommendsadapter.updateData(courserecommendslist);
                RecyclerView courserecommendsrv = itemView.findViewById(R.id.rv_courserecommends);
                LinearLayoutManager courserecommendsmanager = new LinearLayoutManager(itemView.getContext());
                courserecommendsmanager.setOrientation(LinearLayoutManager.HORIZONTAL);
                courserecommendsrv.setLayoutManager(courserecommendsmanager);
                courserecommendsrv.setAdapter(courserecommendsadapter);
                break;
            case 5:
                List<HomeBean.DataBean.MasterLivesBean> masterliveslist = (List<HomeBean.DataBean.MasterLivesBean>) o;
                MasterlivesAdapter masterlivesadapter = new MasterlivesAdapter();
                masterlivesadapter.updateData(masterliveslist);
                RecyclerView masterlivesrv = itemView.findViewById(R.id.rv_masterlives);
                LinearLayoutManager masterlivesmanager = new LinearLayoutManager(itemView.getContext());
                masterlivesmanager.setOrientation(LinearLayoutManager.VERTICAL);
                masterlivesrv.setLayoutManager(masterlivesmanager);
                masterlivesrv.setAdapter(masterlivesadapter);
                break;
            default:
                break;
        }
    }

}