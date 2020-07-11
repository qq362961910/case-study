package com.jy.casestudy.bitcoin.coinbase;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * @author <a href="mailto:jian.yang@xman.com">研发部-用户中心组-杨建</a>
 * @version V1.0
 * @since 2020-07-11 19:01
 **/
public class CoinBaseWebSocketSubscriptionMessage {

    @JsonProperty("type")
    private String type;
    @JsonProperty("channels")
    private String[] channels;
    @JsonProperty("product_ids")
    private String[] productIds;

    public CoinBaseWebSocketSubscriptionMessage(String type, String[] channels, String[] productIds) {
        this.type = type;
        this.channels = channels;
        this.productIds = productIds;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getChannels() {
        return channels;
    }

    public void setChannels(String[] channels) {
        this.channels = channels;
    }

    public String[] getProductIds() {
        return productIds;
    }

    public void setProductIds(String[] productIds) {
        this.productIds = productIds;
    }

    @Override
    public String toString() {
        return "CoinBaseWebSocketSubscriptionMessage{" +
            "type='" + type + '\'' +
            ", channels=" + Arrays.toString(channels) +
            ", productIds=" + Arrays.toString(productIds) +
            '}';
    }
}
