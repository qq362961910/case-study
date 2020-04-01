package com.jy.casestudy.jdk.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockUsage {

    public static void main(String[] args) {
        //读写锁
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        //获取读锁
        readWriteLock.readLock().lock();
        try {
            //.....logic code
        } finally {
            readWriteLock.readLock().unlock();
        }


    }
}
