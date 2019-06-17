package com.example.player.a1610aplayerdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.discover.DiscoverFragment;
import com.example.player.a1610aplayerdemo.member.MemberFragment;
import com.example.player.a1610aplayerdemo.my.MyFragment;
import com.example.player.a1610aplayerdemo.shopping.ShoppingFragment;

import java.util.ArrayList;
import java.util.List;

public class InterfaceActivity extends AppCompatActivity {

    @BindView(R.id.interface_fragmeLayout)
    FrameLayout interfaceFragmeLayout;
    @BindView(R.id.interface_radio1)
    RadioButton interfaceRadio1;
    @BindView(R.id.interface_radio2)
    RadioButton interfaceRadio2;
    @BindView(R.id.interface_radio3)
    RadioButton interfaceRadio3;
    @BindView(R.id.interface_radio4)
    RadioButton interfaceRadio4;
    @BindView(R.id.interface_group)
    RadioGroup interfaceGroup;
    private List<Fragment> list = new ArrayList<>();
    private Fragment nowadayFragment;
    private int position;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);
        ButterKnife.bind(this);
        initView();
        interfaceRadio1.setChecked(true);
        Fragment selectFragment = list.get(0);
        switchFragment(nowadayFragment,selectFragment);
    }

    private void initView() {


        list.add(new DiscoverFragment());
        list.add(new MemberFragment());
        list.add(new ShoppingFragment());
        list.add(new MyFragment());
    }

    private void switchFragment(Fragment fromFragment, Fragment nextFragment) {
        if (nowadayFragment != nextFragment) {
            nowadayFragment = nextFragment;
            if (nextFragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if (!nextFragment.isAdded()) {
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.add(R.id.interface_fragmeLayout, nextFragment).commit();
                } else {
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }

    @OnClick({R.id.interface_radio1, R.id.interface_radio2, R.id.interface_radio3, R.id.interface_radio4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.interface_radio1:
                position=0;
                break;
            case R.id.interface_radio2:
                position=1;
                break;
            case R.id.interface_radio3:
                position=2;
                break;
            case R.id.interface_radio4:
                position=3;
                break;
                default:
                    break;
        }
        Fragment selectFragment = list.get(position);
        switchFragment(nowadayFragment,selectFragment);

    }
}
