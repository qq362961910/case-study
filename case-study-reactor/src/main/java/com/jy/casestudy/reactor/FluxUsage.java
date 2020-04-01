package com.jy.casestudy.reactor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FluxUsage {

    private static final Logger logger = LoggerFactory.getLogger(FluxUsage.class);

    public static void main(String[] args) {
        mapTest();
//        flatMapTest();
    }


    private static void mapTest() {
        Flux.just(1, 2, 3, 4)
            .log()
            .map(i -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return i * 2;
            })
            .subscribe(e -> logger.info("get:{}", e));

    }
    private static void flatMapTest() throws InterruptedException {
        Flux.just(1,2,3,4)
            .log()
            .flatMap(e -> Flux.just(e*2).delayElements(Duration.ofSeconds(1)))
            .subscribe(e -> logger.info("get:{}",e));
        TimeUnit.SECONDS.sleep(10);
    }

}
