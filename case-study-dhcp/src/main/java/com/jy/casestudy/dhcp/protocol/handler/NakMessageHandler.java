package com.jy.casestudy.dhcp.protocol.handler;

import cn.t.util.common.StringUtil;
import com.jy.casestudy.dhcp.model.NakMessage;
import com.jy.casestudy.dhcp.protocol.DhcpMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yj
 * @since 2020-01-05 17:29
 **/
public class NakMessageHandler implements DhcpMessageHandler {

    private static final Logger logger = LoggerFactory.getLogger(NakMessageHandler.class);

    @Override
    public boolean support(Object message) {
        return message instanceof NakMessage;
    }

    @Override
    public void handle(Object message) {
        NakMessage nakMessage = (NakMessage)message;
        if(!StringUtil.isEmpty(nakMessage.getMessage())) {
            logger.info("dhcp server response msg: {}", nakMessage.getMessage());
        }
    }
}
