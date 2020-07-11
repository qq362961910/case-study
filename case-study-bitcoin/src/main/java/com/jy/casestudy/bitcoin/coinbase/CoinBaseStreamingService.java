package com.jy.casestudy.bitcoin.coinbase;

import com.fasterxml.jackson.databind.JsonNode;
import info.bitrich.xchangestream.bitstamp.v2.dto.BitstampWebSocketData;
import info.bitrich.xchangestream.bitstamp.v2.dto.BitstampWebSocketSubscriptionMessage;
import info.bitrich.xchangestream.service.netty.JsonNettyStreamingService;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtensionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author <a href="mailto:jian.yang@xman.com">研发部-用户中心组-杨建</a>
 * @version V1.0
 * @since 2020-07-11 12:26
 **/
public class CoinBaseStreamingService extends JsonNettyStreamingService {
    private static final Logger LOG = LoggerFactory.getLogger(CoinBaseStreamingService.class);

    private static final String JSON_CHANNEL = "channel";
    private static final String JSON_EVENT = "event";
    private static final String JSON_TYPE = "type";

    public static final String EVENT_ORDERBOOK = "data";
    public static final String EVENT_TRADE = "trade";
    private static final String EVENT_SUBSCRIPTION_SUCCEEDED = "base-coin:subscription_succeeded";
    private static final String EVENT_UNSUBSCRIPTION_SUCCEEDED = "base-coin:unsubscription_succeeded";

    public CoinBaseStreamingService(String apiUrl) {
        super(apiUrl, Integer.MAX_VALUE);
    }

    @Override
    protected WebSocketClientExtensionHandler getWebSocketClientExtensionHandler() {
        return null;
    }

    @Override
    protected String getChannelNameFromMessage(JsonNode message) throws IOException {
        JsonNode jsonNode = message.get(JSON_CHANNEL);
        if (jsonNode != null) {
            return jsonNode.asText();
        }
        throw new IOException("Channel name can't be evaluated from message");
    }

    @Override
    protected void handleMessage(JsonNode message) {
        System.out.println(message);
    }

//    @Override
//    protected void handleMessage(JsonNode message) {
//        JsonNode channelJsonNode = message.get(JSON_CHANNEL);
//        JsonNode eventJsonNode = message.get(JSON_EVENT);
//
//        if (channelJsonNode == null || eventJsonNode == null) {
//            LOG.error(
//                "Received JSON message does not contain {} and {} fields. Skipped...",
//                JSON_CHANNEL,
//                JSON_EVENT);
//            return;
//        }
//
//        String channel = channelJsonNode.asText();
//        String event = eventJsonNode.asText();
//
//        switch (event) {
//            case EVENT_ORDERBOOK:
//            case EVENT_TRADE:
//                if (!channels.containsKey(channel)) {
//                    LOG.warn(
//                        "The message has been received from disconnected channel '{}'. Skipped.", channel);
//                    return;
//                }
//                super.handleMessage(message);
//                break;
//            case EVENT_SUBSCRIPTION_SUCCEEDED:
//                LOG.info("Channel {} has been successfully subscribed", channel);
//                break;
//            case EVENT_UNSUBSCRIPTION_SUCCEEDED:
//                LOG.info("Channel {} has been successfully unsubscribed", channel);
//                break;
//            default:
//                LOG.warn("Unsupported event type {} in message {}", event, message.toString());
//        }
//    }

    @Override
    public String getSubscribeMessage(String channelName, Object... args) throws IOException {
        BitstampWebSocketSubscriptionMessage subscribeMessage =
            generateSubscribeMessage(channelName, "bts:subscribe");
        return objectMapper.writeValueAsString(subscribeMessage);
    }

    @Override
    public String getUnsubscribeMessage(String channelName) throws IOException {
        BitstampWebSocketSubscriptionMessage subscribeMessage =
            generateSubscribeMessage(channelName, "bts:unsubscribe");
        return objectMapper.writeValueAsString(subscribeMessage);
    }

    private BitstampWebSocketSubscriptionMessage generateSubscribeMessage(
        String channelName, String channel) {
        return new BitstampWebSocketSubscriptionMessage(
            channel, new BitstampWebSocketData(channelName));
    }
}
