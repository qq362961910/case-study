package com.jy.casestudy.rxjava.test;

import com.jy.casestudy.rxjava.ConsumerUtil;
import com.jy.casestudy.rxjava.ObservableUtil;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author yj
 * @since 2020-07-23 20:32
 **/
public class MapObservableTest {

    @Test
    public void mapTest() {
        String[] letters = {"a", "b", "c"};
        Observable<String> observable = Observable.fromArray(letters);
        Disposable disposable = observable.map(String::toUpperCase)
        .subscribe(ConsumerUtil.createOutputConsumer());
        disposable.dispose();
    }

    @Test
    public void flatMapTest() {
        Observable<String> observable = Observable.fromArray("abc", "def");
        Disposable disposable = observable.flatMap(ObservableUtil::flatStrToChar)
            .subscribe(ConsumerUtil.createOutputConsumer());
        disposable.dispose();
    }

    @Test
    public void flatMapVsFlatMapIte() {
        Observable<List<String>> observable = Observable.just(
            Arrays.asList("1", "2", "3"),
            Arrays.asList("4", "5", "6"),
            Arrays.asList("7", "8", "9")
        );
        Disposable disposable = observable
            .flatMap(Observable::fromIterable)
            .subscribe(ConsumerUtil.createOutputConsumer());
        disposable.dispose();

        System.out.println("==========================================================");

        List<String> stringList = Arrays.asList("123","456", "789", "000");
        Disposable disposableFlatMapIterable = Observable
            .fromIterable(stringList)
            .flatMapIterable(str -> Arrays.asList(str.split("")))
            .subscribe(ConsumerUtil.createOutputConsumer());

        disposableFlatMapIterable.dispose();
    }

}
