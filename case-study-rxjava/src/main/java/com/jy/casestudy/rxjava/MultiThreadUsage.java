package com.jy.casestudy.rxjava;

import cn.t.util.common.RandomUtil;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MultiThreadUsage {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main: " + Thread.currentThread().getName());
        Observable<Integer> observable = Observable.create(emitter -> {
            System.out.println("observable: " + Thread.currentThread().getName());
            int index = 0;
            while (true) {
                Thread.sleep(RandomUtil.randomInt(100, 1000));
                emitter.onNext(index++);
            }
        });
        observable = observable.share()
            .observeOn(Schedulers.computation())
        .subscribeOn(Schedulers.io());

        Consumer<Integer> consumer = o -> {
            System.out.println("consume thread: " + Thread.currentThread().getName() + ", data: " + o);
        };
        Disposable disposable1 = observable.subscribe(consumer);
        Thread.currentThread().join();

        disposable1.dispose();
    }
}
