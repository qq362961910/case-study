package com.jy.casestudy.dhcp.listener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yj
 * @since 2020-01-15 21:13
 **/
public class EventBroadcaster {
    private final List<DhcpEventListener> dhcpEventListenerList = new ArrayList<>();
    public void broadcast(Object event) {
        if(event != null) {
            for(DhcpEventListener listener: dhcpEventListenerList) {
                if(listener.careEvent(event)) {
                    listener.onEvent(event);
                }
            }
        }
    }
    public void addEventListener(DhcpEventListener listener) {
        if(listener != null) {
            dhcpEventListenerList.add(listener);
        }
    }

    public static void main(String[] args) {
        System.out.println((byte)-61 & 0xFF);
    }
}
