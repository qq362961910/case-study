package com.jy.casestudy.jdk.queue;

import cn.t.util.common.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueDemo {

    private static final Logger logger = LoggerFactory.getLogger(ArrayBlockingQueueDemo.class);

    public static void main(String[] args) throws InterruptedException {
        LoggerUtil.setSlf4jRootLoggerLevel(Level.INFO);
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(2);
        new Thread(new ArrayBlockingQueueProvider(arrayBlockingQueue)).start();
        Thread.sleep(5000);
        new Thread(new ArrayBlockingQueueConsumer(arrayBlockingQueue)).start();
        logger.info("main exit");
    }

    private static class ArrayBlockingQueueProvider implements Runnable {

        private static final Logger logger = LoggerFactory.getLogger(ArrayBlockingQueueProvider.class);

        private ArrayBlockingQueue<String> arrayBlockingQueue;

        private ArrayBlockingQueueProvider(ArrayBlockingQueue<String> arrayBlockingQueue) {
            this.arrayBlockingQueue = arrayBlockingQueue;
        }

        @Override
        public void run() {
            int index = 0;
            while (true) {
                try {
                    boolean success = arrayBlockingQueue.offer(String.valueOf(index), 1, TimeUnit.SECONDS);
                    if (success) {
                        index++;
                        logger.info("[produce]: produce a message");
                    } else {
                        logger.info("[produce]: queue full");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
            logger.info("provider exit");
        }
    }

    private static class ArrayBlockingQueueConsumer implements Runnable {

        private static final Logger logger = LoggerFactory.getLogger(ArrayBlockingQueueConsumer.class);

        private ArrayBlockingQueue<String> arrayBlockingQueue;

        private ArrayBlockingQueueConsumer(ArrayBlockingQueue<String> arrayBlockingQueue) {
            this.arrayBlockingQueue = arrayBlockingQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String m = arrayBlockingQueue.poll(1, TimeUnit.SECONDS);
                    Thread.sleep(1000);
                    logger.info("[consume] a message: {}", m);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
            logger.info("consumer exit");
        }
    }

}
