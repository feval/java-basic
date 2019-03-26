//单例饿汉式实现
public class Singleton {

    private final static Singleton INSTANCE = new Singleton();

    private Singleton(){
    }

    public static Singleton getInstance(){
        return INSTANCE;
    }
	public static void main(String [] args){
    //输出：true 单例正确，否则错误
    System.out.println(Singleton.getInstance()==Singleton.getInstance()); 
    System.out.println(Singleton1.getInstance()==Singleton1.getInstance());
    System.out.println(Singleton2.getInstance()==Singleton2.getInstance());
    System.out.println(Singleton3.getInstance()==Singleton3.getInstance());
	System.out.println(Singleton4.getInstance()==Singleton4.getInstance());
    System.out.println(Singleton5.getInstance()==Singleton5.getInstance());
	System.out.println(Singleton6.getInstance()==Singleton6.getInstance());

	}
}

class Singleton1 {

    private static Singleton1 instance;

    static {
        instance = new Singleton1();
    }

    private Singleton1() {}

    public static Singleton1 getInstance() {
        return instance;
    }
}
//懒汉式
class Singleton2 {

    private static Singleton2 singleton;

    private Singleton2() {}

    public static Singleton2 getInstance() {
        if (singleton == null) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}

class Singleton3 {

    private static Singleton3 singleton;

    private Singleton3() {}

    public static synchronized Singleton3 getInstance() {
        if (singleton == null) {
            singleton = new Singleton3();
        }
        return singleton;
    }
}

class Singleton4 {

    private static Singleton4 singleton;

    private Singleton4() {}

    public static Singleton4 getInstance() {
        if (singleton == null) {
            synchronized (Singleton4.class) {
                singleton = new Singleton4();
            }
        }
        return singleton;
    }
}

class Singleton5 {

    private static volatile Singleton5 singleton;

    private Singleton5() {}

    public static Singleton5 getInstance() {
        //双重检查
        if (singleton == null) {
            synchronized (Singleton5.class) {
                if (singleton == null) {
                    singleton = new Singleton5();
                }
            }
        }
        return singleton;
    }
}

class Singleton6 {

    private static volatile Singleton6 singleton;

    private Singleton6() {}

    public static Singleton6 getInstance() {
        //双重检查
        if (singleton == null) {
            synchronized (Singleton6.class) {
                if (singleton == null) {
                    singleton = new Singleton6();
                }
            }
        }
        return singleton;
    }
}













