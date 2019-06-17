package com.example.player.a1610aplayerdemo.my.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.my.bean.Feedback;
import com.example.player.a1610aplayerdemo.my.presenter.FeedbackPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedbackFragment extends Fragment implements IBaseView<Feedback> {
    IBasePresenter iBasePresenter;

    @BindView(R.id.feedback_et1)
    EditText feedbackEt1;
    @BindView(R.id.feedback_et2)
    EditText feedbackEt2;
    @BindView(R.id.feedback_btn)
    Button feedbackBtn;
    Unbinder unbinder;
    @BindView(R.id.feedback_back)
    ImageView feedbackBack;

    private SharedPreferences sp;

    public FeedbackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        sp = getActivity().getSharedPreferences("feedback", Context.MODE_PRIVATE);
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onLoadData(Feedback data) {
        if (!data.getContents().equals("")) {
            Toast.makeText(getActivity(), "提交成功", Toast.LENGTH_SHORT).show();
            Log.i("aaa", data.getContents());
            getFragmentManager().popBackStack();
        }
    }

    @Override
    public void onLoadError(int code, String message) {

    }

    @OnClick({R.id.feedback_back, R.id.feedback_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.feedback_back:
                getFragmentManager().popBackStack();
                break;
            case R.id.feedback_btn:
                String s1 = feedbackEt1.getText().toString().trim();
                String s2 = feedbackEt2.getText().toString().trim();
                if (s1.equals("") || s2.equals("")) {
                    Toast.makeText(getActivity(), "有空值", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("opinion", s1);
                    editor.putString("relation", s2);
                    editor.commit();

                    iBasePresenter = new FeedbackPresenter();
                    iBasePresenter.attachView(this);
                    iBasePresenter.getData();
                }
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RadioGroup radioGroup = getActivity().findViewById(R.id.home_radioG);
        radioGroup.setVisibility(View.VISIBLE);
    }
}
