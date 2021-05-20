package com.jy.casestudy.dhcp;

import com.jy.casestudy.dhcp.model.DiscoverMessage;
import com.jy.casestudy.dhcp.protocol.DhcpMessageDecoder;
import com.jy.casestudy.dhcp.protocol.DhcpMessageEncoder;

import java.nio.ByteBuffer;

/**
 * dhcp工具
 *
 * @author yj
 * @since 2020-01-11 14:29
 **/
public class DhcpUtil {

    private static final DhcpMessageEncoder encoder = new DhcpMessageEncoder();
    private static final DhcpMessageDecoder decoder = new DhcpMessageDecoder();

    /**
     * discover
     * */
    public static byte[] buildDiscoverBytes(DiscoverMessage message) {
        return encoder.encode(message);
    }

    /**
     * decode
     * */
    public static Object decode(ByteBuffer buffer) {
        return decoder.decode(buffer);
    }
}
