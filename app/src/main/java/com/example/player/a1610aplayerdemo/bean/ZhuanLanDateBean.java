package com.example.player.a1610aplayerdemo.bean;

public class ZhuanLanDateBean {


    /**
     * id : 23
     * teacherId : 190
     * title : 社区音乐
     * image : http://ali-files.yooshow.com/2019/03/04/cdb5d2c9-cd52-4d4e-8428-e37b8b8801a9.jpg
     * showIndex : 4
     * isQa : 1
     * qaPrice : 0.0
     * percentage : 70
     * ccomPercentage : 30
     * teacherPercentage : 55
     * introduce : 央音社区音乐栏目致力于让优秀基础音乐培训走入社区来全面提升广大群众的音乐素养，让有钢琴与音乐梦想的人都能轻松快速实现愿望，从而建设生机勃勃的文化环境，让一代又一代的人热爱音乐。内容包含：成人钢琴速成培训、基础乐理知识、钢琴自弹自唱（通俗唱法）、钢琴即兴伴奏等。
     * barTitle : 社区音乐
     * barColor : #8f002e
     * teacherName : 姚侃
     * teacherAvatar : http://ali-files.yooshow.com/2019/01/03/16f934d7-bfac-462b-87bf-9f03749a24dd.png
     * passportId : 209
     * shareView : {"sharePic":"http://ali-files.yooshow.com/2019/01/03/16f934d7-bfac-462b-87bf-9f03749a24dd.png","shareTitle":"姚侃社区音乐","shareUrl":"http://m.immedc.com/fenxiang/zhuanqu?id=23","shareContent":"点击了解专栏动态，专区资讯，获取名师课程。"}
     */

    private int id;
    private int teacherId;
    private String title;
    private String image;
    private int showIndex;
    private int isQa;
    private double qaPrice;
    private int percentage;
    private int ccomPercentage;
    private int teacherPercentage;
    private String introduce;
    private String barTitle;
    private String barColor;
    private String teacherName;
    private String teacherAvatar;
    private int passportId;
    private ShareViewBean shareView;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
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

    public int getShowIndex() {
        return showIndex;
    }

    public void setShowIndex(int showIndex) {
        this.showIndex = showIndex;
    }

    public int getIsQa() {
        return isQa;
    }

    public void setIsQa(int isQa) {
        this.isQa = isQa;
    }

    public double getQaPrice() {
        return qaPrice;
    }

    public void setQaPrice(double qaPrice) {
        this.qaPrice = qaPrice;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getCcomPercentage() {
        return ccomPercentage;
    }

    public void setCcomPercentage(int ccomPercentage) {
        this.ccomPercentage = ccomPercentage;
    }

    public int getTeacherPercentage() {
        return teacherPercentage;
    }

    public void setTeacherPercentage(int teacherPercentage) {
        this.teacherPercentage = teacherPercentage;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getBarTitle() {
        return barTitle;
    }

    public void setBarTitle(String barTitle) {
        this.barTitle = barTitle;
    }

    public String getBarColor() {
        return barColor;
    }

    public void setBarColor(String barColor) {
        this.barColor = barColor;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherAvatar() {
        return teacherAvatar;
    }

    public void setTeacherAvatar(String teacherAvatar) {
        this.teacherAvatar = teacherAvatar;
    }

    public int getPassportId() {
        return passportId;
    }

    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }

    public ShareViewBean getShareView() {
        return shareView;
    }

    public void setShareView(ShareViewBean shareView) {
        this.shareView = shareView;
    }

    public static class ShareViewBean {
        /**
         * sharePic : http://ali-files.yooshow.com/2019/01/03/16f934d7-bfac-462b-87bf-9f03749a24dd.png
         * shareTitle : 姚侃社区音乐
         * shareUrl : http://m.immedc.com/fenxiang/zhuanqu?id=23
         * shareContent : 点击了解专栏动态，专区资讯，获取名师课程。
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
