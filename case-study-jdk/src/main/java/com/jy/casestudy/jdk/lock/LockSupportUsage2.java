package com.jy.casestudy.jdk.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport案例
 * 1. unpark调用时，如果当前线程还未进入park，则许可为true
 * 2. park调用时，判断许可是否为true，如果是true，则继续往下执行；如果是false，则等待，直到许可为true
 *
 * @author yj
 * @since 2020-04-29 21:16
 **/
public class LockSupportUsage2 {

    private static final Object u = new Object();
    private static ChangeObjectThread t1 = new ChangeObjectThread("t1");

    public static class ChangeObjectThread extends Thread {

        private ChangeObjectThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LockSupport.park();
                //调用两次会被阻塞
//                LockSupport.park();
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("被中断了");
                }
                System.out.println("继续执行");
            }
        }
    }

    public static void main(String[] args) {
        t1.start();
        LockSupport.unpark(t1);
        System.out.println("unpark invoked");
    }
}
