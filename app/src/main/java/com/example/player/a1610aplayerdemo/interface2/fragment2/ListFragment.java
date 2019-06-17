package com.example.player.a1610aplayerdemo.interface2.fragment2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.interface2.interface2bean.InterfaceBean2;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {
    private List<InterfaceBean2.ChaptersBean> list = new ArrayList<>();
    private List<String> list1 = new ArrayList<>();
    private ListView list_list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        Bundle bundle = getArguments();
        initView(view);
        list = (List<InterfaceBean2.ChaptersBean>) bundle.getSerializable("list");
        for (InterfaceBean2.ChaptersBean bean : list) {
            list1.add(bean.getName());
        }
        String[] ss = new String[list1.size()];
        for (int a=0;a<list1.size();a++){
            ss[a]=list1.get(a);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, ss);
        list_list.setAdapter(adapter);
        return view;
    }

    private void initView(View view) {
        list_list = (ListView) view.findViewById(R.id.list_list);
    }
}
