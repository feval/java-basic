package com.lf;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/13 19:07
 */
class Task2 implements Runnable {
    private Lock lock=new ReentrantLock(true);
    @Override
    public void run() {
        test();
    }
    private void test() {
        try{
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName()+"获取锁");
                Thread.sleep(2000);
            }else{
                System.out.println(Thread.currentThread().getName()+"获取锁失败");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
                lock.unlock();
        }
    }
}

public class LockTime {
    public static void main(String[] args) {
        Task2 task2=new Task2();
        Thread thread1=new Thread(task2,"A");
        Thread thread2=new Thread(task2,"B");
        thread1.start();
        thread2.start();
    }
}
