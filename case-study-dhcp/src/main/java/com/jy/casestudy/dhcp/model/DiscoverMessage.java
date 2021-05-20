package com.jy.casestudy.dhcp.model;

/**
 * discover
 *
 * @author yj
 * @since 2020-01-05 15:32
 **/
public class DiscoverMessage {

    /**
     * mac地址
     * */
    private byte[] mac;

    /**
     * 期待IP
     * */
    private byte[] expectIp;


    public static DiscoverMessage newInstance() {
        return new DiscoverMessage();
    }

    public byte[] getMac() {
        return mac;
    }

    public void setMac(byte[] mac) {
        this.mac = mac;
    }

    public byte[] getExpectIp() {
        return expectIp;
    }

    public void setExpectIp(byte[] expectIp) {
        this.expectIp = expectIp;
    }

}
