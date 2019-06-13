package com.lf;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/13 18:56
 */

class Task1 implements Runnable {
    private Lock lock=new ReentrantLock();
    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            try{
                while (true) {
                    lock.lockInterruptibly();
                }
            } catch (InterruptedException e) {
                System.out.println("线程响应中断");
                return;
            } finally {
                lock.unlock();
            }
        }
    }
}
public class LockInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Task1 task=new Task1();
        Thread thread1=new Thread(task);
        thread1.start();
        Thread.sleep(2000);
        thread1.interrupt();
    }
}
