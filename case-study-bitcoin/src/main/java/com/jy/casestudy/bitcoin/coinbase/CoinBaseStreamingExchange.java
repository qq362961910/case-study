package com.jy.casestudy.bitcoin.coinbase;

import info.bitrich.xchangestream.core.ProductSubscription;
import info.bitrich.xchangestream.core.StreamingExchange;
import info.bitrich.xchangestream.core.StreamingMarketDataService;
import io.reactivex.Completable;
import io.reactivex.Observable;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.coinbasepro.CoinbaseProExchange;

import static info.bitrich.xchangestream.service.ConnectableService.BEFORE_CONNECTION_HANDLER;

/**
 * @author <a href="mailto:jian.yang@xman.com">研发部-用户中心组-杨建</a>
 * @version V1.0
 * @since 2020-07-11 12:20
 **/
public class CoinBaseStreamingExchange extends CoinbaseProExchange implements StreamingExchange {

    private static final String API_URI = "wss://ws-feed.pro.coinbase.com";
//    private static final String API_URI = "wss://ws-feed-public.sandbox.pro.coinbase.com";

    private final CoinBaseStreamingService streamingService;
    private CoinBaseStreamingMarketDataService streamingMarketDataService;

    public CoinBaseStreamingExchange() {
        this.streamingService = new CoinBaseStreamingService(API_URI);
    }

    @Override
    protected void initServices() {
        super.initServices();
        streamingService.setBeforeConnectionHandler(
            (Runnable)
                getExchangeSpecification()
                    .getExchangeSpecificParametersItem(BEFORE_CONNECTION_HANDLER));
        streamingMarketDataService = new CoinBaseStreamingMarketDataService(streamingService);
    }

    @Override
    public Completable connect(ProductSubscription... args) {
        return streamingService.connect();
    }

    @Override
    public Completable disconnect() {
        return streamingService.disconnect();
    }

    @Override
    public boolean isAlive() {
        return streamingService.isSocketOpen();
    }

    @Override
    public Observable<Throwable> reconnectFailure() {
        return streamingService.subscribeReconnectFailure();
    }

    @Override
    public Observable<Object> connectionSuccess() {
        return streamingService.subscribeConnectionSuccess();
    }

    @Override
    public ExchangeSpecification getDefaultExchangeSpecification() {
        ExchangeSpecification spec = super.getDefaultExchangeSpecification();
        spec.setShouldLoadRemoteMetaData(false);
        return spec;
    }

    @Override
    public StreamingMarketDataService getStreamingMarketDataService() {
        return streamingMarketDataService;
    }

    @Override
    public void useCompressedMessages(boolean compressedMessages) {
        streamingService.useCompressedMessages(compressedMessages);
    }
}
