package com.jy.casestudy.rxjava.test;

import com.jy.casestudy.rxjava.ConsumerUtil;
import com.jy.casestudy.rxjava.ObservableUtil;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import org.junit.Test;

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
}
