package com.example.player.a1610aplayerdemo.fragment.member;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;

public class MemberAdapter extends BaseRecyclerViewAdapter<Bean_Member.DataBean, View> {

    private final int VIEW_TYPE_ONE = 0;

    @Override
    public View getItemView(Context context, int viewType) {
        switch (viewType){
            case 0: // 根据position为0 返回的view 是MemberitemView
                return new MemberItemView(context);
                default:
                    return new MemberItemView(context);

        }
    }


    @Override
    protected int getViewType(int position) {
        switch (position){
            case 0:
                return VIEW_TYPE_ONE;
            default:
                return VIEW_TYPE_ONE;
        }
    }

    @Override
    public void refreshItemUi(View itemView, Bean_Member.DataBean dataBean,int position) {
          switch (position){
              case 0:
                  MemberItemView memberItemView = (MemberItemView) itemView;
                  memberItemView.updateImg(dataBean.getImage());
                  break;
                  default:
                      MemberItemView memberItemViewd = (MemberItemView) itemView;
                      memberItemViewd.updateImg(dataBean.getImage());
                      break;
          }
    }
}
