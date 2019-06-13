package com.example.player.a1610aplayerdemo.message;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.message.adapter.BuyFragmentAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {


    @BindView(R.id.buy_tab)
    TabLayout buyTab;
    @BindView(R.id.buy_viewpager)
    ViewPager buyViewpager;
    @BindView(R.id.buy_register_btn)
    Button buyRegisterBtn;
    @BindView(R.id.buy_Linear)
    LinearLayout buyLinear;
    Unbinder unbinder;

    private BuyFragmentAdapter buyFragmentAdapter;

    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        buyFragmentAdapter = new BuyFragmentAdapter(getChildFragmentManager());
        buyViewpager.setAdapter(buyFragmentAdapter);
        buyTab.setupWithViewPager(buyViewpager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
