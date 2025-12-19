package com.leetcode.other;

import java.util.concurrent.atomic.AtomicInteger;

public class AddInteger {
    static AtomicInteger n = new AtomicInteger(0);
//    static Object lock = new Object();
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                        for (int j = 0; j < 50; j++) {
                            n.getAndIncrement();
                            System.out.println(Thread.currentThread().getName() + ": " + n);
                        }
                }
            }).start();
        }
    }
}
