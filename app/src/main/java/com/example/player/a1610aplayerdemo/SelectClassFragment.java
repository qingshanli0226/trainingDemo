package com.example.player.a1610aplayerdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.player.a1610aplayerdemo.mian.presenter.MainPresenterComple;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelectClassFragment extends Fragment {


    public SelectClassFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_select_class, container, false);
    }

}
