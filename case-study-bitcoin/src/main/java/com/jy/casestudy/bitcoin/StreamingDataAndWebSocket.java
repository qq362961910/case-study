package com.jy.casestudy.bitcoin;

import info.bitrich.xchangestream.bitstamp.v2.BitstampStreamingExchange;
import info.bitrich.xchangestream.core.StreamingExchange;
import info.bitrich.xchangestream.core.StreamingExchangeFactory;
import io.reactivex.disposables.Disposable;
import org.knowm.xchange.currency.CurrencyPair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:jian.yang@xman.com">研发部-用户中心组-杨建</a>
 * @version V1.0
 * @since 2020-07-10 12:19
 **/
public class StreamingDataAndWebSocket {

    private static final Logger logger = LoggerFactory.getLogger(StreamingDataAndWebSocket.class);

    public static void main(String[] args) throws InterruptedException {
       // Use StreamingExchangeFactory instead of ExchangeFactory
        StreamingExchange exchange = StreamingExchangeFactory.INSTANCE.createExchange(BitstampStreamingExchange.class.getName());

       // Connect to the Exchange WebSocket API. Here we use a blocking wait.
        exchange.connect().blockingAwait();

       // Subscribe to live trades update.
        Disposable subscription1 = exchange.getStreamingMarketDataService()
            .getTrades(CurrencyPair.BTC_USD)
            .subscribe(
                trade -> logger.info("Trade: {}", trade),
                throwable -> logger.error("Error in trade subscription", throwable));

       // Subscribe order book data with the reference to the subscription.
        Disposable subscription2 = exchange.getStreamingMarketDataService()
            .getOrderBook(CurrencyPair.BTC_USD)
            .subscribe(orderBook -> logger.info("Order book: {}", orderBook));

        // Wait for a while to see some results arrive
        Thread.sleep(20000);

        // Unsubscribe
        subscription1.dispose();
        subscription2.dispose();

        // Disconnect from exchange (blocking again)
        exchange.disconnect().blockingAwait();
    }
}
