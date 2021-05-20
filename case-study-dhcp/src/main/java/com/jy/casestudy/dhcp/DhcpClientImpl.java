package com.jy.casestudy.dhcp;

import com.jy.casestudy.dhcp.listener.DhcpEventListener;
import com.jy.casestudy.dhcp.model.DiscoverMessage;
import com.jy.casestudy.dhcp.model.OfferMessage;
import com.jy.casestudy.dhcp.protocol.DhcpMessageReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;

public class DhcpClientImpl implements DhcpClient {

    private static final Logger logger = LoggerFactory.getLogger(com.jy.casestudy.dhcp.DhcpClientImpl.class);

    private volatile ClientInfo clientInfo;

    /**
     * 寻找服务器
     */
    public void discover(DiscoverMessage discoverMessage) throws IOException {
        byte[] content = DhcpUtil.buildDiscoverBytes(discoverMessage);
        try(
            DatagramSocket ds = new DatagramSocket()
        ) {
            DatagramPacket dp = new DatagramPacket(content, content.length, InetAddress.getByName("255.255.255.255"), 67);
            ds.send(dp);
        }
    }

    /**
     * 请求使用
     */
    private void request() {

    }

    /**
     * 更新租约
     */
    private void updateIpLease() {

    }

    @Override
    public void start() throws IOException {
        DhcpMessageReceiver receiver = new DhcpMessageReceiver();
        DhcpEventListener offerMessageListener = new DhcpEventListener() {
            @Override
            public boolean careEvent(Object e) {
                return e instanceof OfferMessage;
            }

            @Override
            public void onEvent(Object e) {
                OfferMessage offerMessage = (OfferMessage)e;
                clientInfo = new ClientInfo();
                clientInfo.setIp(offerMessage.getClientIp());
                clientInfo.setDhcpServerIp(offerMessage.getDhcpServerIp());
                clientInfo.setRouter(offerMessage.getRouter());
                clientInfo.setSubnetMask(offerMessage.getSubnetMask());
                clientInfo.setDnsServerList(offerMessage.getDnsServerList());
                logger.info("{}", clientInfo);
            }
        };
        receiver.addEventListener(offerMessageListener);
        new Thread(receiver).start();
        DiscoverMessage discoverMessage = new DiscoverMessage();
        InetAddress ia = InetAddress.getLocalHost();
        discoverMessage.setMac(NetworkInterface.getByInetAddress(ia).getHardwareAddress());
        discover(discoverMessage);
    }

    @Override
    public void stop() {

    }

    @Override
    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public static void main(String[] args) throws IOException {
        DhcpClient client = new com.jy.casestudy.dhcp.DhcpClientImpl();
        client.start();
    }
}
