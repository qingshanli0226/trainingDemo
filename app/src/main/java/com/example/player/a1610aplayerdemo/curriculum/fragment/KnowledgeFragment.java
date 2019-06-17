package com.example.player.a1610aplayerdemo.curriculum.fragment;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.curriculum.bean.BannerBean;

/**
 * A simple {@link Fragment} subclass.
 */
public class KnowledgeFragment extends Fragment {

    @BindView(R.id.knowledge_title)
    TextView knowledgeTitle;
    @BindView(R.id.knowledge_message)
    TextView knowledgeMessage;
    Unbinder unbinder;
    private BannerReseiver bannerReseiver;
    private BannerBean bannerBean;

    public KnowledgeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        bannerReseiver = new BannerReseiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.banner.message");
        getActivity().registerReceiver(bannerReseiver, intentFilter);
        View view = inflater.inflate(R.layout.fragment_knowledge, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public class BannerReseiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.banner.message")) {
                Bundle bundle = intent.getExtras();
                bannerBean = (BannerBean) bundle.getSerializable("bannerBean");
                initData();
            }
        }
    }

    private void initData() {
        knowledgeTitle.setText(bannerBean.getCourseName());
        knowledgeMessage.setText(bannerBean.getCourseIntroduce());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(bannerReseiver);
    }
}
