package com.example.player.a1610aplayerdemo.bean;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class NowZhiBoDateBean {

    /**
     * id : 300
     * roomTitle : “琴弦上的思念”——纪念著名小提琴演奏家盛中国先生音乐会
     * courseTitle : “琴弦上的思念”——纪念著名小提琴演奏家盛中国先生音乐会
     * startTime : 2019-06-14 19:30:00
     * endTime : 2019-06-14 22:03:31
     * teacherId : 169
     * price : 35.0
     * wxprice : 0.0
     * hkstatus : 0
     * wxstatus : 0
     * qcodeurl :
     * imageUrl : http://ali-files.yooshow.com/2019/06/03/078c16c7-c2a2-4942-93ee-3dcf0a9bca3e.jpg
     * passporttype :
     * showVote : 0
     * gradeCategoryId : 3
     * ccomPercentage : 30
     * liveType : 1
     * zlId : 0
     * jgId : 0
     * hide : 0
     * closeType : 0
     * belongType : 0
     * teacherName : 中央音乐学院管弦系
     * teacherTitle : 中央音乐学院管弦系
     * reservation : false
     * reservationCount : 0
     * liveIsBuy : false
     * auditionSecond : 0
     * shareView : {"sharePic":"http://ali-files.yooshow.com/app/yangyin/default-red-share.png","shareTitle":"【央音在线】中央音乐学院官方平台","shareUrl":"http://api.immedc.com/restapi/app/download","shareContent":"名校教育，名师领航，为您提供一站无忧式音乐教学服务。"}
     * liveMicId : 0
     * liveMicPassportId : 0
     * myLiveMicId : 0
     * myLiveMicPassportId : 0
     * reservationId : 0
     * courseVipPrice : 35.0
     * courseVipOpenType : 1
     * courseVipIcon : false
     * priceText : 35元
     * groupCount : 0
     * vip : false
     * liveStatus : 2
     */

    private int id;
    private String roomTitle;
    private String courseTitle;
    private String startTime;
    private String endTime;
    private int teacherId;
    private double price;
    private double wxprice;
    private int hkstatus;
    private int wxstatus;
    private String qcodeurl;
    private String imageUrl;
    private String passporttype;
    private int showVote;
    private int gradeCategoryId;
    private int ccomPercentage;
    private int liveType;
    private int zlId;
    private int jgId;
    private int hide;
    private int closeType;
    private int belongType;
    private String teacherName;
    private String teacherTitle;
    private boolean reservation;
    private int reservationCount;
    private boolean liveIsBuy;
    private int auditionSecond;
    private ShareViewBean shareView;
    private int liveMicId;
    private int liveMicPassportId;
    private int myLiveMicId;
    private int myLiveMicPassportId;
    private int reservationId;
    private double courseVipPrice;
    private int courseVipOpenType;
    private boolean courseVipIcon;
    private String priceText;
    private int groupCount;
    private boolean vip;
    private int liveStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWxprice() {
        return wxprice;
    }

    public void setWxprice(double wxprice) {
        this.wxprice = wxprice;
    }

    public int getHkstatus() {
        return hkstatus;
    }

    public void setHkstatus(int hkstatus) {
        this.hkstatus = hkstatus;
    }

    public int getWxstatus() {
        return wxstatus;
    }

    public void setWxstatus(int wxstatus) {
        this.wxstatus = wxstatus;
    }

    public String getQcodeurl() {
        return qcodeurl;
    }

    public void setQcodeurl(String qcodeurl) {
        this.qcodeurl = qcodeurl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPassporttype() {
        return passporttype;
    }

    public void setPassporttype(String passporttype) {
        this.passporttype = passporttype;
    }

    public int getShowVote() {
        return showVote;
    }

    public void setShowVote(int showVote) {
        this.showVote = showVote;
    }

    public int getGradeCategoryId() {
        return gradeCategoryId;
    }

    public void setGradeCategoryId(int gradeCategoryId) {
        this.gradeCategoryId = gradeCategoryId;
    }

    public int getCcomPercentage() {
        return ccomPercentage;
    }

    public void setCcomPercentage(int ccomPercentage) {
        this.ccomPercentage = ccomPercentage;
    }

    public int getLiveType() {
        return liveType;
    }

    public void setLiveType(int liveType) {
        this.liveType = liveType;
    }

    public int getZlId() {
        return zlId;
    }

    public void setZlId(int zlId) {
        this.zlId = zlId;
    }

    public int getJgId() {
        return jgId;
    }

    public void setJgId(int jgId) {
        this.jgId = jgId;
    }

    public int getHide() {
        return hide;
    }

    public void setHide(int hide) {
        this.hide = hide;
    }

    public int getCloseType() {
        return closeType;
    }

    public void setCloseType(int closeType) {
        this.closeType = closeType;
    }

    public int getBelongType() {
        return belongType;
    }

    public void setBelongType(int belongType) {
        this.belongType = belongType;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherTitle() {
        return teacherTitle;
    }

    public void setTeacherTitle(String teacherTitle) {
        this.teacherTitle = teacherTitle;
    }

    public boolean isReservation() {
        return reservation;
    }

    public void setReservation(boolean reservation) {
        this.reservation = reservation;
    }

    public int getReservationCount() {
        return reservationCount;
    }

    public void setReservationCount(int reservationCount) {
        this.reservationCount = reservationCount;
    }

    public boolean isLiveIsBuy() {
        return liveIsBuy;
    }

    public void setLiveIsBuy(boolean liveIsBuy) {
        this.liveIsBuy = liveIsBuy;
    }

    public int getAuditionSecond() {
        return auditionSecond;
    }

    public void setAuditionSecond(int auditionSecond) {
        this.auditionSecond = auditionSecond;
    }

    public ShareViewBean getShareView() {
        return shareView;
    }

    public void setShareView(ShareViewBean shareView) {
        this.shareView = shareView;
    }

    public int getLiveMicId() {
        return liveMicId;
    }

    public void setLiveMicId(int liveMicId) {
        this.liveMicId = liveMicId;
    }

    public int getLiveMicPassportId() {
        return liveMicPassportId;
    }

    public void setLiveMicPassportId(int liveMicPassportId) {
        this.liveMicPassportId = liveMicPassportId;
    }

    public int getMyLiveMicId() {
        return myLiveMicId;
    }

    public void setMyLiveMicId(int myLiveMicId) {
        this.myLiveMicId = myLiveMicId;
    }

    public int getMyLiveMicPassportId() {
        return myLiveMicPassportId;
    }

    public void setMyLiveMicPassportId(int myLiveMicPassportId) {
        this.myLiveMicPassportId = myLiveMicPassportId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public double getCourseVipPrice() {
        return courseVipPrice;
    }

    public void setCourseVipPrice(double courseVipPrice) {
        this.courseVipPrice = courseVipPrice;
    }

    public int getCourseVipOpenType() {
        return courseVipOpenType;
    }

    public void setCourseVipOpenType(int courseVipOpenType) {
        this.courseVipOpenType = courseVipOpenType;
    }

    public boolean isCourseVipIcon() {
        return courseVipIcon;
    }

    public void setCourseVipIcon(boolean courseVipIcon) {
        this.courseVipIcon = courseVipIcon;
    }

    public String getPriceText() {
        return priceText;
    }

    public void setPriceText(String priceText) {
        this.priceText = priceText;
    }

    public int getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(int groupCount) {
        this.groupCount = groupCount;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public int getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(int liveStatus) {
        this.liveStatus = liveStatus;
    }

    @BindingAdapter("bind:url")
    public static void loadImageUrl(ImageView imageView, String url){

        Glide.with(imageView.getContext()).load(url).into(imageView);

    }

    public static class ShareViewBean {
        /**
         * sharePic : http://ali-files.yooshow.com/app/yangyin/default-red-share.png
         * shareTitle : 【央音在线】中央音乐学院官方平台
         * shareUrl : http://api.immedc.com/restapi/app/download
         * shareContent : 名校教育，名师领航，为您提供一站无忧式音乐教学服务。
         */

        private String sharePic;
        private String shareTitle;
        private String shareUrl;
        private String shareContent;

        public String getSharePic() {
            return sharePic;
        }

        public void setSharePic(String sharePic) {
            this.sharePic = sharePic;
        }

        public String getShareTitle() {
            return shareTitle;
        }

        public void setShareTitle(String shareTitle) {
            this.shareTitle = shareTitle;
        }

        public String getShareUrl() {
            return shareUrl;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }

        public String getShareContent() {
            return shareContent;
        }

        public void setShareContent(String shareContent) {
            this.shareContent = shareContent;
        }
    }



}
