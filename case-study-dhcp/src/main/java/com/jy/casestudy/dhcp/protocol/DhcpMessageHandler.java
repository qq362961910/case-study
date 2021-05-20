package com.jy.casestudy.dhcp.protocol;

import java.io.IOException;

public interface DhcpMessageHandler {
    boolean support(Object message);
    void handle(Object message) throws IOException;
}
