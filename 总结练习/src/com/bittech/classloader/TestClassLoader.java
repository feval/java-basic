package com.bittech.classloader;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
ClassLoader
1. AppClassLoader -> ExtClassLoader -> null(Bootstrap ClassLoader )
2. 自定义ClassLoader (高级特性)
   AppClassLoader 用来加载应用程序中的类（classpath ）
            E:\worskpace\java9_code\javase-0411\out\production\javase-0411
   ExtClassLoader 用来加载扩展目录中的类（jre\lib\ext  java.ext.dirs=xxx）
   BootStrap ClassLoader 用来加载启动JVM的类（jre\lib\rt.jar）
3. 类加载器的双亲委派模型
   3.1 处理顶层类加载器没有父类加载器，其它的类加载器都有父类加载器
   3.2 类加载的流程：加载一个类都要经过顶层的类加载器，
   如果顶层类加载器在它所加载的范围中找不到该类，就会反馈给子类加载器
4. 同一个类加载器中加载同一个类只有一个对应的Class对象
   不同的类加载器加载同一个类，对应的Class对象不同（不相等）
 */
public class TestClassLoader {

    public static void code1() {
        Class classz = TestClassLoader.class;
        System.out.println(classz.getClassLoader());
        System.out.println(classz.getClassLoader().getParent());
        System.out.println(classz.getClassLoader().getParent().getParent());
    }

    public static void code2() {
         /*
        Object o = new Object();//JDK Object  , Object
        System.out.println(o.getClass());
        System.out.println(Arrays.toString(o.getClass().getMethods()));
        */
        try {
            Class aClass = Class.forName("java.lang.String");
            System.out.println(aClass.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Class memberClass1 = Member.class;
        Class memberClass2 = new MyClassLoader().loadClassData("com.bittech.classloader.Member");
        System.out.println("memberClass1 : " + memberClass1.getClassLoader());
        System.out.println("memberClass2 : " + memberClass2.getClassLoader());
        System.out.println("memberClass1 == memberClass2 : " + (memberClass1 == memberClass2));
    }
}
