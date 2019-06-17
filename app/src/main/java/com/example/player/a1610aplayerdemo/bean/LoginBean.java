package com.example.player.a1610aplayerdemo.bean;

public class LoginBean {
    /**
     * success : true
     * message :
     * code : success
     * data : {"name":"18251513369","avatar":"http://ali-files.yooshow.com/app/yangyin/default.png","score":0,"ranking":0,"money":0,"workCount":0,"purchaseCount":0,"courseCount":0,"questionCount":0,"isShowQuestion":0,"purchaseAllCount":0,"shareView":{"sharePic":"http://ali-files.yooshow.com/app/yangyin/default-red-share.png","shareTitle":"【央音在线】中央音乐学院官方平台","shareUrl":"http://api.immedc.com/restapi/app/download","shareContent":"名校教育，名师领航，为您提供一站无忧式音乐教学服务。"}}
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
         * name : 18251513369
         * avatar : http://ali-files.yooshow.com/app/yangyin/default.png
         * score : 0
         * ranking : 0
         * money : 0.0
         * workCount : 0
         * purchaseCount : 0
         * courseCount : 0
         * questionCount : 0
         * isShowQuestion : 0
         * purchaseAllCount : 0
         * shareView : {"sharePic":"http://ali-files.yooshow.com/app/yangyin/default-red-share.png","shareTitle":"【央音在线】中央音乐学院官方平台","shareUrl":"http://api.immedc.com/restapi/app/download","shareContent":"名校教育，名师领航，为您提供一站无忧式音乐教学服务。"}
         */

        private String name;
        private String avatar;
        private int score;
        private int ranking;
        private double money;
        private int workCount;
        private int purchaseCount;
        private int courseCount;
        private int questionCount;
        private int isShowQuestion;
        private int purchaseAllCount;
        private ShareViewBean shareView;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getRanking() {
            return ranking;
        }

        public void setRanking(int ranking) {
            this.ranking = ranking;
        }

        public double getMoney() {
            return money;
        }

        public void setMoney(double money) {
            this.money = money;
        }

        public int getWorkCount() {
            return workCount;
        }

        public void setWorkCount(int workCount) {
            this.workCount = workCount;
        }

        public int getPurchaseCount() {
            return purchaseCount;
        }

        public void setPurchaseCount(int purchaseCount) {
            this.purchaseCount = purchaseCount;
        }

        public int getCourseCount() {
            return courseCount;
        }

        public void setCourseCount(int courseCount) {
            this.courseCount = courseCount;
        }

        public int getQuestionCount() {
            return questionCount;
        }

        public void setQuestionCount(int questionCount) {
            this.questionCount = questionCount;
        }

        public int getIsShowQuestion() {
            return isShowQuestion;
        }

        public void setIsShowQuestion(int isShowQuestion) {
            this.isShowQuestion = isShowQuestion;
        }

        public int getPurchaseAllCount() {
            return purchaseAllCount;
        }

        public void setPurchaseAllCount(int purchaseAllCount) {
            this.purchaseAllCount = purchaseAllCount;
        }

        public ShareViewBean getShareView() {
            return shareView;
        }

        public void setShareView(ShareViewBean shareView) {
            this.shareView = shareView;
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
}
