package com.example.player.a1610aplayerdemo.my.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.example.player.a1610aplayerdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    @BindView(R.id.feedback_back)
    ImageView feedbackBack;
    @BindView(R.id.login_text)
    TextView loginText;
    @BindView(R.id.account_edit)
    EditText accountEdit;
    @BindView(R.id.password_edit)
    EditText passwordEdit;
    @BindView(R.id.show_hidden)
    TextView showHidden;
    @BindView(R.id.ok_button)
    Button okButton;
    Unbinder unbinder;

    private boolean flage = true;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RadioGroup radioGroup = getActivity().findViewById(R.id.home_radioG);
        radioGroup.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.feedback_back, R.id.login_text, R.id.show_hidden, R.id.ok_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.feedback_back:
                getFragmentManager().popBackStack();
                break;
            case R.id.login_text:

                break;
            case R.id.show_hidden:
                if(flage){
                    flage = false;
                    //android:inputType="textPassword"
                    showHidden.setText("隐藏");
                    passwordEdit.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else {
                    flage = true;
                    showHidden.setText("显示");
                    passwordEdit.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                break;
            case R.id.ok_button:

                break;
        }
    }
}
