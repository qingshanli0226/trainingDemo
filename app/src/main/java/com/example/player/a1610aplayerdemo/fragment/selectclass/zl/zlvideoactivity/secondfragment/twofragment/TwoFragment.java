package com.example.player.a1610aplayerdemo.fragment.selectclass.zl.zlvideoactivity.secondfragment.twofragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerFragment;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.fragment.selectclass.zl.zlvideoactivity.bean.ZlvideoBean;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment {

private List<ZlvideoBean.DataBean> data ;
private View view;
private RecyclerView m_rv;
private VideoRvAdapter videoRvAdapter;
    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        Bundle arguments = getArguments();
        data = arguments.getParcelableArrayList("videodata");
        Toast.makeText(getContext(), ""+data.get(0).getTitle(), Toast.LENGTH_SHORT).show();

        initAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_two,container,false);
        initView();

        return view;
    }

    private void initAdapter() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        m_rv.setLayoutManager(manager);
        videoRvAdapter = new VideoRvAdapter();
        videoRvAdapter.setList(data);
        m_rv.setAdapter(videoRvAdapter);

        m_rv.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

    }

    private void initView() {
        m_rv = view.findViewById(R.id.video_rv);
    }
}
