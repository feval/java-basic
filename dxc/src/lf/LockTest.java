package lf;

import sun.misc.Lock;

/**
 *
 */


class Task implements Runnable{
    private int ticket=2000;
    private Lock lock=new Lock();

    @Override
    public void run() {
        for (int i = 0; i <2000 ; i++) {
            try{
                try {
                    lock.lock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticket>0) {
                    System.out.println(Thread.currentThread().getName()+"还剩下:"+ticket--+"票");
                }
            }
            finally {
                lock.unlock();
            }
        }

    }
}

class TaskInterrupt implements Runnable{

    @Override
    public void run() {

    }
}
public class LockTest {
    public static void main(String[] args) {
        Task task=new Task();
        Thread thread=new Thread(task);
        Thread thread2=new Thread(task);
        Thread thread3=new Thread(task);
        thread.start();
        thread2.start();
        thread3.start();
    }
}
