package com.example.player.a1610aplayerdemo.ui.cartfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.ui.cartfragment.classfragment.NoLoginFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class VipFragment extends Fragment {


    private FrameLayout frameLayout_Vip;

    public VipFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vip, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        frameLayout_Vip = (FrameLayout) view.findViewById(R.id.frameLayout_Vip);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_Vip,new NoLoginFragment()).commit();

       // getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_Vip,new VipFragment()).commit();



    }
}
