package com.jy.casestudy.dhcp.listener;

/**
 * dhcp事件
 *
 * @author yj
 * @since 2020-01-15 20:59
 **/
public interface DhcpEventListener {
    boolean careEvent(Object e);
    void onEvent(Object e);
}
