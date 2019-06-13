package suo;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/12 18:16
 */

class Sync{
    public static synchronized void test() throws InterruptedException {
        System.out.println("正在打印");
        Thread.sleep(2000);
        System.out.println("打印结束");
    }
}

class Task implements Runnable{
    @Override
    public void run() {
        try {
            Sync sync=new Sync();
            sync.test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SyncTest {
    public static void main(String[] args) {
        Task task=new Task();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}
