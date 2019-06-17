package com.example.player.a1610aplayerdemo.ui.vip;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.example.player.a1610aplayerdemo.R;

class VipViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView vip_vip_iv;

        public VipViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.vip_vip_iv = (ImageView) rootView.findViewById(R.id.vip_vip_iv);
        }
}
