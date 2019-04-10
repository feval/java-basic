package com.bittech.pattern;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.*;
import java.util.Arrays;

public class TestProxy {

    public static void code1() {
        //1. 代理接口      Subject
        //2. 业务类        RealSubject
        //3. 增强业务处理类 RealSubjectHandler
        //4. 代理类  （代理对象）
        //JDK动态代理技术
        Subject realSubject = new RealSubject();
        InvocationHandler handler = new RealSubjectHandler(realSubject);
        Message proxyObject = (Message) Proxy.newProxyInstance(
                RealSubject.class.getClassLoader(),
                new Class[]{Subject.class, Message.class},
                handler
        );
        //1. 代理类是谁？
        //2. 代理类谁写的？
        //3. 为什么通过Proxy获取代理类的对象时要传入ClassLoader


//        proxyObject.eat();
//        System.out.println(proxyObject.greeting("Jack"));

        //1. com.bittech.pattern.$Proxy0
        //implements Subject , Message
        System.out.println("代理类：" + proxyObject.getClass());
        System.out.println("代理类的接口：" +
                Arrays.toString(proxyObject.getClass().getInterfaces()));
        System.out.println("代理类的方法：");
        for (Method m : proxyObject.getClass().getDeclaredMethods()) {
            System.out.println(m.getName());
        }
        System.out.println("代理类的属性");
        for (Field field : proxyObject.getClass().getDeclaredFields()) {
            System.out.println(field.getName() + " " + field.getType());
        }
        System.out.println("代理类的构造方法");
        for (Constructor constructor : proxyObject.getClass().getConstructors()) {
            System.out.println(constructor.getName() +
                    Arrays.toString(constructor.getParameterTypes()));
        }

        //2. 动态代理的代理类是由JVM运行时动态生成的
        //java source -> class -> jvm
        //程序生成一个Java源代码（定义类）
        //程序生成一个Class文件 asm库

        //3. 动态生成了一个代理类
        //3. 动态生成了一个代理类
    }

    public static void main(String[] args) {

        //CGLIB API
        RealSubject2 subject2 = new RealSubject2();
        CglibHandler cglibHandler = new CglibHandler(subject2);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(subject2.getClass());
        enhancer.setCallback(cglibHandler);
        RealSubject2 proxyObject = (RealSubject2) enhancer.create();
//        System.out.println(proxyObject.getClass());
//        System.out.println(proxyObject.getClass().getSuperclass());

        proxyObject.eat();

        String str = proxyObject.greeting("张三");
        System.out.println(str);
    }
}

class CglibHandler implements MethodInterceptor {

    private final Object target;

    public CglibHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //业务对象的方法调用
        long startTime = System.currentTimeMillis();
        Object returnValue = method.invoke(this.target, objects);
        long endTime = System.currentTimeMillis();
        System.out.println("方法：" + method.getName() + " 执行时间 " +
                (endTime - startTime) + " ms");
        return returnValue;
    }
}

