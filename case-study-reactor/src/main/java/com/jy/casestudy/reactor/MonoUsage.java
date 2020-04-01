package com.jy.casestudy.reactor;

import reactor.core.publisher.Mono;

public class MonoUsage {

    public static void main(String[] args) {
        Mono.fromSupplier(() -> "hello").subscribe(System.out::println);
    }

}
