package com.example.player.a1610aplayerdemo.ui.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.ui.my.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

public class MyFragment extends Fragment {

    private ListView listView;
    private TextView tv;
    private List<MyListBean> listBeans = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_my, container, false);
        init(inflate);
        return inflate;
    }

    private void init(View inflate) {
        listView = inflate.findViewById(R.id.my_list);
        tv = inflate.findViewById(R.id.my_tv);
        getListData();
        MyListAdapter adapter = new MyListAdapter(inflate.getContext(),listBeans);
        listView.setAdapter(adapter);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }

    private void getListData() {
        listBeans.clear();
        listBeans.add(new MyListBean(R.drawable.ic_action_main_choice,"常见问题"));
        listBeans.add(new MyListBean(R.drawable.ic_action_main_my,"检查更新"));
        listBeans.add(new MyListBean(R.drawable.ic_action_main_study,"推荐《央音在线》给好友"));
        listBeans.add(new MyListBean(R.drawable.ic_action_main_vip,"意见反馈"));
    }
}
