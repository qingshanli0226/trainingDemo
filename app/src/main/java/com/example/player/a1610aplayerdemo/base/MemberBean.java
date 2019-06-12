package com.example.player.a1610aplayerdemo.base;

import java.util.List;

/**
 * Created by Lmz on 2019/06/12
 * 会员页面的Bean 类
 */
public class MemberBean {

    /**
     * success : true
     * message :
     * code : success
     * data : [{"id":16,"name":"360会员","image":"http://ali-files.yooshow.com/2019/05/17/19dcaef2-f81d-4870-98f0-8154621b2b45.png","videoQuota":50,"price":360,"wxprice":360,"wxstatus":1,"showIndex":8,"introduce":"【会员权益】1、360会员可享受会员专区课程任选50节，须在一年内选择完毕，到期后未使用的课程配额将会作废；2、本会员的50节课程选择配额，可用于选择央音展演板块中的展演课程；3、本会员后可免费下载全国总展演个人视频；4、用户在选择50节自选课程时，已选择的课程将不限次数观看学习；【课程介绍】1、会员课程包括：声乐、钢琴、管弦、民乐、音基等方面的课程；2、课程适合人群：音乐教师、家长、各种水平音乐学生；3、内容水平标准：课程内容从启蒙到专业级，会员可根据自身水平和需求自选课程。【会员相关问题咨询】会员其他权益请咨询：010-58529017","promotionDeadline":"2000-01-01 00:00:00","giftQuota":0,"autoSelect":0,"packageIsBuy":false,"selectCount":0,"courseVipPrice":360,"courseVipOpenType":0,"priceText":"360元","vip":false},{"id":4,"name":"钢琴大师班","image":"http://ali-files.yooshow.com/2018/01/22/d1cb02c0-4e91-4c72-89d7-cfc5b5364d2a.jpg","videoQuota":40,"price":980,"wxprice":0,"wxstatus":0,"showIndex":6,"introduce":"\u201c央音在线\u201d钢琴乐大师班已上线，课程陆续更新，可根据个人需求选择40节课程学习。适用于所有学钢琴的人群：兴趣学习各个水平、专业学习各个水平。内容包括：周广仁、盛原等数十位教授您的百余节课程及音乐会，全方位覆盖初中高级音乐学习者。并配有周海宏教授的\u201c琴童心理课\u201d辅助琴童家长及老师指导琴童学琴。还有刘俊老师的《趣味乐理》为琴童生动有趣的讲解原本枯燥的乐理知识，达到乐理辅助学琴1+1>2的效果。","promotionDeadline":"2000-01-01 00:00:00","giftQuota":0,"autoSelect":0,"packageIsBuy":false,"selectCount":0,"courseVipPrice":980,"courseVipOpenType":0,"priceText":"980元","vip":false},{"id":2,"name":"声乐大师班","image":"http://ali-files.yooshow.com/2018/01/22/27968af7-b0cb-42db-9f35-92c9dd9cf157.jpg","videoQuota":40,"price":980,"wxprice":0,"wxstatus":0,"showIndex":5,"introduce":"\u201c央音在线\u201d声乐大师班已上线，课程陆续更新，可根据个人需求选择40节课程学习。各地市每满300人，会在当地举办一场大师课，该批次学员免费参加。适用于所有学声乐的人群：兴趣学习各个水平、专业学习各个水平。内容包括彭康亮、赵登营、李国铃等声歌系教师，李双江、李谷一、戴玉强、张莉莉等老师的课程和音乐会。","promotionDeadline":"2000-01-01 00:00:00","giftQuota":0,"autoSelect":0,"packageIsBuy":false,"selectCount":0,"courseVipPrice":980,"courseVipOpenType":0,"priceText":"980元","vip":false},{"id":3,"name":"管弦乐大师班","image":"http://ali-files.yooshow.com/2018/01/22/2d6693c1-cbd5-4738-b65d-42b92bba0cf6.jpg","videoQuota":40,"price":980,"wxprice":0,"wxstatus":0,"showIndex":4,"introduce":"\u201c央音在线\u201d管弦乐大师班已上线，课程陆续更新，可根据个人需求选择40节课程学习。内容包括：管弦专业课、专业基础课、音乐素养课，全方位覆盖管弦乐各专业初中高级音乐学习者。并配有周海宏教授的\u201c琴童心理课\u201d辅助琴童家长及老师指导琴童学琴。还有刘俊老师的《趣味乐理》为琴童生动有趣的讲解原本枯燥的乐理知识，达到乐理辅助学琴1+1>2的效果。","promotionDeadline":"2000-01-01 00:00:00","giftQuota":0,"autoSelect":0,"packageIsBuy":false,"selectCount":0,"courseVipPrice":980,"courseVipOpenType":0,"priceText":"980元","vip":false}]
     */

    private boolean success;
    private String message;
    private String code;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 16
         * name : 360会员
         * image : http://ali-files.yooshow.com/2019/05/17/19dcaef2-f81d-4870-98f0-8154621b2b45.png
         * videoQuota : 50
         * price : 360.0
         * wxprice : 360.0
         * wxstatus : 1
         * showIndex : 8
         * introduce : 【会员权益】1、360会员可享受会员专区课程任选50节，须在一年内选择完毕，到期后未使用的课程配额将会作废；2、本会员的50节课程选择配额，可用于选择央音展演板块中的展演课程；3、本会员后可免费下载全国总展演个人视频；4、用户在选择50节自选课程时，已选择的课程将不限次数观看学习；【课程介绍】1、会员课程包括：声乐、钢琴、管弦、民乐、音基等方面的课程；2、课程适合人群：音乐教师、家长、各种水平音乐学生；3、内容水平标准：课程内容从启蒙到专业级，会员可根据自身水平和需求自选课程。【会员相关问题咨询】会员其他权益请咨询：010-58529017
         * promotionDeadline : 2000-01-01 00:00:00
         * giftQuota : 0
         * autoSelect : 0
         * packageIsBuy : false
         * selectCount : 0
         * courseVipPrice : 360.0
         * courseVipOpenType : 0
         * priceText : 360元
         * vip : false
         */

        private int id;
        private String name;
        private String image;
        private int videoQuota;
        private double price;
        private double wxprice;
        private int wxstatus;
        private int showIndex;
        private String introduce;
        private String promotionDeadline;
        private int giftQuota;
        private int autoSelect;
        private boolean packageIsBuy;
        private int selectCount;
        private double courseVipPrice;
        private int courseVipOpenType;
        private String priceText;
        private boolean vip;

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

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getVideoQuota() {
            return videoQuota;
        }

        public void setVideoQuota(int videoQuota) {
            this.videoQuota = videoQuota;
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

        public int getWxstatus() {
            return wxstatus;
        }

        public void setWxstatus(int wxstatus) {
            this.wxstatus = wxstatus;
        }

        public int getShowIndex() {
            return showIndex;
        }

        public void setShowIndex(int showIndex) {
            this.showIndex = showIndex;
        }

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public String getPromotionDeadline() {
            return promotionDeadline;
        }

        public void setPromotionDeadline(String promotionDeadline) {
            this.promotionDeadline = promotionDeadline;
        }

        public int getGiftQuota() {
            return giftQuota;
        }

        public void setGiftQuota(int giftQuota) {
            this.giftQuota = giftQuota;
        }

        public int getAutoSelect() {
            return autoSelect;
        }

        public void setAutoSelect(int autoSelect) {
            this.autoSelect = autoSelect;
        }

        public boolean isPackageIsBuy() {
            return packageIsBuy;
        }

        public void setPackageIsBuy(boolean packageIsBuy) {
            this.packageIsBuy = packageIsBuy;
        }

        public int getSelectCount() {
            return selectCount;
        }

        public void setSelectCount(int selectCount) {
            this.selectCount = selectCount;
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

        public String getPriceText() {
            return priceText;
        }

        public void setPriceText(String priceText) {
            this.priceText = priceText;
        }

        public boolean isVip() {
            return vip;
        }

        public void setVip(boolean vip) {
            this.vip = vip;
        }
    }
}
