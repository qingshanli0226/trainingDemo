package com.example.player.a1610aplayerdemo.interface2.fragment2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;

public class KnowledgeFragment extends Fragment {
    private TextView ssssssss;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_knowledge, container, false);
        Bundle bundle = getArguments();
        String s = bundle.getString("f1");
        initView(view);
        ssssssss.setText(s);
        return view;
    }

    private void initView(View view) {
        ssssssss = (TextView) view.findViewById(R.id.ssssssss);
    }
}
