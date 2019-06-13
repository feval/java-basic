package lf;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 */

class MyThread extends Thread {
    private int ticket = 20;
    private String tittle;

    public MyThread(String tittle) {
        this.tittle = tittle;
    }

    @Override
    public void run() {
        while (ticket > 0) {
            System.out.println("当前线程为:" + this.tittle + this.ticket--);
        }
    }
}


class MyThread1 implements Runnable {
    private int ticket = 20;


    @Override
    public void run() {
        while (ticket > 0) {
            System.out.println("当前线程为:" + Thread.currentThread().getName() + "剩余" + this.ticket--);
        }
    }
}

class MyThread2 implements Callable<String> {
    private int ticket = 20;

    @Override
    public String call() throws Exception {
        while (this.ticket > 0) {
            System.out.println("当前线程为:" + Thread.currentThread().getName() + "剩余票数" + this.ticket--);
        }
        return "票卖完了";
    }
}

class MyThread3 implements Runnable {
    private int ticket = 20;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            synchronized (this) {
                if (this.ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("当前线程为:" + Thread.currentThread().getName() + "剩余" + this.ticket--);
                }
            }
        }
    }
}

class MyThread4 implements Runnable {
    private int ticket = 20;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.sellTicket();
        }
    }

    public synchronized void sellTicket() {
        if (this.ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程为:" + Thread.currentThread().getName() + "剩余" + this.ticket--);
        }

    }
}

public class ThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

/*        Thread thread1=new MyThread("A");
        Thread thread2=new MyThread("B");
        Thread thread3=new MyThread("C");
        thread1.start();
        thread2.start();
        thread3.start();*/
/*        MyThread1 mt1=new MyThread1();
        Thread thread1=new Thread(mt1);
        Thread thread2-=new Thread(mt1);
        Thread thread3=new Thread(mt1);
        thread1.start();
        thread2.start();
        thread3.start();*/
/*        FutureTask<String> task = new FutureTask<>(new MyThread2());
        Thread thread = new Thread(task);
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread.start();
        thread1.start();



        thread2.start();
        System.out.println(task.get());*/
/*        MyThread3 myThread3 = new MyThread3();
        Thread thread1 = new Thread(myThread3, "黄牛A");
        Thread thread2 = new Thread(myThread3, "黄牛B");
        Thread thread3 = new Thread(myThread3, "黄牛C");
        thread1.start();
        thread2.start();
        thread3.start();*/

/*        MyThread4 myThread4 = new MyThread4();
        Thread thread1 = new Thread(myThread4, "黄牛A");
        Thread thread2 = new Thread(myThread4, "黄牛B");
        Thread thread3 = new Thread(myThread4, "黄牛C");
        thread1.start();
        thread2.start();
        thread3.start();*/

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
