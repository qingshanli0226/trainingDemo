package com.example.player.a1610aplayerdemo.mvvm.book;

import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

public class BookBean {

    /**
     * cid : 2
     * createdAt : 2016-06-23 15:25:43
     * id : 0
     * name : 蓝天
     * price : 25
     * product_url : http://www.meditool.cn/uploadfiles/image/20180103/9D9A5CAB-DE35-9080-388F-1E369A32347F.jpg
     * school : 天津大学
     * user_tel : 13537635231
     */

    private int cid;
    private String createdAt;
    private int id;
    private String name;
    private String price;
    private String product_url;
    private String school;
    private String user_tel;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProduct_url() {
        return product_url;
    }

    public void setProduct_url(String product_url) {
        this.product_url = product_url;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    @BindingAdapter("bind:url")
    public static void loadImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }
}