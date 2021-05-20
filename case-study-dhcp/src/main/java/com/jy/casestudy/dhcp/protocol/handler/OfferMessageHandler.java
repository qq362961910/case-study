package com.jy.casestudy.dhcp.protocol.handler;

import com.jy.casestudy.dhcp.listener.EventBroadcaster;
import com.jy.casestudy.dhcp.model.OfferMessage;
import com.jy.casestudy.dhcp.protocol.DhcpMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yj
 * @since 2020-01-05 17:29
 **/
public class OfferMessageHandler implements DhcpMessageHandler {

    private static final Logger logger = LoggerFactory.getLogger(OfferMessageHandler.class);

    private EventBroadcaster eventBroadcaster;

    @Override
    public boolean support(Object message) {
        return message instanceof OfferMessage;
    }

    @Override
    public void handle(Object message) {
        OfferMessage offerMessage = (OfferMessage)message;
        logger.info("offer msg detail: {}", offerMessage);
        eventBroadcaster.broadcast(offerMessage);
    }

    public OfferMessageHandler(EventBroadcaster eventBroadcaster) {
        this.eventBroadcaster = eventBroadcaster;
    }
}
