package com.example.player.a1610aplayerdemo.my;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.my.fragment.FeedbackFragment;
import com.othershe.library.NiceImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment {


    @BindView(R.id.my_niv_portrait)
    NiceImageView myNivPortrait;
    @BindView(R.id.my_niv_register)
    TextView myNivRegister;
    @BindView(R.id.my_iv_set)
    ImageView myIvSet;
    @BindView(R.id.my_iv_message)
    ImageView myIvMessage;
    @BindView(R.id.my_ll_issue)
    LinearLayout myLlIssue;
    @BindView(R.id.my_ll_update)
    LinearLayout myLlUpdate;
    @BindView(R.id.my_ll_recommend)
    LinearLayout myLlRecommend;
    @BindView(R.id.my_ll_opinion)
    LinearLayout myLlOpinion;
    Unbinder unbinder;

    public MeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.my_niv_portrait, R.id.my_niv_register, R.id.my_iv_set, R.id.my_iv_message, R.id.my_ll_issue, R.id.my_ll_update, R.id.my_ll_recommend, R.id.my_ll_opinion})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_niv_portrait:
                break;
            case R.id.my_niv_register:
                break;
            case R.id.my_iv_set:
                break;
            case R.id.my_iv_message:
                break;
            case R.id.my_ll_issue:
                break;
            case R.id.my_ll_update:
                break;
            case R.id.my_ll_recommend:
                break;
            case R.id.my_ll_opinion:
                RadioGroup radioGroup = getActivity().findViewById(R.id.home_radioG);
                radioGroup.setVisibility(View.GONE);
                getFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)  //将当前fragment加入到返回栈中
                        .replace(R.id.home_frame,new FeedbackFragment())
                        .commit();
                break;
        }
    }
}
