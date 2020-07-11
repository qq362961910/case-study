package com.jy.casestudy.bitcoin;

import com.jy.casestudy.bitcoin.coinbase.CoinBaseStreamingExchange;
import info.bitrich.xchangestream.core.StreamingExchange;
import info.bitrich.xchangestream.core.StreamingExchangeFactory;
import io.reactivex.disposables.Disposable;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.coinbasepro.CoinbaseProExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author <a href="mailto:jian.yang@xman.com">研发部-用户中心组-杨建</a>
 * @version V1.0
 * @since 2020-07-11 11:31
 **/
public class CoinBaseProCase {

    private static final Logger logger = LoggerFactory.getLogger(CoinBaseProCase.class);

    public static void main(String[] args) throws IOException, InterruptedException {
//        httpGetData();
        webSocketGetData();
//        Thread.currentThread().join();
    }

    public static void httpGetData() throws IOException {
        Exchange coinBasePro = ExchangeFactory.INSTANCE.createExchange(CoinbaseProExchange.class.getName());
        MarketDataService marketDataService = coinBasePro.getMarketDataService();
        Ticker ticker = marketDataService.getTicker(CurrencyPair.BTC_USD);
        logger.info("ticker: {}", ticker.toString());

        OrderBook orderBook = marketDataService.getOrderBook(CurrencyPair.BTC_USD);
        logger.info("order book: {}", orderBook);
        System.out.println();

        Trades trades = marketDataService.getTrades(CurrencyPair.BTC_USD);
        logger.info("trade: {}", trades);
    }

    public static void webSocketGetData() throws InterruptedException {
        // Use StreamingExchangeFactory instead of ExchangeFactory
        StreamingExchange exchange = StreamingExchangeFactory.INSTANCE.createExchange(CoinBaseStreamingExchange.class.getName());

        // Connect to the Exchange WebSocket API. Here we use a blocking wait.
        exchange.connect().blockingAwait();

        // Subscribe to live trades update.
        Disposable subscription = exchange.getStreamingMarketDataService()
            .getTrades(CurrencyPair.BTC_USD)
            .subscribe(
                trade -> logger.info("Trade: {}", trade),
                throwable -> logger.error("Error in trade subscription", throwable));

        // Wait for a while to see some results arrive
        Thread.sleep(200000000);

        // Unsubscribe
        subscription.dispose();

        // Disconnect from exchange (blocking again)
        exchange.disconnect().blockingAwait();
    }
}
