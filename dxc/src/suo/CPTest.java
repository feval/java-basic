package suo;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/12 21:11
 */

class Goods {
    private String goodsName;
    private int count;
    private int max_count;

    public Goods(int max_count) {
        this.max_count = max_count;
    }

    public synchronized void set(String goodsName) {
        while (count==max_count) {
            System.out.println("还有商品");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.goodsName=goodsName;
        count++;
        System.out.println(Thread.currentThread().getName()+"生产"+this);
        this.notifyAll();
    }
    public synchronized void get() {
        if (count==0) {
            System.out.println("卖完了,");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getName()+"消费"+this);
        this.notify();
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsName='" + goodsName + '\'' +
                ", count=" + count +
                '}';
    }
}
class Produce implements Runnable{
    private Goods goods;

    public Produce(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true) {
            goods.set("黑瓶子");
        }
    }
}
class Custom implements Runnable{
    private Goods goods;

    public Custom(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true) {
            goods.get();
        }
    }
}
public class CPTest {
    public static void main(String[] args) throws InterruptedException {
        Goods goods=new Goods(20);
        Produce produce=new Produce(goods);
        Custom custom=new Custom(goods);
        Thread threadProduce=new Thread(produce);
        Thread threadCustom=new Thread(custom);
        threadCustom.start();

        Thread.sleep(1000);
        threadProduce.start();
    }
}
