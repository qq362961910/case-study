package com.jy.casestudy.dhcp.protocol;

import com.jy.casestudy.dhcp.DhcpUtil;
import com.jy.casestudy.dhcp.listener.DhcpEventListener;
import com.jy.casestudy.dhcp.listener.EventBroadcaster;
import com.jy.casestudy.dhcp.protocol.handler.NakMessageHandler;
import com.jy.casestudy.dhcp.protocol.handler.OfferMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yj
 * @since 2020-01-05 17:23
 **/
public class DhcpMessageReceiver implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(DhcpMessageReceiver.class);
    private final EventBroadcaster eventBroadcaster = new EventBroadcaster();
    private final List<DhcpMessageHandler> handlerList = new ArrayList<>();

    public void handle(Object message) throws IOException {
        DhcpMessageHandler handler = selectDhcpMessageHandler(message);
        if(handler != null) {
            logger.info("handler: {} handle message: {}", handler, message);
            handler.handle(message);
        } else {
            logger.warn("未找到消息处理器, msg: {}", message);
        }
    }

    @Override
    public void run() {
        try {
            //MTU一般都是1500bytes，DhcpMessageEncoder#encode()方法中设置OptionType.DHCP_MAX_MSG_SIZE一致
            byte[] buf = new byte[1500];
            DatagramSocket datagramSocket = new DatagramSocket(68);
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            while (true) {
                datagramSocket.receive(packet);
                ByteBuffer buffer = ByteBuffer.wrap(buf, 0, packet.getLength());
                Object message = DhcpUtil.decode(buffer);
                if(message != null) {
                    handle(message);
                } else {
                    logger.info("解码器未解析出任何消息");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("消息监听器退出");
    }

    private DhcpMessageHandler selectDhcpMessageHandler(Object msg) {
        for(DhcpMessageHandler handler: handlerList) {
            if(handler.support(msg)) {
                return handler;
            }
        }
        return null;
    }

    public DhcpMessageReceiver() {
        handlerList.add(new OfferMessageHandler(eventBroadcaster));
        handlerList.add(new NakMessageHandler());
    }

    public void addEventListener(DhcpEventListener listener) {
        eventBroadcaster.addEventListener(listener);
    }
}
