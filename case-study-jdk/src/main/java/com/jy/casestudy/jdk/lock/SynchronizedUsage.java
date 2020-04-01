package com.jy.casestudy.jdk.lock;

public class SynchronizedUsage {
    public static void main(String[] args) {
//        nestedSynchronizedTest();
//        multiThreadSynchronizedSameMethodTest();
        multiThreadSynchronizedDifferentMethodTest();
    }

    /**
     * 嵌套synchronized测试
     * */
    private static void nestedSynchronizedTest() {
        SafeDog safeDog = new SafeDog();
        safeDog.eatThenShout();
    }

    /**
     * 多线程调用相同synchronized方法测试
     * 结论: 多线程下排队调用，非公平锁
     * */
    private static void multiThreadSynchronizedSameMethodTest() {
        SafeDog safeDog = new SafeDog();
        Thread t1 = new Thread(() -> {
            try {
                safeDog.eatSlow();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                safeDog.eatSlow();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }

    /**
     * 多线程调用不同synchronized方法测试
     * 结论: 多线程下排队调用，非公平锁
     * */
    private static void multiThreadSynchronizedDifferentMethodTest() {
        SafeDog safeDog = new SafeDog();
        Thread t1 = new Thread(() -> {
            try {
                safeDog.eatSlow();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                safeDog.shoutSlow();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }

    private static class SafeDog {
        private synchronized void eat() {
            System.out.println("eat bonds");
        }
        private synchronized void shout() {
            System.out.println("wang wang");
        }
        private synchronized void eatSlow() throws InterruptedException {
            System.out.println(String.format("thread: %s call eatSlow, is going to sleeping....", Thread.currentThread().getName()));
            Thread.sleep(2000);
            System.out.println("eat bonds");
        }
        private synchronized void shoutSlow() throws InterruptedException {
            System.out.println(String.format("thread: %s call shoutSlow, is going to sleeping....", Thread.currentThread().getName()));
            Thread.sleep(2000);
            System.out.println("wang wang");
        }
        private synchronized void eatThenShout() {
            eat();
            shout();
        }
        public synchronized void eatThenShoutSlow() throws InterruptedException {
            eatSlow();
            shoutSlow();
        }
    }
}



