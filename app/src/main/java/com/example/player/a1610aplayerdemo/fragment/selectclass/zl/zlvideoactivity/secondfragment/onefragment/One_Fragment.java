package com.example.player.a1610aplayerdemo.fragment.selectclass.zl.zlvideoactivity.secondfragment.onefragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.fragment.selectclass.zl.zlvideoactivity.bean.ZlintroduceBean;

/**
 * A simple {@link Fragment} subclass.
 */
public class One_Fragment extends Fragment {

    private View view;
    private TextView intro_title;
    private ImageView intro_avatar;
    private TextView intro_duce;
    private TextView intro_teacher_name;

    private ZlintroduceBean.DataBean data;
    public One_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        Bundle arguments = getArguments();
        data = arguments.getParcelable("data");
        Toast.makeText(getContext(), "" + data.getBarTitle(), Toast.LENGTH_SHORT).show();

        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_one_, container, false);
        initView(view);

        return view;
    }

    private void initData() {
        intro_title.setText(data.getTitle());
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(getContext()).load(data.getTeacherAvatar()).apply(requestOptions).into(intro_avatar);
        intro_duce.setText(data.getIntroduce());
        intro_teacher_name.setText(data.getTeacherName());
    }

    private void initView(View view) {
        intro_title = (TextView) view.findViewById(R.id.intro_title);
        intro_avatar = (ImageView) view.findViewById(R.id.intro_avatar);
        intro_duce = (TextView) view.findViewById(R.id.intro_duce);
        intro_teacher_name = view.findViewById(R.id.intro_teacher_name);
    }
}
