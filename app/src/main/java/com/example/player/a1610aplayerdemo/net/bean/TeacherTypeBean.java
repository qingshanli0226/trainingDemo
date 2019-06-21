package com.example.player.a1610aplayerdemo.net.bean;

import java.util.List;

public class TeacherTypeBean {


    /**
     * success : true
     * message :
     * code : success
     * data : [{"id":36,"shortName":"音乐素养","firstCategoryId":2,"showIndex":2,"introduce":"音乐素养","image":"http://ali-files.yooshow.com/2016/12/21/0af91cf6-1fc2-49e1-a644-71b3546ff77b.png","searchKeys":"音乐素养","hide":1,"modifyDateStr":"2019-04-01 11:52:27"},{"id":37,"shortName":"合唱指挥","firstCategoryId":2,"showIndex":3,"introduce":"合唱指挥","image":"http://ali-files.yooshow.com/2016/12/21/ada11602-b1c8-4921-a342-b65da008b2d4.png","searchKeys":"合唱指挥","hide":1,"modifyDateStr":"2019-04-01 11:52:32"},{"id":38,"shortName":"三大教学法","firstCategoryId":2,"showIndex":4,"introduce":"三大教学法","image":"http://ali-files.yooshow.com/2016/12/21/82f3dcf3-100c-434b-8674-516960aaefb2.png","searchKeys":"三大教学法","hide":1,"modifyDateStr":"2019-04-01 11:52:36"}]
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
         * id : 36
         * shortName : 音乐素养
         * firstCategoryId : 2
         * showIndex : 2
         * introduce : 音乐素养
         * image : http://ali-files.yooshow.com/2016/12/21/0af91cf6-1fc2-49e1-a644-71b3546ff77b.png
         * searchKeys : 音乐素养
         * hide : 1
         * modifyDateStr : 2019-04-01 11:52:27
         */

        private int id;
        private String shortName;
        private int firstCategoryId;
        private int showIndex;
        private String introduce;
        private String image;
        private String searchKeys;
        private int hide;
        private String modifyDateStr;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getShortName() {
            return shortName;
        }

        public void setShortName(String shortName) {
            this.shortName = shortName;
        }

        public int getFirstCategoryId() {
            return firstCategoryId;
        }

        public void setFirstCategoryId(int firstCategoryId) {
            this.firstCategoryId = firstCategoryId;
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

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getSearchKeys() {
            return searchKeys;
        }

        public void setSearchKeys(String searchKeys) {
            this.searchKeys = searchKeys;
        }

        public int getHide() {
            return hide;
        }

        public void setHide(int hide) {
            this.hide = hide;
        }

        public String getModifyDateStr() {
            return modifyDateStr;
        }

        public void setModifyDateStr(String modifyDateStr) {
            this.modifyDateStr = modifyDateStr;
        }
    }
}
