package com.jy.casestudy.dhcp.builder;

import cn.t.util.common.RegexUtil;
import cn.t.util.common.StringUtil;
import com.jy.casestudy.dhcp.model.DiscoverMessage;

/**
 * @author yj
 * @since 2020-01-11 15:31
 **/
public class DefaultDiscoverMessageBuilderImpl implements DiscoverMessageBuilder {

    private byte[] mac;

    private String staticIp;

    @Override
    public DiscoverMessageBuilder setMac(byte[] mac) {
        this.mac = mac;
        return this;
    }

    @Override
    public DiscoverMessageBuilder setStaticIp(String ip) {
        if(!RegexUtil.isIp(ip)) {
            throw new RuntimeException("ip格式不正确");
        }
        this.staticIp = ip;
        return this;
    }

    public DiscoverMessage build() {
        DiscoverMessage discoverMessage = new DiscoverMessage();
        discoverMessage.setMac(mac);
        if(!StringUtil.isEmpty(staticIp)) {
            String[] ipParts = staticIp.trim().split("\\.");
            byte[] ipBytes = new byte[4];
            for(byte i=0; i<4; i++) {
                ipBytes[i] = (byte)Integer.parseInt(ipParts[i]);
            }
            discoverMessage.setExpectIp(ipBytes);
        }
        return discoverMessage;
    }
}
