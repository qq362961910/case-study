package com.jy.casestudy.rxjava.test;

import com.jy.casestudy.rxjava.ConsumerUtil;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ShareOperateTest {

    @Test
    public void shareTest() throws InterruptedException {

        List<String> stringList = Arrays.asList("1", "2", "3", "4", "5");
        Observable<String> observable = Observable.fromIterable(stringList);
        Observable<String> share1 = observable.share();
        Observable<String> share2 = observable.share();
        Observable<String> share3 = observable.share();

        Disposable disposable1 = share1.subscribe();
        Disposable disposable2 = share2.subscribe();
        Disposable disposable3 = share3.subscribe(ConsumerUtil.createOutputConsumer());

        Thread.currentThread().join();

        disposable1.dispose();
        disposable2.dispose();
        disposable3.dispose();
    }

}
