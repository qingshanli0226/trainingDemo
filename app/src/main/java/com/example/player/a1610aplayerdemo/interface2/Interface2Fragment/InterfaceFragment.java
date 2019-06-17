package com.example.player.a1610aplayerdemo.interface2.Interface2Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.interface2.fragment2.KnowledgeFragment;
import com.example.player.a1610aplayerdemo.interface2.fragment2.ListFragment;
import com.example.player.a1610aplayerdemo.interface2.interface2bean.InterfaceBean2;
import com.example.player.a1610aplayerdemo.interface2.presenter.Interface2Presenter;
import com.example.player.a1610aplayerdemo.shopping.tabadapter.TabLayoutAdapter;
import com.othershe.library.NiceImageView;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InterfaceFragment extends Fragment implements IBaseView {

    private IBasePresenter presenter;
    private String url;
    private NiceImageView banner_niv;
    private ImageView banner_image;
    private TextView interface_tv1;
    private TextView banner_text1;
    private TextView banner_text2;
    private ImageView opinion_iv1;
    private TabLayout banner_tab;
    private ViewPager interface_pager;
    private List<Fragment> list1 = new ArrayList<>();
    private List<String> list2 = new ArrayList<>();
    private KnowledgeFragment fragment1=new KnowledgeFragment();
    private ListFragment fragment2=new ListFragment();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_interface, container, false);
        initView(view);
        Bundle bundle = getArguments();
        url = bundle.getString("url");
        presenter = new Interface2Presenter(url);
        presenter.attachView(this);
        presenter.getData();
        opinion_iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        return view;
    }

    @Override
    public void onLoadData(Object data) {
        InterfaceBean2 bean2 = (InterfaceBean2) data;
        Picasso.get().load(bean2.getImage()).into(banner_image);
        Picasso.get().load(bean2.getTeacherAvatar()).into(banner_niv);
        interface_tv1.setText(bean2.getName());
        banner_text1.setText(bean2.getTeacherTitle());
        banner_text2.setText(bean2.getCourseName());
        f1(bean2);
        f2(bean2);
        tablayout();
    }

    private void f2(InterfaceBean2 bean2) {
        Bundle bundle=new Bundle();
        bundle.putSerializable("list", (Serializable) bean2.getChapters());
        fragment2.setArguments(bundle);
    }

    private void f1(InterfaceBean2 bean2) {
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(bean2.getCourseName()+"\n");
        stringBuffer.append(bean2.getCourseIntroduce()+"\n");
        stringBuffer.append(bean2.getSummany()+"\n");
        stringBuffer.append(bean2.getTeacherIntroduce()+"\n");
        Bundle bundle=new Bundle();
        bundle.putString("f1",stringBuffer.toString());
        fragment1.setArguments(bundle);
    }

    @Override
    public void onLoadError(String message) {

    }

    private void initView(View view) {
        banner_niv = (NiceImageView) view.findViewById(R.id.banner_niv);
        banner_image = (ImageView) view.findViewById(R.id.banner_image);
        interface_tv1 = (TextView) view.findViewById(R.id.interface_tv1);
        banner_text1 = (TextView) view.findViewById(R.id.banner_text1);
        banner_text2 = (TextView) view.findViewById(R.id.banner_text2);
        opinion_iv1 = (ImageView) view.findViewById(R.id.opinion_iv1);
        banner_tab = (TabLayout) view.findViewById(R.id.banner_tab);
        interface_pager = (ViewPager) view.findViewById(R.id.interface_pager);
        list1.add(fragment1);
        list1.add(fragment2);
        list2.add("本课知识");
        list2.add("课时列表");
    }
    private void tablayout() {
        TabLayoutAdapter adapter = new TabLayoutAdapter(getChildFragmentManager(), list1, list2);
        interface_pager.setAdapter(adapter);
        banner_tab.setupWithViewPager(interface_pager);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
        RadioGroup radioGroup = getActivity().findViewById(R.id.interface_group);
        radioGroup.setVisibility(View.VISIBLE);
    }
}
