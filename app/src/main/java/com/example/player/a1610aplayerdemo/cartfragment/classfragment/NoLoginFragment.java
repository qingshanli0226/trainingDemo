package com.example.player.a1610aplayerdemo.cartfragment.classfragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.login.LoginActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoLoginFragment extends Fragment implements View.OnClickListener {


    private Button gologin_register;

    public NoLoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_no_login, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        gologin_register = (Button) view.findViewById(R.id.gologin_register);

        gologin_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gologin_register:
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
