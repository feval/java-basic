package suo;

import java.io.ObjectInputStream;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/12 20:41
 */

class Throwball implements Runnable {
    private boolean flag;
    private  Object ball;
    public Throwball(boolean flag, Object ball) {
        this.flag = flag;
        this.ball = ball;
    }

    @Override

    public void run() {
        if (flag) {
            Qiangball();
        }else {
            Renball();
        }
    }

    private void Qiangball() {
        synchronized (ball) {
            System.out.println("痴汉"+Thread.currentThread().getName()+"等待抢球");
            try {
                ball.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("痴汉"+Thread.currentThread().getName()+"强到了求");
        }
    }

    private void Renball() {
        synchronized (ball) {
            System.out.println("女神"+Thread.currentThread().getName()+"扔");
            ball.notifyAll();
            System.out.println("领证");
        }

    }
}
public class Text1 {
    public static void main(String[] args) throws InterruptedException {
        Object ball=new Object();
        Thread thread=new Thread(new Throwball(true,ball),"A");
        Thread thread2=new Thread(new Throwball(true,ball),"B");
        Thread thread3=new Thread(new Throwball(false,ball),"c");
        thread.start();
        thread2.start();
        Thread.sleep(1000);
        thread3.start();
    }
}
