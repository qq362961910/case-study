package com.jy.casestudy.rxjava;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author yj
 * @since 2020-07-23 20:39
 **/
public class ObservableUtil {

    public static Observable<Character> flatStrToChar(String source) {
        char[] chars = source.toCharArray();
        Arrays.stream(chars)
        Character.

        return Observable.fromArray(source.toCharArray());
    }
}
