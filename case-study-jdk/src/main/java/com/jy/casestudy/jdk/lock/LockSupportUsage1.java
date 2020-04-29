package com.jy.casestudy.jdk.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport案例
 *
 * 1. park不需要获取某个对象的锁
 * 2. 因为中断的时候park不会抛出InterruptedException异常，所以需要在park之后自行判断中断状态，然后做额外的处理
 *
 * @author yj
 * @since 2020-04-29 20:10
 **/
public class LockSupportUsage1 {

    private static final Object u = new Object();
    private static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    private static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread {
        private ChangeObjectThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                LockSupport.park();
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("被中断了");
                }
                System.out.println("继续执行");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(1000L);
        t2.start();
        Thread.sleep(3000L);
        t1.interrupt();
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }
}
