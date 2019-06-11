package com.example.player.a1610aplayerdemo.bean;

/**
 * Created by Lmz on 2019/06/11
 *   引导页Bean
 */
public class SplashBean {

    /**
     * success : true
     * message :
     * code : success
     * data : {"id":25,"channel":"1","bannerUrl":"http://ali-files.yooshow.com/2019/03/20/ecccd992-f2a7-4d33-a414-5348c34d28ab.png","bannerType":2,"relationInfo":"197"}
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
         * id : 25
         * channel : 1
         * bannerUrl : http://ali-files.yooshow.com/2019/03/20/ecccd992-f2a7-4d33-a414-5348c34d28ab.png
         * bannerType : 2
         * relationInfo : 197
         */

        private int id;
        private String channel;
        private String bannerUrl;
        private int bannerType;
        private String relationInfo;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getBannerUrl() {
            return bannerUrl;
        }

        public void setBannerUrl(String bannerUrl) {
            this.bannerUrl = bannerUrl;
        }

        public int getBannerType() {
            return bannerType;
        }

        public void setBannerType(int bannerType) {
            this.bannerType = bannerType;
        }

        public String getRelationInfo() {
            return relationInfo;
        }

        public void setRelationInfo(String relationInfo) {
            this.relationInfo = relationInfo;
        }
    }
}
