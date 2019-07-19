package com.example.player.a1610aplayerdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.curriculum.CurriculumFragment;
import com.example.player.a1610aplayerdemo.message.MessageFragment;
import com.example.player.a1610aplayerdemo.my.MeFragment;
import com.example.player.a1610aplayerdemo.study.StudyFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    @BindView(R.id.home_frame)
    FrameLayout homeFrame;
    @BindView(R.id.home_radioB_curriculum)

    RadioButton homeRadioBCurriculum;
    @BindView(R.id.home_radioB_study)
    RadioButton homeRadioBStudy;
    @BindView(R.id.home_radioB_message)
    RadioButton homeRadioBMessage;
    @BindView(R.id.home_radioB_me)
    RadioButton homeRadioBMe;
    @BindView(R.id.home_radioG)
    RadioGroup homeRadioG;
    private List<Fragment> fragments;
    private Fragment nowadayFragment;
    private int position;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initFragment();
        homeRadioBCurriculum.setChecked(true);
        Fragment selectFragment = fragments.get(0);
        switchFragment(nowadayFragment,selectFragment);
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new CurriculumFragment());
        fragments.add(new StudyFragment());
        fragments.add(new MessageFragment());
        fragments.add(new MeFragment());
    }

    @OnClick({R.id.home_radioB_curriculum, R.id.home_radioB_study, R.id.home_radioB_message, R.id.home_radioB_me})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_radioB_curriculum:
                position = 0;
                break;
            case R.id.home_radioB_study:
                position = 1;
                break;
            case R.id.home_radioB_message:
                position = 2;
                break;
            case R.id.home_radioB_me:
                position = 3;
                break;
            default:
                break;
        }
        Fragment selectFragment = fragments.get(position);
        switchFragment(nowadayFragment,selectFragment);
    }

    private void switchFragment(Fragment fromFragment, Fragment nextFragment) {
        if(nowadayFragment != nextFragment){
            nowadayFragment = nextFragment;
            if(nextFragment != null){
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if(!nextFragment.isAdded()){
                    if(fromFragment != null){
                        transaction.hide(fromFragment);
                    }
                    transaction.add(R.id.home_frame,nextFragment).commit();
                }else {
                    if(fromFragment!=null){
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }
}
