/**
 * Description:
 * Author:  llf
 * Created in 2019/6/12 17:06
 */

class Inter implements Runnable {
    @Override
    public void run() {
        while(true) {
            System.out.println("当前线程是否为守护线程"+Thread.currentThread().isDaemon());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("当前线程是否为守护线程"+Thread.currentThread().isDaemon());
                System.out.println("线程被终止");
                return;
            }
        }
    }
}

public class TestInterrupt {
    public static void main(String[] args) throws InterruptedException {
/*        Inter inter=new Inter();
        Thread thread1=new Thread(inter);
        Thread thread2=new Thread(inter);
        Thread thread3=new Thread(inter);
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MIN_PRIORITY);
        System.out.println("主线程执行完毕");*/
        Inter inter = new Inter();
        Thread thread1=new Thread(inter,"A");
        Thread thread2=new Thread(inter,"B");
        thread1.setDaemon(true);
        thread1.start();
        thread2.start();
        Thread.sleep(3000);
        thread2.interrupt();
        Thread.sleep(5000);
        System.out.println("代码结束..");
    }
}
