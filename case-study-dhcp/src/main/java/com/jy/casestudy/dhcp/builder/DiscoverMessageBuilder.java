package com.jy.casestudy.dhcp.builder;

import com.jy.casestudy.dhcp.model.DiscoverMessage;

public interface DiscoverMessageBuilder {
    DiscoverMessageBuilder setMac(byte[] mac);
    DiscoverMessageBuilder setStaticIp(String ip);
    DiscoverMessage build();
}
