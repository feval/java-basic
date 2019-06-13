package com.lf;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/13 17:59
 */
class Task implements Runnable {

        private int ticket=20;
        private Lock ticketLock=new ReentrantLock();
        @Override
        public void run() {
        for (int i = 0; i <20 ; i++) {
            try{
                ticketLock.lock();
                if (ticket>0) {
                    System.out.println(Thread.currentThread().getName()+"还剩下"+ticket--+"票");
                }
            }finally {
                ticketLock.unlock();
            }
        }
    }
}

public class LockTest{
    public static void main(String[] args) {
        Task task=new Task();
        Thread thread1=new Thread(task);
        Thread thread2=new Thread(task);
        Thread thread3=new Thread(task);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
