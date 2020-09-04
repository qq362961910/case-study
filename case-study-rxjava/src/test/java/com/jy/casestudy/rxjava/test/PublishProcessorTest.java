package com.jy.casestudy.rxjava.test;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.processors.PublishProcessor;

public class PublishProcessorTest {

    public final static PublishProcessor<String> publishProcessor = PublishProcessor.create();

    public static void main(String[] args) throws InterruptedException {
        Thread producer = new Thread(() -> {
            for(int i=0; i<10; i++) {
                publishProcessor.onNext(String.valueOf(i));
                try { Thread.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        });
        Observable<String> observable1 = publishProcessor.toObservable();
        Disposable disposable1 = observable1.subscribe(str -> {
            System.out.println("consume1 : " + str);
        });

        Observable<String> observable2 = publishProcessor.toObservable();
        Disposable disposable2 = observable2.subscribe(str -> {
            System.out.println("consume2 : " + str);
        });
        producer.start();
        Thread.currentThread().join();
        disposable1.dispose();
        disposable2.dispose();
    }


}
