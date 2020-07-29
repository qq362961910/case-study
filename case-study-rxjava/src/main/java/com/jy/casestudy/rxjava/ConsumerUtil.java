package com.jy.casestudy.rxjava;

import io.reactivex.functions.Consumer;

/**
 * @author yj
 * @since 2020-07-23 20:21
 **/
public class ConsumerUtil {
    public static <T> Consumer<T> createOutputConsumer() {
        return System.out::println;
    }
}
