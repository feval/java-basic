package lf;

/**
 *
 */
class Goods{
    private String name;
    private int count;

    public synchronized void set(String name) {
        this.name=name;
        count++;
    }
    public synchronized void get() {
        count--;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}

class Pro implements Runnable{
    private Goods goods;

    public Pro(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        this.goods.set("车");

    }

    @Override
    public String toString() {
        return "pro{" +
                "goods=" + goods +
                '}';
    }
}

class Cum implements Runnable{
    private Goods goods;

    public Cum(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        this.goods.get();
    }

    @Override
    public String toString() {
        return "cum{" +
                "goods=" + goods +
                '}';
    }
}



public class CPTest {
    public static void main(String[] args) {
        Goods goods=new Goods();
        Pro pro=new Pro(goods);
        Cum cum=new Cum(goods);
        //

    }
}
