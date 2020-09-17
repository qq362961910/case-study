package com.jy.casestudy.jdk.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerUsage {
    private static int index = 0;
    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("index: " + index++);
            }
        }, 3000, 1000);
    }
}
