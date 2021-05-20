package com.jy.casestudy.weixin.configure;


import java.io.InputStream;

public class WxConfigure {

    private String appID;

    private String key;

    private String mchID;

    private InputStream certStream;

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMchID() {
        return mchID;
    }

    public void setMchID(String mchID) {
        this.mchID = mchID;
    }

    public InputStream getCertStream() {
        return certStream;
    }

    public void setCertStream(InputStream certStream) {
        this.certStream = certStream;
    }
}
