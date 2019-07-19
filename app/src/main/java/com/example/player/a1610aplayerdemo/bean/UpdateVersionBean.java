package com.example.player.a1610aplayerdemo.bean;

public class UpdateVersionBean {

    /**
     * versionCode : 43
     * versionName : 3.3.1
     * description : - 记录观看时间功能优化
     - 修复了已知问题，优化了一些用户体验
     * downloadUrl : http://dwl.immedc.com/apk/yangyinonline_v3.3.1_20190605_guoyun_release.apk
     * forceUpdate : false
     */

    private int versionCode;
    private String versionName;
    private String description;
    private String downloadUrl;
    private boolean forceUpdate;

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public boolean isForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(boolean forceUpdate) {
        this.forceUpdate = forceUpdate;
    }
}
