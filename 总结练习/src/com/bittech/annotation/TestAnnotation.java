package com.bittech.annotation;

import java.io.Serializable;
import java.lang.annotation.*;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/*
自定义注解：
1. @interface , 指定target  指定 Retention
2. 定义方法（抽象）
3. 使用注解
3.1 如果方法没有提供默认值，需要指定值
3.2 如果方法提供了默认值，可以选择指定值

 */
public class TestAnnotation {

    public static void code1() {
        Class cls = Member2.class;
        Annotation[] annotations = cls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.toString());
        }//只输出的@Deprecated

        try {
            Method method = cls.getMethod("toString");
            Annotation[] annotations1 = method.getAnnotations();
            for (Annotation annotation : annotations1) {
                System.out.println(annotation.toString());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Class cls = Member3.class;
        MyAnnotation annotation = (MyAnnotation) cls.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.getClass());
        System.out.println(annotation.toString());
        System.out.println(annotation.age());
        System.out.println(annotation.name());
    }
}

@SuppressWarnings(value = {"unused"}) //?
@Deprecated
class Member2 implements Serializable {

    @Override //?
    @Deprecated
    public String toString() {
        return super.toString();
    }
}

@MyAnnotation(name = "lisi", age = 22)
class Member3 {

}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String name() default "张三";

    int age();
}