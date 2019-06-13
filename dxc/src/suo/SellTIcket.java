package suo;


/**
 * Description:
 * Author:  llf
 * Created in 2019/6/12 17:43
 */
class TicketTask implements Runnable {
    private int ticket = 20000;

    @Override
    public void run() {

        for (int i = 0; i < 20000; i++) {
            synchronized (this) {
                if (this.ticket > 0) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                    System.out.println(Thread.currentThread().getName() + "还剩下:" + ticket-- + "票");
                }
            }
//        sellTicket();
        }

    }

    private synchronized void sellTicket() {
        if (this.ticket>0) {
            System.out.println(Thread.currentThread().getName() + "还剩下:" + ticket-- + "票");
        }
    }
}

public class SellTIcket {
    public static void main(String[] args) {

        TicketTask ticketTask = new TicketTask();
        Thread thread1 = new Thread(ticketTask, "A");
        Thread thread2 = new Thread(ticketTask, "B");
        Thread thread3 = new Thread(ticketTask, "C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
