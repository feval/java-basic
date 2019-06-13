package suo;

import java.io.ObjectInputStream;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/12 19:55
 */
public class DeadLockTest {
    private static Object work=new Object();
    private static Object money=new Object();

    public static void main(String[] args) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (work) {
                    System.out.println("geiqian");
                    synchronized (money) {
                        System.out.println("gongzuo");
                    }
                }
            }
        });
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (money) {
                    System.out.println("gongzuo");
                    synchronized (work){
                        System.out.println("geiqian");
                    }
                }
            }
        });
        thread.start();
        thread1.start();
    }
}
