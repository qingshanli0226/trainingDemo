package com.example.player.a1610aplayerdemo.ui.home.homeactivity.zllistactivity.bean;

public class ZlListBean {


    /**
     * success : true
     * message :
     * code : success
     * data : {"id":20,"teacherId":142,"title":"走进鲁特琴的世界","image":"http://ali-files.yooshow.com/2017/10/09/76cd8503-d146-4774-8078-d6f739fd5aa3.jpg","showIndex":20,"isQa":0,"qaPrice":0,"percentage":70,"ccomPercentage":30,"teacherPercentage":0,"introduce":"鲁特琴（Lute）也称琉特琴，是一种曲颈拨弦乐器，也是意大利的传统乐器，更是现今风行世界的乐器\u2014\u2014吉他家族的祖先。鲁特琴是中世纪到巴洛克时期在欧洲使用的一类古乐器的总称，是文艺复兴时期欧洲最最风靡的家庭独奏乐器。在十六世纪和十七世纪，鲁特琴曾是欧洲最为流行的伴奏乐器之一。这种古老的乐器，其中长颈的长鲁特的历史至少可以推溯到公元前2000年，短颈的鲁特约公元前800年诞生。 \r\n21世纪科技发展迅猛，网络发达，技术革命使得成百上千年的历史文明悄然复苏。\r\n鲁特琴，对所有演奏古典吉他的同仁以及资深的古典乐迷来说，是一个既神秘又空白的概念。本栏目旨在让普罗大众了解这件乐器、喜欢这件乐器。来吧，亲爱的朋友们，和我一起走进鲁特琴的世界！","barTitle":"走进鲁特琴的世界","barColor":"#8f002e","teacherName":"陈谊","teacherAvatar":"http://ali-files.yooshow.com/2017/09/06/95da82d3-bcff-4ea7-be01-c8ac8134e7ad.jpg","passportId":0,"shareView":{"sharePic":"http://ali-files.yooshow.com/2017/09/06/95da82d3-bcff-4ea7-be01-c8ac8134e7ad.jpg","shareTitle":"陈谊走进鲁特琴的世界","shareUrl":"http://m.immedc.com/fenxiang/zhuanqu?id=20","shareContent":"点击了解专栏动态，专区资讯，获取名师课程。"}}
     */

    private boolean success;
    private String message;
    private String code;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 20
         * teacherId : 142
         * title : 走进鲁特琴的世界
         * image : http://ali-files.yooshow.com/2017/10/09/76cd8503-d146-4774-8078-d6f739fd5aa3.jpg
         * showIndex : 20
         * isQa : 0
         * qaPrice : 0.0
         * percentage : 70
         * ccomPercentage : 30
         * teacherPercentage : 0
         * introduce : 鲁特琴（Lute）也称琉特琴，是一种曲颈拨弦乐器，也是意大利的传统乐器，更是现今风行世界的乐器——吉他家族的祖先。鲁特琴是中世纪到巴洛克时期在欧洲使用的一类古乐器的总称，是文艺复兴时期欧洲最最风靡的家庭独奏乐器。在十六世纪和十七世纪，鲁特琴曾是欧洲最为流行的伴奏乐器之一。这种古老的乐器，其中长颈的长鲁特的历史至少可以推溯到公元前2000年，短颈的鲁特约公元前800年诞生。
         21世纪科技发展迅猛，网络发达，技术革命使得成百上千年的历史文明悄然复苏。
         鲁特琴，对所有演奏古典吉他的同仁以及资深的古典乐迷来说，是一个既神秘又空白的概念。本栏目旨在让普罗大众了解这件乐器、喜欢这件乐器。来吧，亲爱的朋友们，和我一起走进鲁特琴的世界！
         * barTitle : 走进鲁特琴的世界
         * barColor : #8f002e
         * teacherName : 陈谊
         * teacherAvatar : http://ali-files.yooshow.com/2017/09/06/95da82d3-bcff-4ea7-be01-c8ac8134e7ad.jpg
         * passportId : 0
         * shareView : {"sharePic":"http://ali-files.yooshow.com/2017/09/06/95da82d3-bcff-4ea7-be01-c8ac8134e7ad.jpg","shareTitle":"陈谊走进鲁特琴的世界","shareUrl":"http://m.immedc.com/fenxiang/zhuanqu?id=20","shareContent":"点击了解专栏动态，专区资讯，获取名师课程。"}
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
             * sharePic : http://ali-files.yooshow.com/2017/09/06/95da82d3-bcff-4ea7-be01-c8ac8134e7ad.jpg
             * shareTitle : 陈谊走进鲁特琴的世界
             * shareUrl : http://m.immedc.com/fenxiang/zhuanqu?id=20
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
}