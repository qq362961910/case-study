package com.jy.casestudy.rxjava.test;

import com.jy.casestudy.rxjava.ConsumerUtil;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import org.junit.Test;

/**
 * @author yj
 * @since 2020-07-23 20:21
 **/
public class CreateObservableTest {

    @Test
    public void createByJust() {
        Observable<String> observable = Observable.just("abc");
        Disposable disposable = observable.subscribe(ConsumerUtil.createOutputConsumer(),
            Throwable::printStackTrace,
            () -> System.out.println("consume complete"));
        disposable.dispose();
    }

    @Test
    public void createFromArray() {
        Observable.fromArray(new String[]{"1", "2", "3"}).subscribe(ConsumerUtil.createOutputConsumer());


        String[] letters = {"a", "b", "c"};
        Observable<String> observable = Observable.fromArray(letters);
        Disposable disposable = observable.subscribe(ConsumerUtil.createOutputConsumer());
        disposable.dispose();
    }
}
