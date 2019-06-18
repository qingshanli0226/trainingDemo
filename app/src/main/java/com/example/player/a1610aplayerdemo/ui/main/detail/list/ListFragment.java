package com.example.player.a1610aplayerdemo.ui.main.detail.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.example.player.a1610aplayerdemo.Constant;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.IMyClick;
import com.example.player.a1610aplayerdemo.bean.DetailBean;
import com.example.player.a1610aplayerdemo.ui.main.VideoActivity;
import com.example.player.a1610aplayerdemo.ui.main.detail.DetailsActivity;

import java.util.List;

public class ListFragment extends Fragment {
    private ListView listView;

    private List<DetailBean.ChaptersBean> chapters;

    private String url;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View inflate = inflater.inflate(R.layout.details_vp_list, container, false);
        listView = inflate.findViewById(R.id.details_oneList);
        return inflate;
    }

    public void setData(DetailBean data, String url) {
//        if(data.getLectures() == null){
        chapters = data.getChapters();
        ListOneAdapter oneAdapter = new ListOneAdapter(chapters, getContext(), iMyClick);
        listView.setAdapter(oneAdapter);
        this.url = url;
//        }else{
//            List<DetailBean.LecturesBean> lectures = data.getLectures();
//        }

    }

    private IMyClick iMyClick = new IMyClick() {
        @Override
        public void onItemClick(View view, int i) {

        }

        @Override
        public void setListItemJianJieClick(int i) {
            DetailBean.ChaptersBean chaptersBean = chapters.get(i);
            int id = chaptersBean.getId();
//            /restapi/course/getVideo2?courseId=367&packageId=0
//            /restapi/course/getVideo2?courseId=367&chapterId=1868&packageId=0
//            "chapterId="+id+"&",
            StringBuffer stringBuffer = new StringBuffer();
            int i1 = url.indexOf("&");
            stringBuffer.append(url).insert(i1+1,"chapterId="+id+"&");
            String s = stringBuffer.toString();
            Intent intent = new Intent(getActivity(), DetailsActivity.class);
            intent.putExtra(Constant.URL, s);
            getActivity().startActivity(intent);
            getActivity().finish();
        }

        @Override
        public void setListItemTitleClick(int i) {
            DetailBean.ChaptersBean chaptersBean = chapters.get(i);
            String name = chaptersBean.getName();
            String url = "http://9890.vod.myqcloud.com/9890_9c1fa3e2aea011e59fc841df10c92278.f20.mp4";
            //跳转播放视频
            Intent intent = new Intent(getActivity(), VideoActivity.class);
            intent.putExtra(Constant.URL, url);
            intent.putExtra(Constant.TITLE, name);
            startActivity(intent);
        }
    };
}
