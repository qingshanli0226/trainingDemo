package com.example.player.a1610aplayerdemo.fragment.selectclass;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectClass_Fragment extends Fragment {


    public SelectClass_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_select_class,container,false);
    }

}