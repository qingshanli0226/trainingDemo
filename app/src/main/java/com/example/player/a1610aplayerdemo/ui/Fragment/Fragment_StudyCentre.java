package com.example.player.a1610aplayerdemo.ui.Fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.player.a1610aplayerdemo.MainActivity;
import com.example.player.a1610aplayerdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class Fragment_StudyCentre extends Fragment {


    public Fragment_StudyCentre(MainActivity mainActivity) {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment__study_centre, container, false);
        return view;
    }

}
