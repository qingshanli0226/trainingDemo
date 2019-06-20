package com.example.player.a1610aplayerdemo.bean;

public class ZhuanLanVideoDateBean {


    /**
     * id : 143
     * zlId : 23
     * title : 零基础一小时双手如飞弹钢琴
     * image : http://ali-files.yooshow.com/2019/03/06/5d56d819-ab16-4634-ab48-bc8da6a0a039.png
     * introduce : 姚侃老师颠覆式成人钢琴教学发明，让自认为是世界上“最笨”的人都能轻松快速学会钢琴弹奏的教学方法
     * url : 0
     * type : 2
     * dataId : 343
     * showIndex : 1
     * layout : 1
     * price : 0.0
     * courseIsBuy : false
     * liveIsBuy : false
     * reservation : false
     * liveStatus : 0
     */

    private int id;
    private int zlId;
    private String title;
    private String image;
    private String introduce;
    private String url;
    private int type;
    private int dataId;
    private int showIndex;
    private int layout;
    private double price;
    private boolean courseIsBuy;
    private boolean liveIsBuy;
    private boolean reservation;
    private int liveStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getZlId() {
        return zlId;
    }

    public void setZlId(int zlId) {
        this.zlId = zlId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public int getShowIndex() {
        return showIndex;
    }

    public void setShowIndex(int showIndex) {
        this.showIndex = showIndex;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isCourseIsBuy() {
        return courseIsBuy;
    }

    public void setCourseIsBuy(boolean courseIsBuy) {
        this.courseIsBuy = courseIsBuy;
    }

    public boolean isLiveIsBuy() {
        return liveIsBuy;
    }

    public void setLiveIsBuy(boolean liveIsBuy) {
        this.liveIsBuy = liveIsBuy;
    }

    public boolean isReservation() {
        return reservation;
    }

    public void setReservation(boolean reservation) {
        this.reservation = reservation;
    }

    public int getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(int liveStatus) {
        this.liveStatus = liveStatus;
    }
}
