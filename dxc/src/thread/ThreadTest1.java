package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/11 18:47
 */





class My extends Thread{
    private int count=20;
    @Override
    public void run() {
        while(count>0) {
            System.out.println(count--);
        }
    }
}

class My1 implements Runnable{
    private String title;
    private int count=20;
    public My1(String title) {
        this.title = title;
    }
    @Override
    public void run() {
        while(count>0) {
            System.out.println(String.valueOf(Thread.currentThread())+count--);
        }
    }
}

class My3 implements Callable<String>{
    private int ticket=2000;
    @Override
    public String  call() throws Exception {
        while (ticket>0) {
            System.out.println("当前线程为"+Thread.currentThread().getName()+"----"+ticket--);
            Thread.sleep(2000);
        }
        return "没票了";
    }
}




public class ThreadTest1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
/*        My my1=new My();
        My my2=new My();
        My my3=new My();
        my1.start();
        my2.start();
        my3.start();*/
        /*My1 my1=new My1("A");
        Thread thread1=new Thread(my1);
        Thread thread2=new Thread(my1);
        Thread thread3=new Thread(my1);
        thread1.start();
        thread2.start();
        thread3.start();
*/
        My3 my3=new My3();

        FutureTask<String> futureTask=new FutureTask<>(my3);
        Thread thread1=new Thread(futureTask);
        Thread thread2=new Thread(futureTask);
        Thread thread3=new Thread(futureTask);
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println(futureTask.get());


    }



}
