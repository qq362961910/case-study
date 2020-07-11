package com.jy.casestudy.bitcoin;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.bitstamp.BitstampExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.service.marketdata.MarketDataService;

import java.io.IOException;

/**
 * @author <a href="mailto:jian.yang@xman.com">研发部-用户中心组-杨建</a>
 * @version V1.0
 * @since 2020-07-10 12:05
 **/
public class PublicMarketDataCase {
    public static void main(String[] args) throws IOException {
        Exchange bitStamp = ExchangeFactory.INSTANCE.createExchange(BitstampExchange.class.getName());
        MarketDataService marketDataService = bitStamp.getMarketDataService();
        Ticker ticker = marketDataService.getTicker(CurrencyPair.BTC_USD);
        System.out.println("ticker: " + ticker.toString());

        OrderBook orderBook = marketDataService.getOrderBook(CurrencyPair.BTC_USD);
        System.out.println("order book: " + orderBook);

        Trades trades = marketDataService.getTrades(CurrencyPair.BTC_USD);
        System.out.println("trade: " + trades);
    }
}
