package com.example.player.a1610aplayerdemo.fragment.selectclass.zl.zlvideoactivity.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class ZlvideoBean {
    /**
     * success : true
     * message :
     * code : success
     * data : [{"id":129,"zlId":20,"title":"鲁特琴演奏作品集","image":"http://ali-files.yooshow.com/2018/07/10/d1b1fe1b-6c72-41da-a0d3-d4cdd537657b.png","introduce":"鲁特琴演奏作品集","url":"1","type":2,"dataId":283,"showIndex":1,"layout":1,"price":0,"courseIsBuy":false,"liveIsBuy":false,"reservation":false,"liveStatus":0}]
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

    public static class DataBean implements Parcelable {
        /**
         * id : 129
         * zlId : 20
         * title : 鲁特琴演奏作品集
         * image : http://ali-files.yooshow.com/2018/07/10/d1b1fe1b-6c72-41da-a0d3-d4cdd537657b.png
         * introduce : 鲁特琴演奏作品集
         * url : 1
         * type : 2
         * dataId : 283
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

        protected DataBean(Parcel in) {
            id = in.readInt();
            zlId = in.readInt();
            title = in.readString();
            image = in.readString();
            introduce = in.readString();
            url = in.readString();
            type = in.readInt();
            dataId = in.readInt();
            showIndex = in.readInt();
            layout = in.readInt();
            price = in.readDouble();
            courseIsBuy = in.readByte() != 0;
            liveIsBuy = in.readByte() != 0;
            reservation = in.readByte() != 0;
            liveStatus = in.readInt();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(id);
            parcel.writeInt(zlId);
            parcel.writeString(title);
            parcel.writeString(image);
            parcel.writeString(introduce);
            parcel.writeString(url);
            parcel.writeInt(type);
            parcel.writeInt(dataId);
            parcel.writeInt(showIndex);
            parcel.writeInt(layout);
            parcel.writeDouble(price);
            parcel.writeByte((byte) (courseIsBuy ? 1 : 0));
            parcel.writeByte((byte) (liveIsBuy ? 1 : 0));
            parcel.writeByte((byte) (reservation ? 1 : 0));
            parcel.writeInt(liveStatus);
        }
    }
}
