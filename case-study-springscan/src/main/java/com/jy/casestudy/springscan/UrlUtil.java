package com.jy.casestudy.springscan;

import org.springframework.util.AntPathMatcher;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class UrlUtil {

    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static final AntPathMatcher matcher = new AntPathMatcher();

    public static boolean match(String pattern, String uri) {
        return matcher.match(pattern, uri);
    }
}
