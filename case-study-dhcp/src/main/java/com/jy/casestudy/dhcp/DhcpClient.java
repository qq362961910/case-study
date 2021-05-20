package com.jy.casestudy.dhcp;

import java.io.IOException;

public interface DhcpClient {

    /**
     * 启动
     */
    void start() throws IOException;

    /**
     * 停止
     */
    void stop();

    /**
     * 获取客户端信息
     */
    ClientInfo getClientInfo();
}
