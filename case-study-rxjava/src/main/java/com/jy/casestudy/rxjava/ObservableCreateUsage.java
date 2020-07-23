package com.jy.casestudy.rxjava;


import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author yj
 * @since 2020-07-22 20:16
 **/
public class ObservableCreateUsage {

    public static void main(String[] args) {
        Disposable disposable = createByJust().subscribe(createOutputConsumer());
        disposable.dispose();
    }

    public static <T> Consumer<T> createOutputConsumer() {
        return System.out::println;
    }

    public static Observable<String> createByJust() {
        String[] letters = {"a", "b", "c"};
        return Observable.fromArray(letters);
    }
}
