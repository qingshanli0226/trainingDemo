package com.example.player.a1610aplayerdemo.fragment.member;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerFragment;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Member_Fragment extends Fragment {


    public Member_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_member,container,false);
    }

//    @Override
//    public BaseRecyclerViewAdapter<Bean_Member.DataBean, MemberItemView> getAdapter() {
//        return null;
//    }
//
//    @Override
//    public IBasePresenter getPresenter() {
//        return null;
//    }

}
