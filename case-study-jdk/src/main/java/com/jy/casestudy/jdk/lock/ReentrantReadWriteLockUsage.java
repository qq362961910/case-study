package com.jy.casestudy.jdk.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockUsage {

    private static int index = 0;
    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        readWriteLock.readLock().lock();
        try {
            index ++;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
