package com.bittech.pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//动态代理时需要实现InvocationHandle接口，用于编写增强的业务功能
public class RealSubjectHandler implements InvocationHandler {

    private Object target;

    public RealSubjectHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("这是代理增强代码A");
        //目标对象（被代理对象）的方法执行
        Object returnValue = method.invoke(target, args);
        System.out.println("这是代理增强代码B");
        return returnValue;
    }
}
