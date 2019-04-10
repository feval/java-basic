package com.bittech.pattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestPattern {

    public static void main(String[] args) {
//        Subject realSubject = new RealSubject();
//        Subject proxySubject = new ProxySubject(realSubject);
//        proxySubject.eat();

//        Subject realSubject =
//                ProxyFactory.getInstance("com.bittech.pattern.RealSubject");
//        if (realSubject != null) {
//            Subject proxySubject =
//                    ProxyFactory.getInstance("com.bittech.pattern.ProxySubject", realSubject);
//            if (proxySubject != null) {
//                proxySubject.eat();
//            }
//        }

        Subject proxySubject = ProxyFactory.getProxyInstance(
                "com.bittech.pattern.RealSubject",
                "com.bittech.pattern.ProxySubject2"
        );
        if (proxySubject != null) {
            proxySubject.eat();
        }
    }

}

//代理接口
interface Subject {

    void eat();
}

interface Message {

    String greeting(String name);
}

//工厂
class ProxyFactory {

    private ProxyFactory() {

    }

    //获取业务对象
    public static <T> T getInstance(String className) {
        try {
            Class cls = Class.forName(className);
            return (T) cls.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }


    //获取代理对象
    public static <T> T getInstance(String className, Object realObject) {
        try {
            Class cls = Class.forName(className);
            //代理接口的类型
            Class interfaceCls = cls.getInterfaces()[0];
            Constructor constructor = cls.getConstructor(interfaceCls);
            return (T) constructor.newInstance(realObject);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static <T> T getProxyInstance(String realClassName, String proxyClassName) {
        Subject realSubject =
                ProxyFactory.getInstance(realClassName);
        if (realSubject != null) {
            Subject proxySubject =
                    ProxyFactory.getInstance(proxyClassName, realSubject);
            if (proxySubject != null) {
                return (T) proxySubject;
            }
        }
        return null;
    }

}

//真实业务类
class RealSubject implements Subject, Message {

    @Override
    public void eat() {
        System.out.println("吃饭");
    }

    @Override
    public String greeting(String name) {
        System.out.println(name);
        return "欢迎 " + name;
    }
}

class RealSubject2 {

    public void eat() {
        for (int i = 0; i < 1000; i++) {

        }
        System.out.println("吃饭");
    }

    public String greeting(String name) {
        for (int i = 0; i < 10000; i++) {

        }
        System.out.println(name);
        return "欢迎 " + name;
    }
}

//代理类
class ProxySubject implements Subject {

    private final Subject target;

    public ProxySubject(Subject target) {
        this.target = target;
    }

    private void before() {
        System.out.println(" 做饭 ");
    }

    @Override
    public void eat() {
        this.before();
        target.eat();
        this.after();
    }

    private void after() {
        System.out.println(" 洗完 ");
    }
}

class ProxySubject2 implements Subject {
    private final Subject target;

    public ProxySubject2(Subject target) {
        this.target = target;
    }

    private void before() {
        System.out.println(" 做饭 ");
    }

    @Override
    public void eat() {
        this.before();
        target.eat();
        this.after();
    }

    private void after() {
        System.out.println(" 不洗碗 ");
    }
}

