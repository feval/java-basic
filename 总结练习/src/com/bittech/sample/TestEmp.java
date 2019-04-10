package com.bittech.sample;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestEmp {

    public static void main(String[] args) {
        //需求：将一个字符串的内容赋值给Emp对象的属性
        //描述：
        //比如 "name:张三|job:SoftDeveloper"
        //name -> Emp对象的name属性值就是张三
        //job -> Emp对象的job属性值就是SoftDeveloper
        //实现：
        //1. 拆分字符串  先 | 再 ：
        //2. 实例化对象 赋值

        String value = "name:张三|job:SoftDeveloper|skill:php,c++";

        String[] attributeNameAndValues = value.split("\\|");
        Emp emp = new Emp();
        //setter => setXxx 属性名的首字母大写
        for (String nameAndValue : attributeNameAndValues) {
            String[] nv = nameAndValue.split(":");
//            setXxx(emp, nv[0], nv[1]);

            BeanUtils.setXxx(emp, nv[0], nv[1]);
        }

        System.out.println(emp);
    }

    public static void setXxx(Object object, String name, String value) {
        Class classz = object.getClass();
        //age -> Age
        //setXxx -> setAge
        String setMethodName = "set" + name.substring(0, 1).toUpperCase()
                + (name.length() > 1 ? name.substring(1) : "");
        try {
            Method setMethod = classz.getMethod(setMethodName, name.getClass());
            setMethod.invoke(object, value);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //通过Field直接修改
    }
}
