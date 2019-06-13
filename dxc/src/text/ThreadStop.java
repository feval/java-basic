package text;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/11 20:30
 */
class ThreadText implements Runnable{
    private boolean flag=true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        int i=0;
        while (flag) {
            System.out.println(Thread.currentThread().getName()+":"+i++);
        }
        System.out.println("停止了");
    }
}

public class ThreadStop {
    public static void main(String[] args) throws InterruptedException {
        ThreadText threadText=new ThreadText();
        Thread thread=new Thread(threadText,"线程A");
        thread.start();
        Thread.sleep(2000);
        threadText.setFlag(false);
        thread.join();

        System.out.println("-------------");
    }
}
