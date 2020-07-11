package com.jy.casestudy.bitcoin.coinbase;

/**
 * @author <a href="mailto:jian.yang@xman.com">研发部-用户中心组-杨建</a>
 * @version V1.0
 * @since 2020-07-11 19:01
 **/
public class CoinBaseWebSocketSubscriptionMessage {

    private String type = "subscribe";
    private Channel[] channels;

    public CoinBaseWebSocketSubscriptionMessage(String... channelStrings) {
        if(channelStrings != null && channelStrings.length > 0) {
            Channel[] channels = new Channel[channelStrings.length];
            for(int i=0; i<channelStrings.length; i++) {
                channels[i] = new Channel(channelStrings[i]);
            }
            this.channels = channels;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Channel[] getChannels() {
        return channels;
    }

    public void setChannels(Channel[] channels) {
        this.channels = channels;
    }

    public static class Channel {

        private String name;

        public Channel(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
