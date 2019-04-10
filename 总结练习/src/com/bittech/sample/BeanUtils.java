package com.bittech.sample;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtils {

    public static void setXxx(Object object, String attributeName, Object attributeValue) {
        Class classz = object.getClass();
        String setMethodName = "set" + attributeName.substring(0, 1).toUpperCase()
                + (attributeName.length() > 1 ? attributeName.substring(1) : "");
        try {
            Method setMethod = classz.getMethod(setMethodName, attributeValue.getClass());
            setMethod.invoke(object, attributeValue);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    /**
     * 对象的属性值拷贝
     * <p>
     * 将source对象中的属性值赋值到target对象中的属性，属性名一样，类型一样
     * <p>
     * example:
     * <p>
     * source:
     * <p>
     * String name;
     * String address;
     * Integer age;
     * Date   birthday;
     * <p>
     * target:
     * String name;
     * String address;
     * String email
     * <p>
     * 结果： source name, address -> target name, address
     *
     * @param source
     * @param target
     */
    public static void copy(Object source, Object target) {
        //TODO


    }
}
