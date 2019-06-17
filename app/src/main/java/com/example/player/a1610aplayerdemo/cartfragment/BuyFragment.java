package com.example.player.a1610aplayerdemo.cartfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.cartfragment.classfragment.BuyClassFragment;
import com.example.player.a1610aplayerdemo.cartfragment.classfragment.NoLoginFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class BuyFragment extends Fragment {


    private FrameLayout frameLayout;

    public BuyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buy, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout);
        //应该获取接口返回判断是否登录，，没有登录时为NoLoginFragment
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new NoLoginFragment()).commit();
        //登陆后
        // getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new BuyClassFragment()).commit();


    }
}
