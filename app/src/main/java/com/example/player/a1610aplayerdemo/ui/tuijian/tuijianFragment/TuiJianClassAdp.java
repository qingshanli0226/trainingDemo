package com.example.player.a1610aplayerdemo.ui.tuijian.tuijianFragment;

import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseAdapter;
import com.example.player.a1610aplayerdemo.base.OldBaseViewHolder;
import com.example.player.a1610aplayerdemo.bean.TuiJianDateBean;

public class TuiJianClassAdp extends BaseAdapter<TuiJianDateBean.ChaptersBean> {
    @Override
    protected int getLayoutId() {
        return R.layout.keshilist_litm_lv;
    }

    @Override
    protected void convert(OldBaseViewHolder oldBaseViewHolder, int i) {

        String name = data.get(i).getName();

        TextView tv = oldBaseViewHolder.getView(R.id.tuijian_shipin_name);

        tv.setText(name);

    }
}
